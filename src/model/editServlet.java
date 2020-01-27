package model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;


@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public editServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//connect the database
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/idk?autoReconnect=true&useSSL=false", "root", "");
	        
	        //get the inputs from the input boxes for name and email
			String newName= request.getParameter("textName");
			String newEmail= request.getParameter("textEmail");
			
			//get the public editId variable to find the variable thats going to be edited
			PreparedStatement stmt=null;
			String idStr = (String) request.getSession().getAttribute("editId");
  			String update="UPDATE smth SET name=?, email=? WHERE id='" +idStr +"'";
  			stmt = (PreparedStatement) con.prepareStatement(update);
  			stmt.setString(1,newName);
  			stmt.setString(2,newEmail);
  			request.getSession().setAttribute("editId","");
  			stmt.executeUpdate();
  			
  			//after editing our database clear the input boxes
  			request.getSession().setAttribute("nameText", "");
			request.getSession().setAttribute("emailText", "");
  			response.sendRedirect("searchServlet");


  		
	}catch(Exception e) {}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
