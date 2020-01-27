<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Sign In</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
    <header>
      <h1>Sign In</h1>
    </header>
    <section class="container">
      <form id="my-form" method="post">
        <h1>Sign in</h1>
        <div class="msg"></div>
        <div>
          <label for="name">Name:</label>
          <input type="text" id="name" name="name">
        </div>
        <div>
          <label for="email">Email:</label>
          <input type="text" id="email" name="email">
        </div>
        <button class="btn" type="submit" onclick="form.action='loginServlet'" >Sign in</button>
      </form>
    </section>
  </body>
</html>
    