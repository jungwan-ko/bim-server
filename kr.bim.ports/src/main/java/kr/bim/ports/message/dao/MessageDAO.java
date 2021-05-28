package kr.bim.ports.message.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.web.base.BaseDao;

@Repository("MessageDAO")
public class MessageDAO extends BaseDao{

	public List<MessageDTO> list (HashMap<String, Object> selectMap){
		System.out.println("MessageDAO");
		return (List<MessageDTO>) selectList("MessageDAO.list", selectMap);
	}
	
	
	public int delete(HashMap<String, Object> paramMap) {
		System.out.println("delete Messagedatas by create_date");
		
		//
		
		return delete("MessageDAO.delete", paramMap);
		
	}
	
}
