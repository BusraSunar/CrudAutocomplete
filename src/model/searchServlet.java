package model;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import java.sql.*;
import com.google.gson.*;
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> list=new ArrayList<User>();
		try{
			//if the user logged in show the page 
			if(request.getSession().getAttribute("loginYapildi").equals(true)) {
				
				//connect to database
				Class.forName("com.mysql.jdbc.Driver");
	            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/idk?autoReconnect=true&useSSL=false", "root", "");
	            Statement st=(Statement) con.createStatement();
	            
	            //get input (if there is) from the search bar
	            String queryName = request.getParameter("searchBarName");
	            
	            //get input (if there is) from the search bar
	            String queryEmail = request.getParameter("searchBarEmail");
	          
	            //to display the table look if search bar is empty or not
			    String sql="";
				if(queryName!=null){
					sql = "SELECT * FROM smth WHERE name LIKE '%"+queryName+"%'";
				}else if(queryEmail!= null) {
					sql = "SELECT * FROM smth WHERE email LIKE '%"+queryEmail+"%'";
				}else{
					sql ="SELECT * FROM smth";
				}
	            ResultSet rs=st.executeQuery(sql);     
	            
	            ArrayList<String> name=new ArrayList<String>();
        
	            //get the results from the executeQuery method
	            while(rs.next()){
	            	User u= new User();
	            	u.setId(rs.getString("id"));
	            	u.setName(rs.getString("name"));
	            	name.add(rs.getString("name"));
	            	u.setEmail(rs.getString("email"));
	            	list.add(u);
	            }
	           
	            request.setAttribute("dataName", name);

	           //set the data variable to list to show our table in table.jsp
	            request.setAttribute("data", list);
	            request.getRequestDispatcher("table.jsp").forward(request, response);
			}else {
				response.sendRedirect("index.html");
			}
		          
		}
		catch(Exception e){}
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> list=new ArrayList<User>();
		try{
			//if the user logged in show the page 
			if(request.getSession().getAttribute("loginYapildi").equals(true)) {
				
				//connect to database
				Class.forName("com.mysql.jdbc.Driver");
	            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/idk?autoReconnect=true&useSSL=false", "root", "");
	            Statement st=(Statement) con.createStatement();
	            
	            //get input (if there is) from the search bar
	            String queryName = request.getParameter("searchBarName");
	            
	            //get input (if there is) from the search bar
	            String queryEmail = request.getParameter("searchBarEmail");
	          
	            //to display the table look if search bar is empty or not
			    String sql="";
				if(queryName!=null){
					sql = "SELECT * FROM smth WHERE name LIKE '%"+queryName+"%'";
				}else if(queryEmail!= null) {
					sql = "SELECT * FROM smth WHERE email LIKE '%"+queryEmail+"%'";
				}else{
					sql ="SELECT * FROM smth";
				}
	            ResultSet rs=st.executeQuery(sql);
	            
	            
	            ArrayList<String> name=new ArrayList<String>();
	            
	            //get the results from the executeQuery method
	            while(rs.next()){
	            	User u= new User();
	            	u.setId(rs.getString("id"));
	            	u.setName(rs.getString("name"));
	            	name.add(rs.getString("name"));
	            	u.setEmail(rs.getString("email"));
	            	list.add(u);
	            }
	           
	            request.setAttribute("dataName", name);
	            
	           //set the data variable to list to show our table in table.jsp
	            request.setAttribute("data", list);
	            request.getRequestDispatcher("table.jsp").forward(request, response);
			}else {
				response.sendRedirect("index.html");
			}
		          
		}
		catch(Exception e){}
	
	}

}
