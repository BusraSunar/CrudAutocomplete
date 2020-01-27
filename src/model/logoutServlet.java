package model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public logoutServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//set the variable that controls the login/logout to false
		request.getSession().setAttribute("loginYapildi", false);
		request.getRequestDispatcher("index.jsp").include(request, response);  
         
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
