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

      <form class="form-signin">
        <h2 class="form-signin-heading">Please register</h2>
        <label for="inputEmail" class="sr-only">First Name</label>
        <input type="text" id="inputFirstName" class="form-control" placeholder="First Name" required autofocus>
        <label for="inputEmail" class="sr-only">Last Name</label>
        <input type="text" id="inputLastName" class="form-control" placeholder="Last Name" required>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="professor"> Professor
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
      </form>

    </div> <!-- /container -->
  </body>
</html>
