
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	
		<title>Book Review System</title>
		<link rel="stylesheet" type="text/css" href="css/960_24_col.css" />
		<link rel="stylesheet" type="text/css" href="css/fonts.css" charset="utf-8" />
		<link href="css/validationEngine.jquery.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/forms.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script src="js/jquery-ui-1.9.2.custom.min.js" type="text/javascript"></script>
		<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
		<script src="js/jquery.validationEngine-en.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/jquery.bxslider.min.js"></script>
		<script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
		<script type="text/javascript">
		var relTag = "home";
		</script>
	</head>
<body>
	<!-- HEADER START -->
	<div class="header">
		
		<div class="container_24">
			<div class="grid_4">
				<img alt="logo" src="images/bookreview.png" class="img-logo" />
			</div>
			<div class="grid_20">
				<h1 class="title">Book Review System</h1>
			</div>
			<div class="clear"></div>
		</div>
		
		<div class="nav-main-container">
			<div class="container_24">
				<div class="grid_24">
					<ul id="topmenunav" class="nav-main">
						<li><a rel="home" href="index.html">Home</a></li>
						<li><a rel="citizen" href="registration.jsp">Registration</a></li>
						<li><a rel="help" href="#">Help</a></li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<!-- HEADER END -->
	
	
	<!-- CONTENTS START -->
	<div class="container_24">
		<div class="grid_24">
			<div class="contents">
			
			<div class="grid_18 omega">
						 &nbsp;&nbsp;<h2>User Login</h2>
							<div class="padding_20 text-justify">
								<form id="frmMain" class="frmMain" action="#" method="post">
									<table class="form-table" style="width:auto">
										<tr>
											<th>
												Email Id
											</th>
											<td>
												<input id="email" type="text"  class="validate[required]" name="email" style="width:120%" placeholder="demo@cybage.com" value=""  />
											</td>
											<td>
													<ul class="news-ticker1"><span class="icon">&#9734;</span> Must be Registered</ul>
											</td>
						
										</tr>
										
										<tr>
											<th>
												Password
											</th>
											<td>
												<input id="password" type="password"  class="validate[required]" name="password" style="width:120%" placeholder="password" value=""  />
											</td>
										
										</tr>
										<tr>
											<th>
												&nbsp;
											</th>
											<td>
												<input id="Submit1" type="submit" value="Sumbit"  />
												<input id="Reset1" type="reset" value="Reset" onclick="this.form.clear();" />
											</td>
											<td>
													<a href="forgetpassword.jsp">Forget Password?</a> 
											</td>
										</tr>
								
									</table>
								</form>
							</div>
						</div>
					
					<div class="clear"></div>
					</div>
				</div>
			</div>
				
				<div class="clear"></div>
				<div class="padding_20 text-justify">
				
				</div>
			
		</div>
	</div>
	<!-- CONTENTS END -->
	

	
	<!-- FOOTER START -->
	<div class="dark-nav footer">
		<div class="container_24">
			<div class="grid_8">
				<ul class="nav-alt">
					<li><a href="index.html">Home</a></li>
					<li><a href="#">Help</a></li>
				</ul>
			</div>
			<div class="grid_8">
				<div class="text-center">Copyright &copy; All Rights Reserved</div>
			</div>
			<div class="grid_8">
				<div class="text-right">Designed &amp; Developed by Dipak</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>	
	<!-- FOOTER START -->


</body>
	
</html>
