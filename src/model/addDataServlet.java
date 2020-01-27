package model;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


@WebServlet("/addDataServlet")
public class addDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addDataServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get inputs from the input boxes 
		String name= request.getParameter("name");
		String email = request.getParameter("email");
		Connection conn =null;
		PreparedStatement ps = null;
		try{
			//connect to database 
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			if(name!=null && email!=null){
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/idk?autoReconnect=true&useSSL=false", "root", "");
				ps = (PreparedStatement) conn.prepareStatement("INSERT INTO smth(name, email) VALUES (?,?)");
				ps.setString(1,name);
				ps.setString(2,email);
				//int x = ps.executeUpdate(); //this will return the number of rows thats been updated,inserted
				ps.executeUpdate();
				response.sendRedirect("searchServlet");
			}

		}catch(Exception e){}
		
	}

}
