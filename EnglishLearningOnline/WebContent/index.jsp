<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="daos.ProfessorDao" %>
<%@page import="daos.CourseDao" %>
<%@page import="models.Professor" %>
<%@page import="models.Course" %>
<%@page import="java.util.List" %>
<%@page import="jdbc.DbUtil" %>
<%@page import="jdbc.InitDatabase" %>
<%
	//debug;
	InitDatabase.getInitDatabase().drop_db();
	InitDatabase.getInitDatabase().create_db();
	
	ProfessorDao pd = new ProfessorDao();
	List<Professor> allProfs = pd.getAllProfessorListJama();
	
	CourseDao cd = new CourseDao();
	List<Course> allAvCourses = cd.getAvCourseListJama();

%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>English Learning Online System</title>

    <!-- Bootstrap core CSS -->
    <!-- <link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css' rel='stylesheet'/>  -->
	
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
    <link href="plus/blog.css" rel="stylesheet">
    <link href="plus/bootstrap.css" rel="stylesheet">
    <link href="plus/bootstrap.min.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">
      <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
          <div class="col-4 pt-1">
          </div>
          <div class="col-4 text-center">
            <a class="blog-header-logo text-dark" href="#">English Learning Online System</a>
          </div>
          <div class="col-4 d-flex justify-content-end align-items-center">
          	<div class="control-group">
            	<a class="btn btn-sm btn-outline-secondary" href="register.jsp">Register</a>
            	<a class="btn btn-sm btn-outline-secondary" href="login.jsp">Log in</a>
            	</div>
          </div>
        </div>
      </header>

      <div class="nav-scroller py-1 mb-2">
        <nav class="nav d-flex justify-content-between">
          <a class="p-2 text-muted" href="#divProf">Professors</a>
          <a class="p-2 text-muted" href="#avCourses">Avialable courses</a>
          <a class="p-2 text-muted" href="#aboutUs">About us</a>
          <a class="p-2 text-muted" href="#license">License Agreement</a>
          <a class="p-2 text-muted" href="#contact">Contact</a>
        </nav>
      </div>

      <div class="jumbotron p-3 p-md-4 text-white rounded bg-dark">
        <div class="col-md-12 px-0">
          <h1 class="display-4 font-italic">Why you should learn English?</h1>
          <p class="lead my-3">Learning English is important and people all over the world decide to study it as a second language. Many countries include English as a second language in their school syllabus and children start learning English at a young age. </p>
          <p class="lead mb-0"><a href="#" class="text-white font-weight-bold">Continue reading...</a></p>
        </div>
      </div>

      <div class="row mb-2">
      	  <h3 class="pb-12 mb-4 font-italic border-bottom">
            Our beloved professors
          </h3>
      </div>
      <div class="row mb-2" id="divProf">
      <% for( int i = 0; i< allProfs.size(); i++){
						%>
						<div class="col-md-6">
          <div class="card flex-md-row mb-4 box-shadow h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
              <strong class="d-inline-block mb-2 text-primary">Blue</strong>
              <h3 class="mb-0">
                <a class="text-dark" href="#"><%=allProfs.get(i).getUsername() %></a>
              </h3>
              <div class="mb-1 text-muted">Nov 12</div>
              <p class="card-text mb-auto"><%=allProfs.get(i).getUsername() %> is one of the most experienced professors we have. See what courses Available.</p>
              <a href="login.jsp">See courses</a>
            </div>
          </div>
        </div>
						<%
					}%>
        
        
      </div>
    </div>

    <main role="main" class="container">
      <div class="row">
        <div class="col-md-8 blog-main" id="aboutUs">
          <h3 class="pb-3 mb-4 font-italic border-bottom">
            About us
          </h3>

          <div class="blog-post">
            <p class="blog-post-meta">January 1, 2018 by <a href="#">Xiubao</a></p>
		    <p class="mb-0">In order to get hired by top US companies you <em>should/must be good at English.</em> Not just basic English you also have to learn Advanced English. So we are here to help you.</p>
		    <blockquote>
            <p>Cum sociis natoque penatibus et magnis <a href="#">dis parturient montes</a>, nascetur ridiculus mus. Cras mattis consectetur purus sit amet fermentum.</p>
            </blockquote>
            <blockquote>
              <p>Curabitur blandit tempus porttitor. <strong>Nullam quis risus eget urna mollis</strong> ornare vel eu leo. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            </blockquote>
            <p>Donec ullamcorper nulla non metus auctor fringilla. Nulla vitae elit libero, a pharetra augue.</p>
            <ol>
              <li>Vestibulum id ligula porta felis euismod semper.</li>
              <li>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</li>
              <li>Maecenas sed diam eget risus varius blandit sit amet non magna.</li>
            </ol>
            <p>Cras mattis consectetur purus sit amet fermentum. Sed posuere consectetur est at lobortis.</p>
          </div>
          <h3 class="pb-3 mb-4 font-italic border-bottom" id="license">
            License Agreement
          </h3>

          <div class="blog-post">
            <p class="blog-post-meta">January 1, 2018 by <a href="#">Xiubao</a></p>
		    <p class="mb-0">In order to get hired by top US companies you <em>should/must be good at English.</em> Not just basic English you also have to learn Advanced English. So we are here to help you.</p>
		    <blockquote>
            <p>Cum sociis natoque penatibus et magnis <a href="#">dis parturient montes</a>, nascetur ridiculus mus. Cras mattis consectetur purus sit amet fermentum.</p>
            </blockquote>
            <blockquote>
              <p>Curabitur blandit tempus porttitor. <strong>Nullam quis risus eget urna mollis</strong> ornare vel eu leo. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            </blockquote>
            <p>Donec ullamcorper nulla non metus auctor fringilla. Nulla vitae elit libero, a pharetra augue.</p>
            <ol>
              <li>Vestibulum id ligula porta felis euismod semper.</li>
              <li>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</li>
              <li>Maecenas sed diam eget risus varius blandit sit amet non magna.</li>
            </ol>
            <p>Cras mattis consectetur purus sit amet fermentum. Sed posuere consectetur est at lobortis.</p>
          </div>

          <nav class="blog-pagination">
            <a class="btn btn-outline-primary" href="#">Older</a>
            <a class="btn btn-outline-secondary disabled" href="#">Newer</a>
          </nav>

        </div><!-- /.blog-main -->

        <aside class="col-md-4 blog-sidebar">
          <div class="p-3 mb-3 bg-light rounded">
            <p class="mb-0">Nothing is impossible, the word itself says “I’m possible”! —Audrey Hepburn</p>
          </div>

          <div class="p-3" id="avCourses" >
            <h4 class="font-italic">Avialable courses</h4>
            <ol class="list-unstyled mb-0">
            <% for(int i=0; i < allAvCourses.size(); i++){
				%>
				<li><a href="login.jsp"> <%=allAvCourses.get(i).getCoursename() %> </a> by <%=allAvCourses.get(i).getProfessorname() %> </li>
				
				<%
			}%>
            </ol>
          </div>

          <div class="p-3" id="contact">
            <h4 class="font-italic">Contact us</h4>
            <ol class="list-unstyled">
      		  <li><a href="#">Github</a></li>
              <li><a href="#">Twitter</a></li>
              <li><a href="#">Facebook</a></li>
            </ol>
          </div>
        </aside><!-- /.blog-sidebar -->

      </div><!-- /.row -->

    </main><!-- /.container -->

    <footer class="blog-footer">
      <p>We are using this template <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
      <p>
        <a href="#">Back to top</a>
      </p>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    
    <script src='//code.jquery.com/jquery-1.11.2.min.js'/>
	<script src='//code.jquery.com/jquery-migrate-1.2.1.min.js'/>
    <script src="../../../../assets/js/vendor/holder.min.js"></script>
    <script>
      Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
      });
    </script>
  </body>
</html>
