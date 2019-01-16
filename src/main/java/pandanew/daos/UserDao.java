package pandanew.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import pandanew.objects.User;

public class UserDao extends BaseDao{

	public List<User> findAll(){
		List<User> results = new ArrayList<User>();
		try(Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery("Select * from public."+'"'+ "User"+'"');
			while(dbResultSet.next()){
				String username = dbResultSet.getString("firstname");
				String lasttime = dbResultSet.getString("time");
				
				User newUser = new User(username,lasttime);
				results.add(newUser);
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return results;
	}
	public User updateLasttime(User user){
		String timeStamp = new SimpleDateFormat("yyyy-dd-MM").format(Calendar.getInstance().getTime());
		
		System.out.println(timeStamp);
		String query = "update public."+'"'+ "User"+'"'+ "set time ='" + timeStamp + "' where firstname='" + user.getUserName()+"';" ;
		try (Connection con = super.getConnection()){
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
        	System.out.println("DB connection: failed");
            e.printStackTrace();
        }
         return findByName(user.getUserName());
    }
	public User findByName(String name){
		User newUser = null;
		try(Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery("select * from public."+'"'+ "User"+'"'+ "where firstname='" + name+"'");
			while (dbResultSet.next()) {
		        String firstname = dbResultSet.getString("firstname");
		        String lasttime = dbResultSet.getString("time");
		        
		        newUser = new User(firstname,lasttime);
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return newUser;
		}
}
