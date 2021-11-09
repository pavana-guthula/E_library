<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>E-library Error</title>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: linear-gradient(to right, #b92b27, #1565c0)
}

.card {
	margin-bottom: 20px;
	border: none
}

.box {
	width: 500px;
	padding: 40px;
	position: absolute;
	top: 10%;
	left: 30%;
	background: #191919;;
	text-align: center;
	transition: 0.25s;
	margin-top: 100px
}

.box input[type="text"], .box input[type="password"] {
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 10px 10px;
	width: 250px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s
}

.box h1 {
	color: white;
	text-transform: uppercase;
	font-weight: 500
}

.box input[type="text"]:focus, .box input[type="password"]:focus {
	width: 300px;
	border-color: #2ecc71
}

.box >a {
    text-decoration: none;
	border: 0;
	width: 40px;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #2ecc71;
	padding: 14px 40px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
	cursor: pointer
}

.box >a:hover {
	background: #2ecc71
}

.forgot {
	text-decoration: underline
}

ul.social-network {
	list-style: none;
	display: inline;
	margin-left: 0 !important;
	padding: 0
}

ul.social-network li {
	display: inline;
	margin: 0 5px
}

.social-network a.icoFacebook:hover {
	background-color: #3B5998
}

.social-network a.icoTwitter:hover {
	background-color: #33ccff
}

.social-network a.icoGoogle:hover {
	background-color: #BD3518
}

.social-network a.icoFacebook:hover i, .social-network a.icoTwitter:hover i,
	.social-network a.icoGoogle:hover i {
	color: #fff
}

a.socialIcon:hover, .socialHoverClass {
	color: #44BCDD
}

.social-circle li a {
	display: inline-block;
	position: relative;
	margin: 0 auto 0 auto;
	border-radius: 50%;
	text-align: center;
	width: 50px;
	height: 50px;
	font-size: 20px
}

.social-circle li i {
	margin: 0;
	line-height: 50px;
	text-align: center
}

.social-circle li a:hover i, .triggeredHover {
	transform: rotate(360deg);
	transition: all 0.2s
}

.social-circle i {
	color: #fff;
	transition: all 0.8s;
	transition: all 0.8s
}
</style>

<div class="container">
	<div class="row">
		<div class="col-md-6">
			<div class="card">
				<div style="border-radius: 15%" class="box">
					<h1 style="font-size: 40px">e-Article Library</h1>
					<p style="color: white; font-size: 25px" class="text-muted">Error</p>
					<p style="color: white; font-size: 20px">${errorMessage}</p>
                    <a href="/${redirect}">Home</a>
				</div>
			</div>
		</div>
	</div>
</div>