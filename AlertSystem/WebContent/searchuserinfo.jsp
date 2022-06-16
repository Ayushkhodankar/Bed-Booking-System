<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="controller.UserDao" %>
<%@ page import="java.io.IOException"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search User Info</title>
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
<%!   User u4=null; %>  
<%
	String u_id=request.getParameter("u_id");
u4=UserDao.UserSearchInfo(Integer.parseInt(u_id));
    
%>

<div id="doc01" class="modal">
  
    <form class="modal-content animate" action="updateuserinfo" method="post">
      <div class="imgcontainer">
        <span onclick="document.getElementById('doc01').style.display='none'" class="close" title="Close Modal">&times;</span>
        <img src="https://i.ibb.co/r742zdc/387561-1.png" alt="Avatar" class="avatar">
      </div>
  
      <div class="container">
  <input type="hidden"  name="u_id" value="<%=u_id %>">
  <label for="h1_name"><b>Full Name</b></label>
      <input type="text" placeholder="Enter Full Name" name="h1_name" value="<%=u4.getU_name() %>" required>
        <label for="h1_age"><b>Age</b></label> 
        <input type="text" placeholder="Enter E-Mail" name="h1_age" value="<%=u4.getU_age() %>" required>
        
        <label for="h1_mob"><b>Mobile Number</b></label>
        <input type="text" placeholder="Enter Mobile Number" name="h1_mob" value="<%=u4.getU_mob() %>" required>
        
        <label for="h1_address"><b>Address</b></label>
        <input type="text" placeholder="Enter Address" name="h1_address" value="<%=u4.getU_add() %>" required>
        
        <label for="h1_gen"><b>Gender&emsp;&emsp; </b></label>
  		<input type="radio" name="gender" value="<%=u4.getU_gender() %>">Male&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
  		<input type="radio" name="gender"value="<%=u4.getU_gender() %>">Female&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
  		<input type="radio" name="gender" value="<%=u4.getU_gender() %>">Transgender
    
 
  <br><br>
      <label for="h1bgroup"><b>Blood Group</b></label>
        <input type="text" placeholder="Enter Blood Group" name="h1bgroup" value="<%=u4.getU_bgroup()  %>" required>
        
        <label for="h1sym"><b>Symptoms</b></label>
        <input type="text" placeholder="Enter Symptoms" name="h1sym" value="<%=u4.getU_sym()  %>"  required>
      
        <label for="h1dep"><b>Department</b></label>
        <input type="text" placeholder="Enter Department" name="h1dep" value="<%=u4.getU_dprt()  %>"  required>
  
        <label for="h1doa"><b>Date Of Appointment</b></label>
        <input type="date" id="Date Of Appointment" name="h1doa" value="<%=u4.getU_doa()  %>"  required>
          
        <button type="submit" value="Submit">Submit</button>
        
      </div>
  
      <div class="container" style="background-color:#f1f1f1">
        <button type="button" onclick="document.getElementById('doc01').style.display='none'" class="cancelbtn">Cancel</button>
       
        
    
       
      </div>
      </form>
      </div>


</body>
</html>