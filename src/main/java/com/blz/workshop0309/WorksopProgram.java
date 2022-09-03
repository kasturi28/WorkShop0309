package com.blz.workshop0309;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

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
			 * defining connections and preparedstatement Taking inputs from the user for
			 * ID=2 Displaying in MySQL Printing date from SQL for ID=1 If any improper
			 * inputs given by user then throw exception
			 */
			Connection connection = DriverManager.getConnection(dbUrl, username, password);
		
			System.out.println("Enter your choice");
			System.out.println("1. create data into database");
			System.out.println("2. print the data from database");
			System.out.println("3.Update the data from database");
			Scanner sc = new Scanner(System.in);
			int i  = sc.nextInt();
			switch (i) {
			case 1: {
				PreparedStatement prep = connection.prepareStatement(
						"insert into AddressBook03 (ID,name,address,city,state,zip,phonenumber) values (?,?,?,?,?,?,?)");
				prep.setInt(1, 4);
				prep.setString(2, "Dhana");
				prep.setString(3, "Seawoods");
				prep.setString(4, "Thane");
				prep.setString(5, "MH");
				prep.setInt(6, 94178);
				prep.setDouble(7, 865278412);
				prep.executeUpdate();
				System.out.println("Inserted the data successfully!!!");
			}
			case 2: {
				PreparedStatement prep1 = connection.prepareStatement("select * from AddressBook03");
				ResultSet resultSet = prep1.executeQuery();
				while (resultSet.next()) {
					System.out.println(resultSet.getInt("ID"));
					System.out.println(resultSet.getString("name"));
					System.out.println(resultSet.getString("address"));
					System.out.println(resultSet.getString("city"));
					System.out.println(resultSet.getString("state"));
					System.out.println(resultSet.getInt("zip"));
					System.out.println(resultSet.getDouble("phonenumber"));
				}
			}
			case 3: {
				/*
				 * Updating the existing data from the database Using MYSQL command for updation
				 */
			PreparedStatement prep2 = connection.prepareStatement("update AddressBook03 set zip = '257894' where ID='1'");
			
			prep2.executeUpdate();
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
