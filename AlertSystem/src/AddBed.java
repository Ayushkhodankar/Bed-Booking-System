

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BedDao;

import model.Bed;

@WebServlet("/addbed")
public class AddBed extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String room_no=request.getParameter("room_no"); 
		String bed_no=request.getParameter("bed_no");
		String price=request.getParameter("price");
		String status=request.getParameter("status");
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("hsptlmgr.html");
		
		
			Bed b1=new Bed(room_no, bed_no, price,status);
			try {
				int z=BedDao.insertBed(b1);
				
				if(z>0)
					{
					
					dispatcher.include(request, response);
				    
					}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	}

}
