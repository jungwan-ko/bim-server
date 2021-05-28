package kr.bim.ports.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.base.BaseController;

import kr.bim.ports.message.dao.MessageDTO;
import kr.bim.ports.message.service.IMessageService;
import kr.bim.ports.web.viewmodel.MessageViewModel;

@Controller("messageController")
public class MessageController extends BaseController{
//	@Resource(name="messageService")
//	private IMessageService messageService;
	
	@Autowired
	private IMessageService iMessageService;
	
	@RequestMapping(value = "/msgDir/messages/list", method = RequestMethod.GET)
	public @ResponseBody List<MessageDTO>  msgList( MessageViewModel msgVm ,String to_user_id, Model model) throws Exception {
		//DTO == databases/ ㅁ목적에맞게
		
		//testdyd
		to_user_id = "touser01";
		List<MessageDTO> getSelect = (List<MessageDTO>) iMessageService.list(to_user_id);
		//msgVm.getRecodesMsg(iMessageService.list(getCommonParams().setLoginUserID()));
		//msgVm.setRecodesMsg(iMessageService.list(to_user_id));
		//return (List<MessageDTO>) msgVm;
		System.out.println("controller ");
		return getSelect;
	//controller model(service,DAO)
	}
	
	
	
	@RequestMapping(value = "/msgDir/Message/delete", method = RequestMethod.POST)
		public @ResponseBody int deleteMsg(@RequestBody MessageDTO param) throws Exception{
		//HashMap<String, String> hMap = new HashMap<String, String>();
		
//		int result=0;
//		//result = iMessageService.delete(seq);
//		MessageDTO mto = new MessageDTO();
		//create_date = mto.set
		
		return 0;
	}
} 