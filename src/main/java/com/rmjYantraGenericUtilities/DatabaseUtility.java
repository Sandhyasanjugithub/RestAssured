package com.rmjYantraGenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



	public class DatabaseUtility {
		Driver driverRef;
		Connection con = null;
		/**
		 * This method will establish the connection of db
		 * @throws SQLException
		 */
		
		public void connectToDB() throws SQLException
		{
			driverRef =new Driver();
			DriverManager.registerDriver(driverRef);
			con=DriverManager.getConnection(EndPoints.DBUrl,EndPoints.DBUsername,EndPoints.DBPassword);
		}
		/**
		 * This method will close the DB connection
		 * @throws SQLException
		 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
	/**
	 * This method will execute a query and check for the expected data
	 * if the expected data is found,it will return the data
	 * else it will return the null.
	 * data validation with respect to database.
	 * @param query
	 * @param collIndex
	 * @param expData
	 * @return 
	 * @throws SQLException
	 */
	public  ResultSet executingQuery(String query) throws SQLException
	{
		Statement stat = con.createStatement();
		ResultSet result=stat.executeQuery(query);
		return result;
	}
	}
