package com.omg.cmn;

public class Message extends DTO {

	/**
	 * 메시�? ID : 10
	 */
	private String msgId;
	
	/**
	 * 메시�? ?��?��: ?��록되?��?��?��?��.
	 */
	private String msgContents;
	
	public Message() {
		
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgContents() {
		return msgContents;
	}

	public void setMsgContents(String msgContents) {
		this.msgContents = msgContents;
	}

	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", msgContents=" + msgContents + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
