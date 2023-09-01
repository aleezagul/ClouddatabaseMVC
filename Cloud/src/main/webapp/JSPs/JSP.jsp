<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="Film.Film" %>


    


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/sandstone/bootstrap.min.css" integrity="sha384-zEpdAL7W11eTKeoBJK1g79kgl9qjP7g84KfK3AZsuonx38n8ad+f5ZgXtoSDxPOh" crossorigin="anonymous">
<link rel="stylesheet" href="bootstrap.min-2.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>AG Film Database</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">AG Film Database</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor02">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
         <a class="nav-link" href="Addfilms.jsp"> Add Film</a>
        </li>
    
      </ul>
      <form class="d-flex" action="Controller" method="post">
        <input class="form-control me-sm-2" type="text" placeholder="Search by id" name="id">
        <input class="form-control me-sm-2" type="hidden">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit" >Search</button>
      </form>
    </div>
  </div>
</nav>




<ul>
<%
ArrayList<Film> FilmsAll = (ArrayList<Film>) request.getAttribute("films");
for(Film f: FilmsAll){
	
	

out.write("<li>ID<b>" + f.getId() + "</b></li>");
out.write("<li>Title:" + f.getTitle() + "</li>");
out.write("<li>Year:" + f.getYear() + "</li>");
out.write("<li>Director:" + f.getDirector() + "</li>");
out.write("<li>Stars:" + f.getStars() + "</li>");
out.write("<li>Review:" + f.getReview() + "</li>");
out.write("<form action='UpdateFilms' method='post'> <button type='submit' value='Update Film'> Update Film </button> <input type='hidden' value='"+f.getId()+"' name='updatesfilm'></form>"); 
out.write("<form action='deletefilms' method='get'> <button type='submit' value='Delete Film'> Delete Film </button>  <input type='hidden' value='"+f.getId()+"' name='getsid'></form>");
}
%>
</ul>

</body>
</html>