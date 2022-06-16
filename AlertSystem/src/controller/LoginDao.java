package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class LoginDao {
	  
		public static boolean validate(String name,String pass, String q){  
		boolean status=false;  
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registered");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hospitaldb","root","abc123");
			System.out.println("Connection successfully");  
		      
		PreparedStatement ps=con.prepareStatement(q);  
		System.out.println(name+" "+pass);
		ps.setString(1,name);  
		ps.setString(2,pass);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		      System.out.println(status);    
		}catch(Exception e){System.out.println(e);}  
		return status;  
		}  
		}  


