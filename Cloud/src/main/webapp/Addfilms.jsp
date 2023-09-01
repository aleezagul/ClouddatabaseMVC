<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Film</title>
</head>
<body>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/sandstone/bootstrap.min.css" integrity="sha384-zEpdAL7W11eTKeoBJK1g79kgl9qjP7g84KfK3AZsuonx38n8ad+f5ZgXtoSDxPOh" crossorigin="anonymous">
<link rel="stylesheet" href="bootstrap.min-2.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
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
<form  action="Addfilms" method="post">
Id <input type="text" name="id">
<br>
Title <input type="text" name="title">
<br>
Year <input type="text" name="year">
<br>
Director <input type="text" name="director">
<br>
Stars <input type="text" name="stars">
<br>
Review <input type="text" name="review">
<br>
<input type="submit">

</form>

</body>
</html>