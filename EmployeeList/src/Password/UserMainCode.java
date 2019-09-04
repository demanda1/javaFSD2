package Password;

public class UserMainCode {
	
	public static boolean checkPassword(String password) {
		
		if(password.length()>=8 && password.matches(".*[a-z].*") && password.matches("[A-Z].*") && password.matches(".*[0-9].*" )
				&& password.matches(".*[@#$!&].*")) {
			return true;
		}
		return false;
	}
}
