package tw.com.fcb.foodTest;

class MemberIDException extends Exception{
	public MemberIDException(String id) {
		super("管理者 " + id + " 驗證失敗");
	}
}

// Check Admin Password
public class UserService {
	public String CheckID(String userPwd) throws MemberIDException{
		String msgString = "";
		try {
			if(userPwd.equals("12345678")) {
				msgString = "OK";
			}
			else {
				throw new MemberIDException(userPwd);
			}
		}
		catch(MemberIDException e) {
			msgString = e.getMessage();
		}
		return msgString;
	}
}
