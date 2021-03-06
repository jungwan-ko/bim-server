package com.web.base.meta.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.base.BaseService;
import com.web.base.meta.dao.IMetaLawDao;
import com.web.base.meta.dao.MetaAdmDTO;
import com.web.base.meta.dao.MetaLawDTO;

@Service("metaLawService")
public class MetaLawServiceImpl extends BaseService implements IMetaLawService {
		
	@Autowired
	private IMetaLawDao codeLawDao;

	@Override
	public int creataData() {
		String fpath = getClass().getResource("/config/foundation/KIKcd_B.xlsx").getFile();
		OPCPackage opcPackage = null;
		XSSFWorkbook workbook = null;
				
		try {
			opcPackage = OPCPackage.open(new FileInputStream(fpath));
			workbook = new XSSFWorkbook(opcPackage);
			
			opcPackage.close();
		}catch (InvalidFormatException e) {
			e.printStackTrace();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		List<MetaLawDTO> createExcel = new ArrayList<MetaLawDTO>();
		Sheet workSheet = workbook.getSheetAt(0); //// 첫번째 Sheet //wb.getSheet("Hola");
		//Iterator<Row> rowIterator = workSheet.iterator();

		int rowSize = workSheet.getLastRowNum() + 1; // 행의 총 개수 (행은 0부터  시작함)
		for (int i = 1; i < rowSize; i++) { // i를 1부터 시작해야 두번째 행부터 데이터가  입력된다.
				Row row = workSheet.getRow(i);

				int cellLength = (int) row.getLastCellNum(); // 열의 총 개수

				String valueStr = ""; // 엑셀에서 뽑아낸 데이터를 담아놓을 String 변수 선언 및 초기화
				MetaLawDTO lawDTO = new MetaLawDTO(); // DB에 Insert하기  위해  valueStr  데이터를 옮겨담을 객체 (각자 DB  테이블의 데이터 타입에  맞춰서...)

				for (int j = 0; j < cellLength; j++) {
					Cell cell = row.getCell(j);

					// 셀에 있는 데이터들을 타입별로 분류해서 valueStr 변수에 담는다.
					if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) { // CELL_TYPE_BLANK로만  체크할  경우  비어있는 셀을 놓칠  수  있다.
						valueStr = "";
					} else {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							valueStr = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC: // 날짜 형식이든 숫자 형식이든 다  CELL_TYPE_NUMERIC으로  인식함.
							if (DateUtil.isCellDateFormatted(cell)) { // 날짜 유형의  데이터일  경우,
								SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
								String formattedStr = dateFormat.format(cell.getDateCellValue());
								valueStr = formattedStr;
								break;
							} else { // 순수하게 숫자 데이터일 경우,
								Double numericCellValue = cell.getNumericCellValue();
								if (Math.floor(numericCellValue) == numericCellValue) {// 소수점  이하를 버린 값이 원래의 값과 같다면,,
									valueStr = numericCellValue.intValue() + ""; // int형으로 소수점 이하 버리고 String으로 데이터 담는다.
								} else {
									valueStr = numericCellValue + "";
								}
								break;
							}
						case Cell.CELL_TYPE_BOOLEAN:
							valueStr = cell.getBooleanCellValue() + "";
							break;
						}
					}

					// 담아놨던 valueStr 데이터를 셀 순서대로 DTO에 set.
					switch (j) {
						case 0:
							lawDTO.setLaw_code(valueStr);break;
						case 1:
							lawDTO.setLaw_sido(valueStr);break;
						case 2:
							lawDTO.setLaw_sigungu(valueStr);break;
						case 3:
							lawDTO.setLaw_dong(valueStr);break;
						case 4:
							lawDTO.setLaw_ri(valueStr);break;
						case 5:
							lawDTO.setCode_create_day(valueStr);break;
						case 6:
							lawDTO.setCode_delete_day(valueStr);break;
				} // switch end
			} // for loop(j) end (Cells)
				createExcel.add(lawDTO);
		} // for loop(i) end (Rows)				
		codeLawDao.createData(createExcel);
		return 0;
	}
	
	
	@Override
	public List<MetaLawDTO> listSido() {		
		return codeLawDao.listSido();
	}

	@Override
	public List<MetaLawDTO> listGungu(String paramSido) {
		HashMap<String, Object>  paramMap=new HashMap<String, Object>();
		paramMap.put("law_code",paramSido);
		return codeLawDao.listGungu(paramMap);
	}

	@Override
	public List<MetaLawDTO> listDong(String paramGungu) {
		HashMap<String, Object>  paramMap=new HashMap<String, Object>();
		paramMap.put("law_code",paramGungu);
		return codeLawDao.listDong(paramMap);
	}
	
	@Override
	public List<MetaLawDTO> listRi(String paramDong) {
		HashMap<String, Object>  paramMap=new HashMap<String, Object>();
		paramMap.put("law_code",paramDong);
		return codeLawDao.listRi(paramMap);
	}

}
