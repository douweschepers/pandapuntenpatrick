package pandanew.objects;

import java.sql.Date;

public class User {
	private String userName;
	private String lasttime;
	
	public User(String userName, String lasttime){
		this.userName = userName;
		this.lasttime = lasttime;
	}

	public String getLasttime() {
		return lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
