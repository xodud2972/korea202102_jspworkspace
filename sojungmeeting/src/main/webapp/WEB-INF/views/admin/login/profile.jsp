<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Contact Us SoJung</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
  
  <!-- custom CSS File -->
  <link href="assets/css/custom.css" rel="stylesheet">
</head>
<body>

  <!-- 본문 시작 -->

<!-- ======= Header ======= -->
<header id="header" class="header-transparent header-fixed">
  <div class="container">

    <div id="logo" class="pull-left">
      <h1><a href="index.html" class="scrollto">Avilon</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html"><img src="assets/img/logo.png" alt=""></a> -->
    </div>

    <nav id="nav-menu-container">
      <ul class="nav-menu">
        <li class="menu-active"><a href="index.html">Home</a></li>
        <li><a href="#about">About Us</a></li>
        <li><a href="#features">Features</a></li>
        <li><a href="#pricing">Pricing</a></li>
        <li><a href="#team">Team</a></li>
        <li><a href="#gallery">Gallery</a></li>
        <li class="menu-has-children"><a href="">Drop Down</a>
          <ul>
            <li><a href="#">Drop Down 1</a></li>
            <li class="menu-has-children"><a href="#">Drop Down 2</a>
              <ul>
                <li><a href="#">Deep Drop Down 1</a></li>
                <li><a href="#">Deep Drop Down 2</a></li>
                <li><a href="#">Deep Drop Down 3</a></li>
                <li><a href="#">Deep Drop Down 4</a></li>
                <li><a href="#">Deep Drop Down 5</a></li>
              </ul>
            </li>
            <li><a href="#">Drop Down 3</a></li>
            <li><a href="#">Drop Down 4</a></li>
            <li><a href="#">Drop Down 5</a></li>
          </ul>
        </li>
        <li><a href="#contact">Contact Us</a></li>
      </ul>
    </nav><!-- #nav-menu-container -->
  </div>
</header><!-- End Header -->

<h2>Responsive Contact Section</h2>
<p>Resize the browser window to see the effect.</p>

<div class="container">
  <div style="text-align:center">
    <h2>Contact Us</h2>
    <p>Swing by for a cup of coffee, or leave us a message:</p>
  </div>
  <div class="swiper">
  
	  <div class="swiper__row">
	    <div class="swiper__column">
	      <img src="img.jpg" style="width:100%" >
	    </div>
	    <div class="swiper__column">
	      <form action="/action_page.php">
	        <label for="fname">First Name</label>
	        <input type="text" id="fname" name="firstname" placeholder="Your name..">
	        <label for="lname">Last Name</label>
	        <input type="text" id="lname" name="lastname" placeholder="Your last name..">
	        <label for="lname">Last Name</label>
	        <input type="text" id="lname" name="lastname" placeholder="Your last name..">
	        <label for="lname">Last Name</label>
	        <input type="text" id="lname" name="lastname" placeholder="Your last name..">
	        <label for="lname">Last Name</label>
	        <input type="text" id="lname" name="lastname" placeholder="Your last name..">
	        <label for="country">Country</label>
	        <select id="country" name="country">
	          <option value="australia">Australia</option>
	          <option value="canada">Canada</option>
	          <option value="usa">USA</option>
	        </select>
	        <label for="subject">Subject</label>
	        <textarea id="subject" name="subject" placeholder="Write something.." style="height:170px"></textarea>
	        <input type="submit" value="Submit">
	      </form>
	    </div>
	  </div>
  
  </div>
</div>
  <!-- //본문 끝 -->

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/wow/wow.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/superfish/superfish.min.js"></script>
  <script src="assets/vendor/hoverIntent/hoverIntent.js"></script>
  
  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

  <!-- Custom Js -->
  <script src="assets/js/socustom.js"></script>
</body>
</html>
