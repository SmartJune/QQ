import java.io.*;


public class Message implements Serializable {

	private String messageType;
	private String content;
	private String from;
	private String to;
	
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
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public void setFrom(String from){
		this.from = from;
	}
	public void setTo(String to){
		this.to = to;
	}
	
}
