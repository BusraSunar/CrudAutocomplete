package model;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the id of the chosen input
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		try{
			//connect to database
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/idk?autoReconnect=true&useSSL=false", "root", "");
			Statement stat=(Statement) conn.createStatement();
			
			//delete the given id from the database
			String sql= "DELETE FROM smth WHERE id='" +id + "'" ;
			stat.executeUpdate(sql);
			response.sendRedirect("searchServlet");
		}catch(Exception e) {
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
