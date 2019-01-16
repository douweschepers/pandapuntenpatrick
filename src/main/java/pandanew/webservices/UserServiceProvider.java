package pandanew.webservices;

public class UserServiceProvider {
	private static UserService userservice = new UserService();
	
	public static UserService getUserService(){
		return userservice;
	}
}
