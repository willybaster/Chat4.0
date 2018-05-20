<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<script> 
			function validate()
			{ 
			 var username = document.form.username.value; 
			 var password = document.form.password.value;
			 
			 if (username==null || username=="")
			 { 
			 alert("Username cannot be blank"); 
			 return false; 
			 }
			 else if(password==null || password=="")
			 { 
			 alert("Password cannot be blank"); 
			 return false; 
			 } 
			}
		</script> 
	</head>
	<body>
	
		<div class="container">
	      <div class="row">
	         <div class="col-md-6">
		         <div class="panel with-nav-tabs panel-info">
					<form name="form" action="LoginServlet" method="post" onsubmit="return validate()">
			            <div class="panel-body">
			               <div class="tab-content">
			                  <div id="login" class="tab-pane fade in active register">
			                     <div class="container-fluid">
			                        <div class="row">
			                              <h2 class="text-center" style="color: #5bc0de;"> <strong> Login  </strong></h2><hr/>
			                              <div class="row">
			                                 <div class="col-xs-12 col-sm-12 col-md-12">
			                                    <div class="form-group">
			                                       <div class="input-group">
			                                          <div class="input-group-addon">
			                                             <span class="glyphicon glyphicon-user"></span>
			                                          </div>
			                                          <input type="text" placeholder="User Name" name="username" class="form-control">
			                                       </div>
			                                    </div>
			                                 </div>
			                              </div>
			
			                              <div class="row">
			                                 <div class="col-xs-12 col-sm-12 col-md-12">
			                                    <div class="form-group">
			                                       <div class="input-group">
			                                          <div class="input-group-addon">
			                                             <span class="glyphicon glyphicon-lock"></span>
			                                          </div>
			
			                                          <input type="password" placeholder="Password" name="password" class="form-control">
			                                       </div>
			                                    </div>
			                                 </div>
			                              </div>
			                              <hr />
			                              <div class="row">
			                                 <div class="col-xs-12 col-sm-12 col-md-12">
			                                    <button type="submit" value="login" class="btn btn-block btn-lg btn-login"> Login </button>
			                                    <a class="btn btn-block btn-lg btn-login" href="register.jsp">Sign Up!</a>
			                                 </div>
			                              </div>
			
			                       	 	</div>
			                    	 </div> 
			                  	</div>
			               		</div>
			            	</div>
		            	</form>
	         		</div>
	     	 	</div>
	   		</div>
		</div>
	</body>
</html>