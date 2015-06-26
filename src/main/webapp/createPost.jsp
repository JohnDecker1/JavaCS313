<%-- 
    Document   : createPost
    Created on : Jun 22, 2015, 8:30:54 AM
    Author     : john
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="cssH.css"/>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet"
     href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <!-- jQuery library -->
  <script 
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <!-- Latest compiled JavaScript -->
  <script 
    src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script 
    src="index.js"></script>
<link rel="stylesheet" type="text/css" href="invalid.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Discussion</title>
    </head>
    <body>
         <header>
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
<a class="navbar-brand" href="index.html">Lord of the Rings Discussion Board</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="dropdown"></li>
        </ul>
           <ul class="nav navbar-nav navbar-right">
        <li><a href="index.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
      </div>
      </div>
    </nav>
    </header>
        <div class="container body">
            <form class="form-horizontal" role="form" action="../CreatePost" method="post">
            <h1>Create a discussion about</h1>
            <h1>Lord of the Rings</h1>
            <label>Topic</label><br/>
            <input type="text" name="ides"/>
        <br/>
        <br/>
        <label>New Discussion</label>
        <br/>
        <br/>
        <textarea name="discuss" rows="4" cols="90"></textarea>
        <br/>
        <br/>
        <button type="submit" name="submit">Submit Discussion</button>
        <br/>
        <br/>
        <a href="viewPost.jsp">View Post Page</a>
            </form>
        </div>
    </body>
</html>
