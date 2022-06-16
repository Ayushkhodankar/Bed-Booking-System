

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Doctordao;


/**
 * Servlet implementation class DeleteDoctor
 */
@WebServlet("/deletedoctor")
public class DeleteDoctor extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			RequestDispatcher dispatcher=request.getRequestDispatcher("hsptlmgr.html");
			int d_id = Integer.parseInt(request.getParameter("d_id"));
			try {
				int f1= Doctordao.deleteDoc(d_id);
				
				if(f1>0)
					{
					
					dispatcher.include(request, response);
				    
					}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


