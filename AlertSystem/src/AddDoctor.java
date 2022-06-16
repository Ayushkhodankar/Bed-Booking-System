

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Doctordao;
import model.Doctor;


@WebServlet("/adddoctor")
public class AddDoctor extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String d_name=request.getParameter("d_name");
		String d_email=request.getParameter("d_email"); 
		String d_mob=request.getParameter("d_mob");
		String d_address=request.getParameter("d_address");
		String d_qual=request.getParameter("d_qual"); 
		String dname=request.getParameter("docname");
		String dpass=request.getParameter("docpass");
		RequestDispatcher dispatcher=request.getRequestDispatcher("hsptlmgr.html");
		
		
			Doctor d=new Doctor(d_name, d_email, d_mob, d_address, d_qual, dname, dpass);
			try {
				int x=Doctordao.insertdoc(d);
				
				if(x>0)
					{
					
					dispatcher.include(request, response);
				    
					}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
