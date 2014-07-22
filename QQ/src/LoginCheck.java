
public class LoginCheck {

	public boolean checkUser(User u){
		
		return new ConnectToServer().sendLoginInfoToServer(u);
	}
}
