<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@  page import= "com.userModel.User"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
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
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath() %>/list">Users</a>
        </li>
        </ul>
     </div>
     </div> 
  	</nav>
  	<c:if test="${list==null}">
  	<form action="insert" method="post">
  	</c:if>
  	<c:if test="${list!=null}">
  	<form action="update" method="post">
  	</c:if>
  	<h2 align="center">
  	<c:if test="${list==null}">
  	ADD USER
  	</c:if>
  	<c:if test="${list!=null}">
  	EDIT USER
  	</c:if>
  	</h2>
  	<div class="mb-3 container">
     <input type="hidden" class="form-control" id="exampleFormControlInput1" value="${list.id}" name="id" style="width:300px">
     </div>
	<div class="mb-3 container">
    <label for="exampleFormControlInput1" class="form-label">Child Name</label>
     <input type="text" class="form-control" id="exampleFormControlInput1" value="${list.name}" placeholder="enter your name" name="name" style="width:300px">
     </div>
	<div class="mb-3 container">
	  <label for="exampleFormControlInput2"  class="form-label">Father name</label>
	  <input type="text" class="form-control" id="exampleFormControlInput2" value="${list.fathername}" placeholder="enter your father name" name="fathername" style="width:300px">
	</div>
	<div class="mb-3 container">
	  <label for="exampleFormControlInput3" class="form-label">Mother name</label>
	  <input type="text" class="form-control" id="exampleFormControlInput3" value="${list.mothername}" placeholder="enter your mother name" name="mothername" style="width:300px">
	</div>
	<div class="mb-3 container">
	  <label for="exampleFormControlInput4" class="form-label">DOB</label>
	  <input type="text" class="form-control" id="exampleFormControlInput4" value="${list.dob}" placeholder="enter child birth-date" name="dob" style="width:300px">
	</div>

	<div class="mb-3 container">
	  <label for="exampleFormControlInput5" class="form-label">Gender</label>
	  <input type="text" class="form-control" id="exampleFormControlInput5" value="${list.gender}" placeholder="enter child gender" name="gender" style="width:300px">
	</div>
	<div class="mb-3 container">
	  <label for="exampleFormControlInput6" class="form-label">City</label>
	  <input type="text" class="form-control" id="exampleFormControlInput6" value="${list.city}" placeholder="enter your city" name="city" style="width:300px">
	</div>
	<div class="mb-3 container">
	  <input type ="submit" value ="save" class="btn btn-success" style="width:150px"/>
	</div>
	</form>
</body>
</html>