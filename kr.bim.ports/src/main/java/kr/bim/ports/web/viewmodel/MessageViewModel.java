package kr.bim.ports.web.viewmodel;

import java.util.List;

import com.web.base.BaseViewModel;

import kr.bim.ports.message.dao.MessageDTO;

public class MessageViewModel extends BaseViewModel {
//baseVieModel == 자동으로 설정된 사항들이 있음
	// 데이터가져오는 로직, 데이터 넘기는로직
	private List<MessageDTO> recodesMsg;
	private MessageDTO messageDTO;
	
	
	
	
	
	public MessageDTO getMessageDTO() {
		return messageDTO;
	}

	public void setMessageDTO(MessageDTO messageDTO) {
		this.messageDTO = messageDTO;
	}

	public List<MessageDTO> getRecodesMsg() {
		return recodesMsg;
	}

	public void setRecodesMsg(List<MessageDTO> recodesMsg) {
		this.recodesMsg = recodesMsg;
	}
	
	
	
	
}