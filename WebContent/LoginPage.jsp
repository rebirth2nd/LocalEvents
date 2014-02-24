<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	
	<link href="dist/css/bootstrap.css" rel="stylesheet">
	<link href="dist/css/home.css" rel="stylesheet">
	<link href="dist/css/bootstrap-select.min.css" rel="stylesheet">
	<style>
	
		html {
			height: 100%;
		}
	
		body {
			height: 100%;
			padding-top: 70px;
		}	
		
		/* Wrapper for page content to push down footer */
		#wrap {
			min-height: 100%;
			height: auto;
			/* Negative indent footer by its height */
			margin: 0 auto -45px;
			/* Pad bottom by footer height */
			padding: 0 0 45px;
		}
		
		/* Set the fixed height of the footer here */
		#footer {
			height: 45px;
			background-color: #f5f5f5;
		}
		
		td a {
			font-size: 18px;
		}
		
		.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  font-size: 16px;
  height: auto;
  padding: 10px;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
		
	</style>
	
</head>

<body>
<div id="wrap">
	<!-- Fixed navbar -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
		  
		  <!-- Brand header here -->
          <a class="navbar-brand" href="HomePageServlet">WildcatEvents!<sup>TM</sup> <small>(Beta)</small></a>
		  
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="HomePageServlet">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="EventCreation.jsp">Create an Event</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">More <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
		  
          <ul class="nav navbar-nav navbar-right">
            <%
				HttpSession session1 = request.getSession();
				if(session1.getAttribute("username")!=null)
 				{%>
 					<p class="navbar-text">Welcome, <%=session1.getAttribute("username")  %>!</p>
			  <%} else
					{%>
					<li><a href="LoginPage.jsp">Sign In</a></li>
					<li><a href="UserorBusiness.jsp">Register Now!</a></li>
				<%	
					} %>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

<div class="container">

      <form class="form-signin" action="loginServlet" method = "post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" name="username" placeholder="Username" required autofocus>
        <input type="password" class="form-control" name="password" placeholder="Password" required>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="login">Sign in</button>
      </form>

</div> <!-- /container -->


</div> <!--  wrap end -->


<!-- Fixed footer -->
	<div id="footer">
      <footer>
        <div class="container">
        <div class="row">
          <div class="col-md-5">
			Copyright &copy 2012-2013 WildcatEvents Inc. All rights reserved.
		  </div>
		  <div class="col-md-2">
			<a href="/terms/">Terms of Use/Privacy</a>
		  </div>
		  
		  <div class="col-md-5">
			<a href="https://twitter.com/intent/tweet?button_hashtag=WildcatEvents&text=Check%20out%20wildcatEvents.com,%20a%20cool%20event%20poster!" class="twitter-hashtag-button" data-related="WildcatEvents">Tweet #WildcatEvents</a>
			<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="https://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
			<a href="https://twitter.com/WildcatEvents" class="twitter-follow-button" data-show-count="false"  data-show-screen-name="false" data-dnt="true">Follow @WildcatEvents</a>
			<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="https://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
			<script src="https://platform.linkedin.com/in.js" type="text/javascript"></script>
			<script type="IN/Share" data-url="http://www.google.com" data-counter="right"></script>
			<div class="fb-like" data-href="http://www.google.com" data-send="true" data-layout="button_count" data-width="450" data-show-faces="false" data-colorscheme="dark" style="vertical-align:top;zoom:1;*display:inline"></div>
		  </div>
		  
		</div>
        </div>
      </footer>
    </div>
	
	
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="dist/js/bootstrap.min.js"></script>
	<script src="dist/js/bootstrap-select.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.selectpicker').selectpicker({
			});
		});
	</script>
</body>
</html>