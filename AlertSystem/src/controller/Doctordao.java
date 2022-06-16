package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Doctor;

public class Doctordao {
	static Connection getConnection() throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver Registerd");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hospitaldb","root","abc123");
	System.out.println("Connection successfully");
	return con;
	}
	
	public static int insertdoc(Doctor d) throws ClassNotFoundException, SQLException
	{
		
	
	Connection con=Doctordao.getConnection();
	System.out.println("Conection Established Successfully");
	
	PreparedStatement ps=con.prepareStatement("insert into reg_doctor(name, email, mobNo, address, qualification, username, password) values(?,?,?,?,?,?,?)");
	ps.setString(1,d.getD_name());
	ps.setString(2,d.getD_email());
	ps.setString(3,d.getD_mob());
	ps.setString(4,d.getD_address());
	ps.setString(5,d.getD_qual());
	ps.setString(6,d.getDname());
	ps.setString(7,d.getDpass());
	
	int x=ps.executeUpdate();

	con.close();
	
	return x;
	}
	
	public static Doctor docSearch(int d_id) throws ClassNotFoundException, SQLException
	{
	
		Connection con=Doctordao.getConnection();
		System.out.println("Conection Established Successfully");
		Doctor d1=new Doctor();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM reg_doctor WHERE id=?");
		ps.setInt(1,d_id);
		
		ResultSet rs=ps.executeQuery();
		
		
	    while(rs.next())
		{
	   
	    	d1.setD_name(rs.getString(2));
	    	d1.setD_email(rs.getString(3));
	    	d1.setD_mob(rs.getString(4));
	    	d1.setD_address(rs.getString(5));
	    	d1.setD_qual(rs.getString(6));
	    	d1.setDname(rs.getString(7));
	    	d1.setDpass(rs.getString(8));
	   }
	    
	    System.out.println("name "+d1.getD_name());
	    con.close();
		return d1 ;
	}
	
	public static int updateDoc(Doctor d) throws ClassNotFoundException, SQLException
	{
	
	Connection con=Doctordao.getConnection();
	System.out.println("Conection Established Successfully");
	
	//id, name, email, mobNo, address, qualification, username, password
	PreparedStatement ps=con.prepareStatement("update reg_doctor set name=?, email=?, mobNo=?, address=?, qualification=?, username=?, password=? where id=?");
	ps.setString(1,d.getD_name());
	ps.setString(2,d.getD_email());
	ps.setString(3,d.getD_mob());
	ps.setString(4,d.getD_address());
	ps.setString(5,d.getD_qual());
	ps.setString(6,d.getDname());
	ps.setString(7,d.getDpass());
	ps.setString(8,d.getD_id());
	
	
	int i=ps.executeUpdate();
	
	con.close();
	return i;
	}
	
	public static int deleteDoc(int d_id) throws ClassNotFoundException, SQLException
	{
	
	Connection con=Doctordao.getConnection();
	System.out.println("Conection Established Successfully");
	
	PreparedStatement ps=con.prepareStatement("delete from reg_doctor  where id=?");
	
	ps.setInt(1,d_id);
	
	
	
	int f1=ps.executeUpdate();
	
	con.close();
	return f1;
	
	}
	
	public static List<Doctor> getDocRecords(int start, int total) {
	    List<Doctor> list=new ArrayList<Doctor>();  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from reg_doctor limit "+(start-1)+","+total);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Doctor e1=new Doctor();  
	            e1.setD_id(rs.getString(1));  
	            e1.setD_name(rs.getString(2));  
	            e1.setD_email(rs.getString(3)); 
	            e1.setD_mob(rs.getString(4)); 
	            e1.setD_address(rs.getString(5));
	            e1.setD_qual(rs.getString(6));
	            e1.setDname(rs.getString(7));
	            e1.setDpass(rs.getString(8));
	            list.add(e1);  
	        }  
	        con.close();  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  

	}

}
