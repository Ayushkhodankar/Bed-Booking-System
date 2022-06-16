package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BedDropdown {

	
	public static ResultSet validate(String q) throws ClassNotFoundException, SQLException{
		
		ResultSet rs = null;
		
		Connection con=BedDao.getConnection();
		System.out.println("Conection Established Successfully");
		
		PreparedStatement ps=con.prepareStatement(q);
		
		rs=ps.executeQuery();
		
		return rs;
		
	}
}
