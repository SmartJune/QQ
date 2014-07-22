import java.io.Serializable;

public class User implements Serializable{
	
	private String name;
	private String password;
	public void setUserId(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}
	public String getUserId() {
		// TODO Auto-generated method stub
		return name;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
}
