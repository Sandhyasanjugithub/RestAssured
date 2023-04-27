package com.rmjYantraGenericUtilities;

import java.sql.SQLException;

import org.testng.annotations.BeforeSuite;

public class BaseApiClass {
public DatabaseUtility dUtil=new DatabaseUtility();

@BeforeSuite
public void createConn() throws SQLException
{
	dUtil.connectToDB();
}
public void closeConn() throws SQLException
{
	dUtil.closeDB();
}
}
