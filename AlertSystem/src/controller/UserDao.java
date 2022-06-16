package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bed;
import model.User;

public class UserDao {
	static Connection getConnection() throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver Registerd");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hospitaldb","root","abc123");
	System.out.println("Connection successfully");
	return con;
	}
	
	public static int insertUser(User u) throws ClassNotFoundException, SQLException
	{
	
	Connection con=UserDao.getConnection();
	System.out.println("Conection Established Successfully");
	
	PreparedStatement ps=con.prepareStatement("insert into reg_patient(name, age, mobNo, address, gender, bloodgroup, username,password) values(?,?,?,?,?,?,?,?)");
	ps.setString(1,u.getU_name());
	ps.setString(2,u.getU_age());
	ps.setString(3,u.getU_mob());
	ps.setString(4,u.getU_add());
	ps.setString(5,u.getU_gender());
	ps.setString(6,u.getU_bgroup());
	ps.setString(7,u.getU_uname());
	ps.setString(8,u.getU_pass());
	
	int y=ps.executeUpdate();

	con.close();
	
	return y;
	}
	
	public static User UserSearch(int u_id) throws ClassNotFoundException, SQLException
	{

		Connection con=UserDao.getConnection();
		System.out.println("Conection Established Successfully");
		User u1=new User();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM reg_patient WHERE id=?");
		ps.setInt(1,u_id);
		
		ResultSet rs=ps.executeQuery();
		
		
	    while(rs.next())
		{
	   
	    	u1.setU_name(rs.getString(2));
	    	u1.setU_age(rs.getString(3));
	    	u1.setU_mob(rs.getString(4));
	    	u1.setU_add(rs.getString(5));
	    	u1.setU_gender(rs.getString(6));
	    	u1.setU_bgroup(rs.getString(7));
	    	u1.setU_uname(rs.getString(11));
	    	u1.setU_pass(rs.getString(12));
	   }
	    
	    System.out.println("name "+u1.getU_name());
	    con.close();
		return u1 ;
	}
	
	public static User UserSearchInfo(int u_id) throws ClassNotFoundException, SQLException
	{

		Connection con=UserDao.getConnection();
		System.out.println("Conection Established Successfully");
		User u4=new User();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM reg_patient WHERE id=?");
		ps.setInt(1,u_id);
		
		ResultSet rs=ps.executeQuery();
		
		
	    while(rs.next())
		{
	   
	    	u4.setU_name(rs.getString(2));
	    	u4.setU_age(rs.getString(3));
	    	u4.setU_mob(rs.getString(4));
	    	u4.setU_add(rs.getString(5));
	    	u4.setU_gender(rs.getString(6));
	    	u4.setU_bgroup(rs.getString(7));
	    	u4.setU_sym(rs.getString(8));
	    	u4.setU_dprt(rs.getString(9));
	    	u4.setU_doa(rs.getString(10));
	   }
	    
	    System.out.println("name "+u4.getU_name());
	    con.close();
		return u4 ;
	}
	
	public static int updateUser(User u1) throws ClassNotFoundException, SQLException
	{
	
	Connection con=UserDao.getConnection();
	System.out.println("Conection Established Successfully");
	//id, name, age, mobNo, address, gender, bloodgroup, symptoms, department, doa, username, password

	
	PreparedStatement ps=con.prepareStatement("update reg_patient set name=?, age=?, mobNo=?, address=?, gender=?, bloodgroup=?, username=?,password=? where id=?");
	ps.setString(1,u1.getU_name());
	ps.setString(2,u1.getU_age());
	ps.setString(3,u1.getU_mob());
	ps.setString(4,u1.getU_add());
	ps.setString(5,u1.getU_gender());
	ps.setString(6,u1.getU_bgroup());
	ps.setString(7,u1.getU_uname());
	ps.setString(8,u1.getU_pass());
	ps.setString(9,u1.getU_id());
	
	
	int u2=ps.executeUpdate();
	
	con.close();
	return u2;
	}
	
	public static int updateUserInfo(User u1) throws ClassNotFoundException, SQLException
	{
	
	Connection con=UserDao.getConnection();
	System.out.println("Conection Established Successfully updateUserInfo");
	//id, name, age, mobNo, address, gender, bloodgroup, symptoms, department, doa, username, password

	
	PreparedStatement ps=con.prepareStatement("update reg_patient set name=?, age=?, mobNo=?, address=?, gender=?, bloodgroup=?,symptoms=?,department=?,doa=? where id=?");
	ps.setString(1,u1.getU_name());
	ps.setString(2,u1.getU_age());
	ps.setString(3,u1.getU_mob());
	ps.setString(4,u1.getU_add());
	ps.setString(5,u1.getU_gender());
	ps.setString(6,u1.getU_bgroup());
	ps.setString(7,u1.getU_sym());
	ps.setString(8,u1.getU_dprt());
	ps.setString(9,u1.getU_doa());
	ps.setString(10,u1.getU_id());
	
	System.out.println("data print"+u1.getU_name()+u1.getU_age()+u1.getU_mob()+u1.getU_add()+u1.getU_gender()+u1.getU_bgroup()+u1.getU_sym()+u1.getU_dprt()+u1.getU_doa());
	
	int u5=ps.executeUpdate();
	
	con.close();
	return u5;
	}
	
	public static int deleteuser(int u_id) throws ClassNotFoundException, SQLException
	{
	
	Connection con=UserDao.getConnection();
	System.out.println("Conection Established Successfully");
	
	PreparedStatement ps=con.prepareStatement("delete from reg_patient  where id=?");
	
	ps.setInt(1,u_id);
	
	
	
	int f2=ps.executeUpdate();
	
	con.close();
	return f2;
	
	}
	//id, name, age, mobNo, address, gender, bloodgroup, symptoms, department, doa, username, password
	public static List<User> getUserRecords(int start, int total) {
	    List<User> list=new ArrayList<User>();  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from reg_patient limit "+(start-1)+","+total);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	User e2=new User();  
	            e2.setU_id(rs.getString(1));  
	            e2.setU_name(rs.getString(2));  
	            e2.setU_age(rs.getString(3)); 
	            e2.setU_mob(rs.getString(4)); 
	            e2.setU_add(rs.getString(5));
	            e2.setU_gender(rs.getString(6));
	            e2.setU_bgroup(rs.getString(7));
	            e2.setU_sym(rs.getString(8));
	            e2.setU_dprt(rs.getString(9));
	            e2.setU_doa(rs.getString(10));
	            e2.setU_uname(rs.getString(11));
	            e2.setU_pass(rs.getString(12));
	            list.add(e2);  
	        }  
	        con.close();  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  

	}
	
	


}
