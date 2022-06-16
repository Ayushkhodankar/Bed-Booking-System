package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Manager;



public class AdminDao {
	
	static Connection getConnection() throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver Registered");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/hospitaldb","root","abc123");
	System.out.println("Connection successfully");
	return con;
	}
	
	public static int insert(Manager m) throws ClassNotFoundException, SQLException
	{
	
	
	Connection con=AdminDao.getConnection();
	System.out.println("Conection Established Successfully");
	
	PreparedStatement ps=con.prepareStatement("insert into reg_manager( name, email, mobNo, hospitalname, address, username, password) values(?,?,?,?,?,?,?)");
	ps.setString(1,m.getM_name());
	ps.setString(2,m.getM_email());
	ps.setString(3,m.getM_mob());
	ps.setString(4,m.getM_hosp());
	ps.setString(5,m.getM_add());
	ps.setString(6,m.getM_uname());
	ps.setString(7,m.getM_pass());
	
	
	int a=ps.executeUpdate();

	con.close();
	 
	return a;
	}
	public static Manager search(int m_id) throws ClassNotFoundException, SQLException
	{

		Connection con=AdminDao.getConnection();
		System.out.println("Conection Established Successfully");
		Manager m= new Manager();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM reg_manager WHERE id=?");
		ps.setInt(1,m_id);
		
		ResultSet rs=ps.executeQuery();
		
		
	    while(rs.next())
		{
	   
	    m.setM_name(rs.getString(2));
	    m.setM_email(rs.getString(3));
	    m.setM_mob(rs.getString(4));
	    
	    m.setM_hosp(rs.getString(5));
	    m.setM_add(rs.getString(6));
	    m.setM_uname(rs.getString(7));
	    m.setM_pass(rs.getString(8));
	    
	   }
	    
	    System.out.println("name "+m.getM_name());
	    con.close();
		return m ;
	}
	
	public static int update(Manager m) throws ClassNotFoundException, SQLException
	{
	
	Connection con=AdminDao.getConnection();
	System.out.println("Conection Established Successfully");
	
	//id, name, email, mobNo, hospitalname, address, username, password
	
	PreparedStatement ps=con.prepareStatement("update reg_manager set name=? , email=?, mobNo=?,hospitalname=?,address=?, username=?, password=? where id=?");
	ps.setString(1,m.getM_name());
	ps.setString(2,m.getM_email());
	ps.setString(3,m.getM_mob());
	ps.setString(4,m.getM_hosp());
	ps.setString(5,m.getM_add());
	ps.setString(6,m.getM_uname());
	ps.setString(7,m.getM_pass());
	ps.setString(8,m.getM_id());
	
	
	int b=ps.executeUpdate();
	
	con.close();
	return b;
	}

public static int delete(int m_id) throws ClassNotFoundException, SQLException
	{
	
	Connection con=AdminDao.getConnection();
	System.out.println("Conection Established Successfully");
	
	PreparedStatement ps=con.prepareStatement("delete from reg_manager  where id=?");
	
	ps.setInt(1,m_id);
	
	
	
	int c=ps.executeUpdate();
	
	con.close();
	return c;
	
	}

public static List<Manager> getRecords(int start, int total) {
    List<Manager> list=new ArrayList<Manager>();  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from reg_manager limit "+(start-1)+","+total);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            Manager e=new Manager();  
            e.setM_id(rs.getString(1));  
            e.setM_name(rs.getString(2));  
            e.setM_email(rs.getString(3)); 
            e.setM_mob(rs.getString(4)); 
            e.setM_hosp(rs.getString(5));
            e.setM_add(rs.getString(6));
            e.setM_uname(rs.getString(7));
            e.setM_pass(rs.getString(8));
            
            list.add(e);  
        }  
        con.close();  
    }catch(Exception e){System.out.println(e);}  
    return list;  

}
}

