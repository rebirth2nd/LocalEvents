<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.text.*,java.util.*,com.eller.sd.bean.*"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search For Events</title>

 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

  <script>
  $(function() {
    $( "#datepicker1" ).datepicker({ dateFormat: 'yy-mm-dd' });
    $( "#datepicker2" ).datepicker({ dateFormat: 'yy-mm-dd' });
  });

  function manageDisplay(value)
  {
	  if((value=="Category")||(value=="Title"))
	  {
		  document.getElementById("date_range").style.display="none";
		  document.getElementById("title_tag").style.display="inline";		  
	  } else
	  {
		  document.getElementById("date_range").style.display="inline";
		  document.getElementById("title_tag").style.display="none";	
	  }
  }
  </script>
  
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


<!-- jumbotron -->
	<div class="container">
	<div class="jumbotron">

		<h1>Meet People, Have Fun</h1>
            <p class="lead">Subheading about your products</p>
            
		<form class="form-inline" role="search" action="SearchServlet" method ="post">
			
			
			
			<div class="form-group">
				<div id="title_tag"  style="display:inline;">

						<input type="text" class="form-control" placeholder="Search" name="keyword">

				</div>
				
				<div class="form-group form-inline" id="date_range" style="display:none;">
						<div class="form-group">
						<input type="text" name="event_startdate"  id ="datepicker1" class="form-control" placeholder="Start Date"/>
						</div>
						<div class="form-group">
						<input type="text" name="event_enddate"  id ="datepicker2" class="form-control" placeholder="End Date"/>
						</div>

				</div>
			</div>
			
			<div class="form-group">
			<select class="selectpicker" data-style="btn-success" data-width="125px" name="type" onchange="manageDisplay(this.value)">
					<option value="Category">Event Tag</option>
					<option value="Title">Event Title</option>
					<option value="Date">Event Date</option>
			</select>
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-success btn-sm">Search</button>
			</div>
				
			</form>
</div></div>

<div class="container">
<table class="event_listing">
    	<tbody>
<%
ArrayList<Event> events = (ArrayList<Event>)request.getAttribute("events");
ArrayList<String> registered = (ArrayList<String>)request.getAttribute("registered");

if(events!=null)
{
	request.getSession().setAttribute("events", events);
	for(String s:registered)
		System.out.println(s);
	for(Event e:events)
	{
	%>
		<tr class="event_listing_item clrfix">

    <td class="date">
        <strong><% 	
        		Date dbDate = e.getEvent_startdate();
        		SimpleDateFormat ft = new SimpleDateFormat ("E");		
        		out.print(ft.format(dbDate)); %></strong>
        <%  	SimpleDateFormat ft2 = new SimpleDateFormat ("MMM d");		
        		out.print(ft2.format(dbDate)); %>
    </td>

    <td class="info">
        
            <a href="" data-rank="0" class="js-search-result-click-action" target="_blank">
                <%=e.getEvent_name() %>
            </a>
        

        <p class="channels">
            <%=e.getEvent_description() %>
        </p>
        <table>
            <tbody>
                <tr>
                    <th>When:</th>
                    <td><% 
        				   SimpleDateFormat ft3 = new SimpleDateFormat ("MMM d, YYYY");		
        				   out.print(ft3.format(dbDate)); %> at <%=e.getEvent_starttime() %></td>
                </tr>
                <tr>
                    <th>Where:</th>
                    <td><%=e.getLocation() %></td>
                </tr>
            </tbody>
        </table>

    </td>
    
    <td class="eventButtonList">
		<% System.out.println("registered.contains("+"\""+e.getEvent_name()+"\""+")");
		if(registered.contains(e.getEvent_name())==true){ 
		%>
		
		<form action="Event_Registration" method="post">
		<button type="submit" value="UnRegister" name="submit" class="btn btn-success btn-sm">Unregister</button>
		<input type="hidden" name="event_name" value="<%=e.getEvent_name()%>">
		<input type="hidden" name="page_name" value="fromsearch">		
		</form>
		
		<%} else { %>
		
		<form action="Event_Registration" method="post">
		<button type="submit" value="Register" name="submit" class="btn btn-success btn-sm">Register</button>
		<input type="hidden" name="event_name" value="<%=e.getEvent_name()%>">
		<input type="hidden" name="page_name" value="fromsearch">		
		</form>
		
		<% } %>
    </td>
</tr>
		
	<%}}

%>

</tbody></table>
</div>
</div> <!--  warp end here -->

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
	
	
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
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