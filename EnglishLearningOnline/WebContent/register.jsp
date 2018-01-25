<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>English Learning Online System</title>

    <!-- Bootstrap core CSS -->
    <link href="plus/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="plus/signin.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action = "Register" method = "post">
        <h2 class="form-signin-heading">Please register</h2>
        <label for="inputEmail" class="sr-only">User Name</label>
        <input type="text" id="inputFirstName" name = "username" class="form-control" placeholder="User Name" required autofocus>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name = "email" class="form-control" placeholder="Email address" required>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name = "password" class="form-control" placeholder="Password" required>
        <label for="inputPassword" class="sr-only">Choose</label>
        <select class="custom-select d-block  w-100" name = "usertype" id="state" required>
          <option value="s">Student</option>
          <option value="p">Professor</option>
        </select>
        <br/>
        <button class="btn btn-lg btn-outline-secondary btn-block" type="submit">Register</button>
      </form>

    </div> <!-- /container -->
  </body>
</html>
