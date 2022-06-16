package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bed;
import model.Doctor;

public class BedDao {
	static Connection getConnection() throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver Registerd");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hospitaldb","root","abc123");
	System.out.println("Connection successfully");
	return con;
	}
	
	public static int insertBed(Bed b1) throws ClassNotFoundException, SQLException
	{
	//	roomtype, roomNo, bedNo, price, status
	
	Connection con=BedDao.getConnection();
	System.out.println("Conection Established Successfully");
	
	PreparedStatement ps=con.prepareStatement("insert into reg_beds(roomNo, bedNo, price,status1) values(?,?,?,?)");
	ps.setString(1,b1.getRoom_no());
	ps.setString(2,b1.getBed_no());
	ps.setString(3,b1.getPrice());
	ps.setString(4,b1.getStatus());
	
	int z=ps.executeUpdate();

	con.close();
	
	return z;
	} 
	
	public static int deleteBed(int bed_no) throws ClassNotFoundException, SQLException
	{
	
	Connection con=BedDao.getConnection();
	System.out.println("Conection Established Successfully");
	
	PreparedStatement ps=con.prepareStatement("delete from reg_beds  where bedNo=?");
	
	ps.setInt(1,bed_no);
	
	
	
	int f3=ps.executeUpdate();
	
	con.close();
	return f3;
	
	}
	
	public static List<Bed> getBedRecords(int start, int total) {
	    List<Bed> list=new ArrayList<Bed>();  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from reg_beds limit "+(start-1)+","+total);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Bed e3=new Bed();     
	            e3.setRoom_no(rs.getString(1)); 
	            e3.setBed_no(rs.getString(2)); 
	            e3.setPrice(rs.getString(3));
	            e3.setStatus(rs.getString(4)); 
	            list.add(e3);  
	        }  
	        con.close();  
	    }catch(Exception e){System.out.println(e);}  
	    return list; 
	   }
	
	public static int updateBed(String bed_No) throws ClassNotFoundException, SQLException
	{
	
	Connection con=BedDao.getConnection();
	System.out.println("Conection Established Successfully");
	//	roomtype, roomNo, bedNo, price, status
	
	PreparedStatement ps=con.prepareStatement("UPDATE reg_beds set status1='booked' where bedNo=?");
	
	ps.setString(1,bed_No);
	
	System.out.println("update bed dao");
	
	int z1=ps.executeUpdate();
	
	con.close();
	return z1;
	}
}


