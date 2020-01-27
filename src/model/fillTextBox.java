package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


@WebServlet("/fillTextBox")
public class fillTextBox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public fillTextBox() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try{
			//get the id from the url
			String idStr = request.getParameter("id");
			
			//set a variable for editServlet
			request.getSession().setAttribute("editId", idStr);
			
			//connect to database
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/idk?autoReconnect=true&useSSL=false", "root", "");
			
			//get the chosen id's attributes
			Statement stat=(Statement) conn.createStatement();
			String sql= "SELECT * FROM smth WHERE id='" +idStr + "'" ;
			ResultSet rs = stat.executeQuery(sql);
			String nameTextBox="";
			String emailTextBox="";
			while(rs.next()) {
				nameTextBox= rs.getString("name");
				emailTextBox= rs.getString("email");
				
			}
			
			//fill in the input box
			request.getSession().setAttribute("nameText", nameTextBox);
			request.getSession().setAttribute("emailText", emailTextBox);
			response.sendRedirect("searchServlet");
		}catch(Exception e) {
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
