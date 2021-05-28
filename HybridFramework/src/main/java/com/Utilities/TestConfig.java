package com.Utilities;
public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "";
	public static String password = "";
	public static String[] to ={"",""};
	public static String subject = "Project Execution Extent Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="";
	public static String attachmentName="";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://localhost;DatabaseName=monitor_eval"; 
	public static String dbUserName=""; 
	public static String dbPassword=""; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "";
	public static String mysqlpassword = "";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/acs";
	
	
	
	
	
	
	
	
	
}
