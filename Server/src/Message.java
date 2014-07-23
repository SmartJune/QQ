import java.io.*;


public class Message implements Serializable {

	private String messageType;
	private String content;
	
	public String getMessageType(){
		return messageType;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return content;
	}
	public void setMessageType(String messageType){
		this.messageType = messageType;
	}
	
}
