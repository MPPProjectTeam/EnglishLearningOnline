<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="plus/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="plus/signin.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action = "Login" method = "post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" name = "email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <div class="control-group">
        <button class="btn btn-lg btn-outline-secondary btn-block" type="submit">Sign in</button>
        <br/>
        <button type="button" class="btn btn-lg btn-link btn-block" onclick="window.location.href='register.jsp'">Are you new? Click here</button>
      	</div>  
      </form>
      
    </div> <!-- /container -->
  </body>
</html>
