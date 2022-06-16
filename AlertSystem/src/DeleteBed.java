

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BedDao;



@WebServlet("/deletebed")
public class DeleteBed extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("hsptlmgr.html");
		int bed_no = Integer.parseInt(request.getParameter("bed_no"));
		try {
			int f3= BedDao.deleteBed(bed_no);
			
			if(f3>0)
				{
				
				dispatcher.include(request, response);
			    
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
