package pandanew.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao{
	private Connection connection;

	protected final Connection getConnection(){
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		
		try{
			connection = DriverManager.getConnection("jdbc:postgresql://ec2-79-125-4-96.eu-west-1.compute.amazonaws.com:5432/ddcue537ga2q9o?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
					"apfknhnihnpjun",
					"d4c9ce51634fbe93c050a829c5799bba8f44254058543b4f251326f2ba321d7d");
		}catch (SQLException e) {
			e.printStackTrace();

			
		}
		return connection;

	}
}
