package com.blz.workshop0309;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WorksopProgram {
	
	public static void main(String[] args) {
		/*
		 * Defining url of database, username & password for JDBC
		 */
		String dbUrl = "jdbc:mysql://localhost:3306/AddressBook03";
		String username = "root";
		String password = "K@$turi@2808";

		try {
			/*
			 * defining connections and preparedstatement
			 * Taking inputs from the user for ID=2
			 * Displaying in MySQL
			 * Printing date from SQL for ID=1
			 * If any improper inputs given by user then throw exception
			 */
			Connection connection = DriverManager.getConnection(dbUrl, username, password);
//			PreparedStatement prep = connection.prepareStatement(
//					"insert into AddressBook03 (ID,name,address,city,state,zip,phonenumber) values (?,?,?,?,?,?,?)");
//			prep.setInt(1, 2);
//			prep.setString(2, "Dhanashree");
//			prep.setString(3, "Seawoods");
//			prep.setString(4, "Thane");
//			prep.setString(5, "Maharashtra");
//			prep.setInt(6, 951236);
//			prep.setDouble(7, 865245164);
//			prep.executeUpdate();
			
//			 PreparedStatement prep1 = connection.prepareStatement("select * from AddressBook03 where ID = ?");
//             prep1.setInt(1, 1);
//             ResultSet resultSet = prep1.executeQuery();
//             while (resultSet.next()) {
//               System.out.println(resultSet.getInt("ID"));
//               System.out.println(resultSet.getString("name"));
//               System.out.println(resultSet.getString("address"));
//               System.out.println(resultSet.getString("city"));
//               System.out.println(resultSet.getString("state"));
//               System.out.println(resultSet.getInt("zip"));
//               System.out.println(resultSet.getDouble("phonenumber"));
			
			/*
			 * Updating the existing data from the database
			 * Using MYSQL command for updation
			 */
			PreparedStatement prep2 = connection.prepareStatement("update AddressBook03 set zip = '125896' where ID='1'");
			
			prep2.executeUpdate();

           }
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
