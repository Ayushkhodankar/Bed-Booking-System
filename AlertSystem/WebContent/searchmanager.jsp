<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="controller.AdminDao" %>
<%@ page import="java.io.IOException"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="model.Manager"%>





<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Details</title>
<style type="text/css">

body {
 
  background-repeat: no-repeat;
  background-attachment: fixed;  
  font-family: Arial, Helvetica, sans-serif;
  background-image: url("https://i.ibb.co/QPpPvX9/medical-healthcare-blue-color-1017-26807.webp");
  background-size: 100%;
  margin: 0;
}

/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

.container{
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}
/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.navbar {
  overflow: hidden;
  background-color: transparent;
  float: left;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: black;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}
/* Set a style for all buttons */
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
/* The Modal (background) */


/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
  position: absolute;
  right: 25px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}

/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s;
}

img.avatar {
  width: 10%;
  border-radius: 30%;
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>
<%!   Manager m1=null; %>  
<%
	String m_id=request.getParameter("a_id");
  m1=AdminDao.search(Integer.parseInt(m_id));
    


	
	%>
<div id="search01" class="modal">
  
    <form class="modal-content animate" action="updatemanager" method="post">
      <div class="imgcontainer">
        <span onclick="document.getElementById('search01').style.display='none'" class="close" title="Close Modal">&times;</span>
        <img src="https://i.ibb.co/b5xK0k7/3135715-2.png" alt="Avatar" class="avatar">
      </div>
  
      <div class="container">
      <input type="hidden"  name="m_id" value="<%=m_id %>">
      <label for="a_name"><b>Name</b></label>
        
        <input type="text" placeholder="Enter Name" name="a_name" value="<%=m1.getM_name() %>" required>
        <label for="a_email"><b>E-Mail</b></label>
        <input type="text" placeholder="Enter E-Mail" name="a_email" value="<%=m1.getM_email()%>" required>
        
        <label for="a_mob"><b>Mobile Number</b></label>
        <input type="text" placeholder="Enter Mobile Number" name="a_mob" value="<%=m1.getM_mob()%>" required>
        
        <label for="a_address"><b>Address</b></label>
        <input type="text" placeholder="Enter Address" name="a_address" value="<%=m1.getM_add()%>" required>
        
        <label for="a_hosp"><b>Enter Which Hospital To Allot?</b></label>
       <select name="a_hosp" id="a_hosp" value="<%=m1.getM_hosp()%>">
       <option value="Crescent Hospital">Crescent Hospital</option>
       <option value="Deshmane Hospital">Deshmane Hospital</option>
       <option value="Neuron Hospital">Neuron Hospital</option>
       </select>
       <br>
      
        <label for="apass"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="aname" value="<%=m1.getM_uname() %>" required>
  
        <label for="apass"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="apass" value="<%=m1.getM_pass() %>" required>
          
        <button type="submit" value="Submit">Update</button>
        
      </div>
  
      <div class="container" style="background-color:#f1f1f1">
        <button type="button" onclick="document.getElementById('search01').style.display='none'" class="cancelbtn">Cancel</button>
       
      </div>
      </form>
      </div>
  
</body>
</html>