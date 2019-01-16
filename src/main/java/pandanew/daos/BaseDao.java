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
			connection = DriverManager.getConnection("jdbc:postgresql://ec2-79-125-4-96.eu-west-1.compute.amazonaws.com:5432/d1cf9u1unakubt?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory",
					"fdssbigrhdsikk",
					"a7a7e09f12ef66bf6a01844d1b190940405f643dc559df68824cf22be30c8bbf");
		}catch (SQLException e) {
			e.printStackTrace();

			
		}
		return connection;

	}
}