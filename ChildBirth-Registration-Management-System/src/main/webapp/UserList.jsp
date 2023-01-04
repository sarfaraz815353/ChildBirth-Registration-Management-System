<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@page import="com.userModel.User" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "a" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BIRTH MANAGEMENT SYSTEM</title>
</head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand">BIRTH MANAGEMENT SYSTEM</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
   </div>

    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/list">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"></a>
        </li>
       </ul>
     </div>
  </nav>
 <h1 style="color:blue" align="center">BIRTH MANAGEMENT SYSTEM</h1>
 <hr></hr>
 <br>
 <div class= "container">
 <a href="<%=request.getContextPath()%>/add" class="btn btn-success">ADD USER</a>
 <br><br>
 <table class="table table striped">
 <thead>
	<th>ID</th>
	<th>CHILD NAME</th>
	<th>FATHER NAME</th>
	<th>MOTHER NAME</th>
	<th>DOB</th>
	<th>GENDER</th>
	<th>CITY</th>
	<th>ACTION</th>
</thead>
<tbody>
<a:forEach items="${display}" var="u">
<tr>
<td><a:out value="${u.id}"></a:out></td>
<td><a:out value="${u.name}"></a:out></td>
<td><a:out value="${u.fathername}"></a:out></td>
<td><a:out value="${u.mothername}"></a:out></td>
<td><a:out value="${u.dob}"></a:out></td>
<td><a:out value="${u.gender}"></a:out></td>
<td><a:out value="${u.city}"></a:out></td>
<td><a href="edit?id=<a:out value="${u.id}"></a:out>">EDIT</a>&nbsp;&nbsp;<a href="delete?id=<a:out value="${u.id}"></a:out>">DELETE</a></td>
</tr>
</a:forEach>
</tbody>
</table>
</div>
</body>
</html>