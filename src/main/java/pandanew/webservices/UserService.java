package pandanew.webservices;

import java.util.List;

import pandanew.daos.UserDao;
import pandanew.objects.User;

public class UserService {
	UserDao UserDao = new UserDao();
	
	public List<User> getAllUsers(){
		return UserDao.findAll();
	}
	public User getUserByName(String name) {
		User result = UserDao.findByName(name);
			
		return result;
	}
	public User updateLasttime(User user){
		User result = UserDao.updateLasttime(user);
		return result;
	}
}

