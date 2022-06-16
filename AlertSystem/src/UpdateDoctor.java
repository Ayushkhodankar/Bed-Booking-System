

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Doctordao;

import model.Doctor;

/**
 * Servlet implementation class UpdateDoctor
 */
@WebServlet("/updatedoctor")
public class UpdateDoctor extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher=request.getRequestDispatcher("hsptlmgr.html");
		
		String d_id=request.getParameter("d_id");
		String d_name=request.getParameter("d_name");
		String d_email=request.getParameter("d_email"); 
		String d_mob=request.getParameter("d_mob");
		String d_address=request.getParameter("d_address");
		String d_qual=request.getParameter("d_qual"); 
		String dname=request.getParameter("dname");
		String dpass=request.getParameter("dpass");
		
		
		Doctor d=new Doctor(d_id, d_name, d_email, d_mob, d_address, d_qual, dname, dpass);
		try {
			int i= Doctordao.updateDoc(d);
	
			
			if(i>0)
				{
				
				dispatcher.include(request, response);
			    
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
