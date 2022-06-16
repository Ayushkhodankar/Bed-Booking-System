
<%@ page import="java.sql.*" %>
<%@ page import="controller.BedDropdown"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
body {
 
  background-repeat: no-repeat;
  background-attachment: fixed;  
  font-family: Arial, Helvetica, sans-serif;
  background-image: url("https://i.ibb.co/QPpPvX9/medical-healthcare-blue-color-1017-26807.webp");
  background-size: 100%;
  margin: 0;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}


li a:hover:not(.active) {
  background-color: #555;
  color: white;
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
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  padding-top: 60px;
}

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


    <br/>
    <center><img src="https://i.ibb.co/tJSrcW6/4228704-2.png" alt="Avatar" class="avatar">
    </center>    
    <pre><h1>                                              Welcome User!</h1></pre><br/><br/>
    <div class="navbar">
  <a href="#register" onclick="document.getElementById('reg01').style.display='block'">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Book beds</a>
  <a href="#show">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Show Schedule</a>

  <a href="index.html">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;LogOut</a>
 
  
  </div>
<div id="reg01" class="modal">
  
    <form class="modal-content animate" action="updatebed" method="post">
      <div class="imgcontainer">
        <span onclick="document.getElementById('reg01').style.display='none'" class="close" title="Close Modal">&times;</span>
        <img src="https://i.ibb.co/tJSrcW6/4228704-2.png" alt="Avatar" class="avatar">
      </div>
  
      <div class="container">
     <% ResultSet rs1=null; %>
     <% String q1 = "Select * from reg_beds ";
     	rs1 = BedDropdown.validate(q1);
     %>
     
     <% 
     ResultSet rs2=null;
     String q2 = "Select * from reg_beds ";
  	rs2 = BedDropdown.validate(q2);
     
     %>
     
     <% 
     ResultSet rs3=null;
     String q3 = "Select * from reg_beds ";
  	rs3 = BedDropdown.validate(q3);
     
     %>
      
        
      <!--   <label for="room_type">Choose Room Type</label>
       <select name="room_type" id="room_type">
       <option value="ac">AC</option>
       <option value="nonac">Non-AC</option>
       <option value="general">General</option>
       </select> -->
		<br><br>
		 <label for="room_no">Choose Room Number</label>
       <select name="room_no" id="room_no"> 
       <%while(rs1.next()){ %>
       <option value=""><%= rs1.getString(1) %></option>
   	 <%} %>
       </select>
       <br><br>
       <label for="bed_no">Choose Bed Number</label>
       <select name="bed_no" id="bed_no">
       <%while(rs2.next()){ %>
       <option><%= rs2.getString(2) %></option>
   	 <%} %>
       </select>
       <br><br>
       
        <label for="price"><b>Price</b></label>
        <select  name="price" id="price">
        <%while(rs3.next()){ %>
       <option value=""><%= rs3.getString(3) %></option>
   	 <%} %>
		</select>
		
   <!--   <input type="hidden" id="status" name="status" value="booked"> -->
   
          
        <button type="submit" value="Submit">Submit</button>
        
      </div>
  
      <div class="container" style="background-color:#f1f1f1">
        <button type="button" onclick="document.getElementById('reg01').style.display='none'" class="cancelbtn">Cancel</button>
       
      </div>
      </form>
      </div>



</body>
</html>


