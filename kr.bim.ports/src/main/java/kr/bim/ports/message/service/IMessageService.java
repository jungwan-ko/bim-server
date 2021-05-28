package kr.bim.ports.message.service;

import java.util.HashMap;
import java.util.List;

import kr.bim.ports.message.dao.MessageDTO;

public interface IMessageService {

	//List testList(MessageDTO to) throws Exception;

	List<MessageDTO> list(String to_user_id) throws Exception;


	//Object list(Object setLoginUserID);

	int delete(int seq) throws Exception;

	

}