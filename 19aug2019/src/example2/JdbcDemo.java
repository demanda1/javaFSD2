package example2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JdbcDemo {
	private static Properties properties=null;
	private static Scanner scanner = new Scanner(System.in);
	static {
		properties =new Properties();
		properties.put("JDBC_URL","jdbc:mysql://localhost:3306/ximb");
		properties.put("USER","root");
		properties.put("PASSWORD", "root");
	}
	public JdbcDemo() { 
		// TODO Auto-generated constructor stub
		super();
	}

	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		//register the driver
		//DriverManager.registerDriver(new org.h2.Driver());
		//Class.forName("org.h2.Driver");
		
		//Connection
		
		/*Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ximb","root","root");
		System.out.println(connection);*/
		
		
		//READ STATEMENT
		Connection connection=DriverManager.getConnection(properties.getProperty("JDBC_URL"), properties.getProperty("USER"), properties.getProperty("PASSWORD"));
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery("select * from course");
		System.out.println("ID  NAME  PRICE");
		while(resultset.next()) {
			System.out.println(resultset.getInt(1)+" "+ resultset.getString(2)+" "+resultset.getInt(3));
			//System.out.printf("%d %s %d", resultset.getInt(1),resultset.getString(2),resultset.getInt(3));
			
		}
		
		//UPDATE STATEMENT
		PreparedStatement ps=connection.prepareStatement("UPDATE course SET Price=5000 WHERE ID=2");
		
				
				
		int count=ps.executeUpdate();
		System.out.println("rows updated"+ count);
		
		//DELETE STATEMENT
		PreparedStatement ps2=connection.prepareStatement("DELETE from course WHERE id=2");
		count=ps2.executeUpdate();
		System.out.println("row deleted"+ count);
		
		//INSERT
		PreparedStatement ps3=connection.prepareStatement("INSERT into course VALUES(1,'Python',3500)");
		count=ps3.executeUpdate();
		System.out.println("rows inserted"+ count);
		
		
	}
	
}
