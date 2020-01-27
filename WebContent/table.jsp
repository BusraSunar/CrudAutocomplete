<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.sql.*"  import = "java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
	  <!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	    <link rel="stylesheet" href="rehberStyle.css">
	    <script src="https://kit.fontawesome.com/41c5e081d3.js"></script>
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 		<!-- <script language="javascript" type="text/javascript" src="deneme.js"></script> -->
 		
	    <title>Rehber</title>
	</head>
	<body >
	    <header >
	        <h1 >Rehber</h1>
	    </header>
	    
	    <div class="search-box">
    		<form action="searchName" method="post" class="form" onsubmit="">
		        <input class="search-txt" id="barName" name="searchBarName" placeholder="Name" formaction = "">
		        <a href="#" class="search-btn" style="text-decoration: none;">
		            <i class="fas fa-search"></i>
		        </a>
	        </form>
	    </div>
		    <a href="addNew.jsp" class="btn2" style="text-decoration: none;">Add New Data</a>
		    <form action="logout" method="post">
		   		<button  class="btn3" type="submit" onclick="form.action='logoutServlet'">Logout</button>
	    	</form>
			<form action="" method="post" class="">
				<div class="divv">
					<label class ="labels">Name</label>
					<input  type="text" class="textBox" name="textName" id="textName" value="${nameText}" >
					<label class ="labels">Email</label>
					<input  type="text" class="textBox" name="textEmail" id = "textEmail" value="${emailText}" >
				</div>
				<button type="submit" onclick="form.action='editServlet';" class="btn4" >Update</button>
			</form>	
        
        
	    <form action="display" method="get" id="disp">
	        <table id="rehber" align="center"  >
		        <thead>
		            <tr bgcolor="#333">
		                <th  style="width: 0%;"><font color="#fff">ID</font></th>
		                <th  style="width: 0%;"><font color="#fff">NAME</font></th>
		                <th  style="width: 0%;"><font color="#fff">EMAIL</font></th>
		                <th  style="width: 100%;"><font color="#fff">ACTION</font></th>    
		            </tr>
		        </thead>
		        <TBody>
					<c:forEach items="${data}" var="list">
					<tr>
						<td><input readonly name="id" id="id" value="<c:out value="${list.id}"/>"></td>
						<td><input readonly name="name" id="name" value="<c:out value="${list.name}"/>"></td>
						<td><input readonly name="email" id="email" value="<c:out value="${list.email}"/>"></td>
						<td>
							<a href="fillTextBox?id=${list.id}" style="text-decoration: none; background:#333;" class="edit"   >Edit</a>
							<a href="deleteServlet?id=${list.id}" style="text-decoration: none; background: rgb(163, 2, 2);" class="edit"   >Delete</a>
						</td>
					</tr>
					</c:forEach>
		        </TBody>
	    	</table>
   	 	</form>	
   	 	<script>
 		$( document ).ready(function() {

 			var nameArray = new Array();
 			var emailArray = new Array();
 			
 			<c:forEach var="row" items="${dataName}">
 				nameArray.push('${row}');
 			</c:forEach>
	
 			<c:forEach var="smt" items="${dataEmail}">
 				emailArray.push('${smt}');
			</c:forEach>
			
			$( function() {
			   
			    $( "#barName" ).autocomplete({
			      source: nameArray,
			      messages: {
			          noResults: '',
			          results: function(amount) {
			              return  ''
			          }
			      } 
			    });
			    $( "#barEmail" ).autocomplete({
				      source: emailArray,
				      messages: {
				          noResults: '',
				          results: function(amount) {
				              return  ''
				          }
				      }
				    });
			  } );
			
 		});		
 		</script>
	</body>
	</html>
		
		
