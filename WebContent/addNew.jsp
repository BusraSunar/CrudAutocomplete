<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.sql.*"%>
    <% Class.forName("com.mysql.jdbc.Driver"); %>
  
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Submit</title>
    <link rel="stylesheet" href="style.css">  
  </head>
  <body>
    <header>
      <h1>Submit</h1>
    </header>

    <section class="container">
      <form id="my-form" method="post" action="addData">
        <h1>Add User</h1>
        <div class="msg"></div> 
        <div>
          <label for="name">Name:</label>
          <input type="text" name="name">
        </div>
        <div>
          <label for="email">Email:</label>
          <input type="text"  name="email">
        </div>
        <button class="btn" type="submit" >Submit</button>
         <button class="btn" style="text-decoration: none; text-align: center;" onclick="form.action='searchServlet';">Back</button>
      </form>
    </section>
  </body>  
 </html>
   
    