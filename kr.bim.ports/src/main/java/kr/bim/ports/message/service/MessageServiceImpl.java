package kr.bim.ports.message.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.web.base.BaseService;

import kr.bim.ports.message.dao.MessageDAO;
import kr.bim.ports.message.dao.MessageDTO;

//@Repository
@Service("messageService")
public class MessageServiceImpl extends BaseService implements IMessageService {

	@Resource(name="MessageDAO")
	private MessageDAO messageDAO;
	
	@Override
	public List<MessageDTO> list(String to_user_id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MessageServiceImpl");
		HashMap<String, Object> selectMap = new HashMap<String, Object>();	
		selectMap.put("to_user_id", to_user_id);
		return (List<MessageDTO>) messageDAO.list(selectMap);
	}




	@Override
	public int delete(int seq) throws Exception {
		// TODO Auto-generated method stub
		//seq가  0보다 크니 체크하기
		//파라미터값받아주고 viewmodel 에서 처리.
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("seq", seq);
		return messageDAO.delete(hmap);
	}


}