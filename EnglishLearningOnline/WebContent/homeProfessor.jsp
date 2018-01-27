<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>English Learning Online System</title>

<!-- Bootstrap core CSS -->
<!-- <link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css' rel='stylesheet'/>  -->

<!-- Custom styles for this template -->
<link
	href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900"
	rel="stylesheet">
<link href="plus/blog.css" rel="stylesheet">
<link href="plus/bootstrap.css" rel="stylesheet">
<link href="plus/bootstrap.min.css" rel="stylesheet">
</head>
<%
    session=request.getSession(false);
    if(session.getAttribute("userName")==null)
    {
        response.sendRedirect("index.jsp");
    }

%>
<body>

	<div class="container">
		<header class="blog-header py-3">
			<div
				class="row flex-nowrap justify-content-between align-items-center">
				<div class="col-4 pt-1"></div>
				<div class="col-4 text-center">
					<a class="blog-header-logo text-dark" href="#">English Learning
						Online System</a>
				</div>
				<div class="col-4 d-flex justify-content-end align-items-center">

					<div class="control-group">
						<p>Professor Name</p>
						<a class="btn btn-sm btn-outline-secondary" href="index.jsp">Log
							out</a>
					</div>
				</div>
			</div>
		</header>

		<div class="nav-scroller py-1 mb-2">
			<nav class="nav d-flex justify-content-between">
				<a class="p-2 text-muted" href="#">Create Course</a> <a
					class="p-2 text-muted" href="#">Upload Materials</a> <a
					class="p-2 text-muted" href="#">Feedbacks</a>
			</nav>
		</div>
		<hr>



		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 blog-main">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Register course</h5>
						<form class="needs-validation card-text">
							<div class="mb-3">
								<label for="username">Course Name</label>
								<div class="input-group">
									<input type="text" class="form-control" id="username"
										placeholder="Username" required>
								</div>
							</div>
							<div class="mb-3">
								<label for="country">Prerequisite Course</label> 							
								<div class="input-group">
									<select
										class="custom-select d-block w-100" id="country" required>
										<option value="">EL101</option>
										<option>EL102</option>
										<option>IELTS PREP</option>
										<option>TOEFL PREP</option>
									</select>

								</div>
							</div>
							<div class="custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input"
									id="same-address"> <label class="custom-control-label"
									for="same-address">I accept the License and User Agreement of English Learning Online System</label>
							</div>


							<hr class="mb-4">
							<button class="btn btn-outline-secondary btn-lg btn-block"
								type="submit">Create Course</button>
						</form>

					</div>
				</div>
				<hr>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Upload Materials</h5>
						<form class="needs-validation card-text">
							<div class="col-md-4 mb-3">
								<label for="state">Choose Course</label> <select
									class="custom-select d-block w-100" id="state" required>
									<option value="">EL101</option>
									<option>EL102</option>
									<option>TOEFL PREP</option>
									<option>IELTS PREP</option>
								</select>
							</div>
							<div class="col-md-4 mb-3">
								<label for="state">File input</label> <input type="file"
									class="form-control-file" id="exampleFormControlFile1">
							</div>
							<hr class="mb-4">
							<button class="btn btn-outline-secondary btn-lg btn-block"
								type="submit">Upload</button>
						</form>
					</div>
				</div>
				<hr>
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Feedbacks</h5>
						
						<form class="needs-validation card-text">
							<div class="card mb-4 box-shadow">
								<div class="card-header">
									<h5 class="my-0 font-weight-normal">Jamsrandorj <small class="text-muted">12 Jan 2018 - EL101</small></h5>
								</div>
								<div class="card-body">
									<p>This is the first feedback test. I've just created this in order to look professional our project.</p>
									<button type="button" class="btn btn-primary" type="submit">Reply</button> 
									<button type="button" class="btn" type="submit">Hide</button>
								</div>
							</div>
						</form>
						<form class="needs-validation card-text">
							<div class="card mb-4 box-shadow">
								<div class="card-header">
									<h5 class="my-0 font-weight-normal">Xiubao <small class="text-muted">12 Jan 2018 - TOEFL PREP</small></h5>
								</div>
								<div class="card-body">
									<p>This is the first feedback test. I've just created this in order to look professional our project.</p>
									<button type="button" class="btn btn-primary" type="submit">Reply</button> 
									<button type="button" class="btn" type="submit">Hide</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<hr>
			</div>


			<aside class="col-md-4 blog-sidebar">
				<div class="p-3 mb-3 bg-light rounded">
					<p class="mb-0">The Heart is your student, for love is the only
						way we learn.</p>
				</div>

				<div class="p-3">
					<h4 class="font-italic">Teaching courses</h4>
					<ol class="list-unstyled mb-0">
						<li><a href="#">EL101</a></li>
						<li><a href="#">EL102</a></li>
						<li><a href="#">TOEFL PREP</a></li>
						<li><a href="#">IELTS PREP</a></li>
						<li><a href="#">GRE PREP</a></li>
					</ol>
				</div>

				<div class="p-3">
					<h4 class="font-italic">Contact us</h4>
					<ol class="list-unstyled">
						<li><a href="#">GitHub</a></li>
						<li><a href="#">Twitter</a></li>
						<li><a href="#">Facebook</a></li>
					</ol>
				</div>
			</aside>
			<!-- /.blog-sidebar -->

		</div>
		<!-- /.row --> </main>
		<!-- /.container -->

		<footer class="blog-footer">
			<p>
				We are using this template <a href="https://getbootstrap.com/">Bootstrap</a>
				by <a href="https://twitter.com/mdo">@mdo</a>.
			</p>
			<p>
				<a href="#">Back to top</a>
			</p>
		</footer>

		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script>
			window.jQuery
					|| document
							.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')
		</script>


		<script src="../../../../assets/js/vendor/holder.min.js"></script>
		<script>
			Holder.addTheme('thumb', {
				bg : '#55595c',
				fg : '#eceeef',
				text : 'Thumbnail'
			});
		</script>
</body>
</html>
