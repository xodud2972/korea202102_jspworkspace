<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Avilon Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="/resources/assets/img/favicon.png" rel="icon">
  <link href="/resources/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="/resources/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/assets/vendor/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="/resources/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="/resources/assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="/resources/assets/vendor/venobox/venobox.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="/resources/assets/css/style.css" rel="stylesheet">
  
  
  <!-- custom CSS File -->
  <link href="/resources/assets/css/paycustom.css" rel="stylesheet">
 
</head>
<body>

<!-- ======= Header ======= -->
<header id="header" class="header-transparent header-fixed">
  <div class="container">

    <div id="logo" class="pull-left">
      <h1><a href="index.html" class="scrollto">Ollang Ollang</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html"><img src="/resources/assets/img/logo.png" alt=""></a> -->
    </div>

    <nav id="nav-menu-container">
      <ul class="nav-menu">
        <li class="menu-active"><a href="index.html">Home</a></li>
      
        <li><a href="#team">Board</a></li>
        <li><a href="#gallery">Chat</a></li>
        <li class="menu-has-children"><a href="">Love Matching</a>
          <ul>
            <li><a href="#">My Page</a></li>
            <li class="menu-has-children"><a href="#">Gallery</a>
              <ul>
                <li><a href="#">Male</a></li>
                <li><a href="#">Female</a></li>
              </ul>
            </li>
            <li><a href="#">Cart</a></li>
          </ul>
        </li>
        <li><a href="#contact">Login</a></li>
      </ul>
    </nav><!-- #nav-menu-container -->
  </div>
</header><!-- End Header -->

<main id="main">

<h4>Payment Page</h4>
<p>빈칸에 알맞는 형식을 적고 결제버튼을 누르세요.</p><br>
<div class="row">
  <div class="col-75">
    <div class="base_container">
      <form action="/action_page.php">
      
        <div class="row">
          <div class="col-50">
            <h3>OLLANG OLLANG 결제 페이지</h3>
            <label for="fname"><i class="fa fa-user"></i>결제하실 이름</label>
            <input type="text" id="fname" name="c_name" placeholder="John M. Doe">
            <label for="email"><i class="fa fa-envelope"></i> 카드 종류</label>
            <input type="text" id="email" name="c_card" placeholder="우리카드">
            <label for="adr"><i class="fa fa-address-card-o"></i> 카드 번호</label>
            <input type="text" id="adr" name="c_number" placeholder="1111-5555-7777-9999">
            <label for="city"><i class="fa fa-institution"></i> 이메일</label>
            <input type="text" id="city" name="c_email" placeholder="kimkkkkkkk@daum.net">

            <div class="row">
              <div class="col-50">
                <label for="state">Month</label>
                <input type="text" id="state" name="c_month" placeholder="09">
              </div>
              <div class="col-50">
                <label for="zip">Year</label>
                <input type="text" id="zip" name="c_year" placeholder="2027">
              </div>
            </div>
          </div>

          <div class="col-50">
        
        	<label for="cname" id="cc">결제방법(신용/체크)</label>
            <input type="text" id="cname" name="c_cardtype" placeholder="신용카드">        
        
            <label for="cname">할부개월</label>
            <input type="text" id="cname" name="c_pull" placeholder="일시불">
            <label for="ccnum">환불받으실 은행</label>
            <input type="text" id="ccnum" name="c_bank" placeholder="우리은행">
            <label for="expmonth">환불 받으실 계좌번호</label>
            <input type="text" id="expmonth" name="c_account" placeholder="1001-9999-8888-77">
            <div class="row">
              <div class="col-50">
                <label for="expyear">카드 명의자</label>
                <input type="text" id="expyear" name="c_owner" placeholder="박귀자">
              </div>
              <div class="col-50">
                <label for="cvv">CVC,CVV,CCV</label>
                <input type="text" id="cvv" name="c_ccc" placeholder="352">
              </div>
            </div>
          </div>
          
        </div>
        <label>
          <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
        </label>
       <button type="button" class="btn" onClick="">결제하기</button>
      </form>
    </div>
  </div>
  <div class="col-25">
    <div class="base_container">
      <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>4</b></span></h4>
      <p><a href="#">Product 1</a> <span class="price">$15</span></p>
      <p><a href="#">Product 2</a> <span class="price">$5</span></p>
      <p><a href="#">Product 3</a> <span class="price">$8</span></p>
      <p><a href="#">Product 4</a> <span class="price">$2</span></p>
      <hr>
      <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
    </div>
  </div>

</main>

  <!-- Vendor JS Files -->
  <script src="/resources/assets/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="/resources/assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="/resources/assets/vendor/php-email-form/validate.js"></script>
  <script src="/resources/assets/vendor/wow/wow.min.js"></script>
  <script src="/resources/assets/vendor/venobox/venobox.min.js"></script>
  <script src="/resources/assets/vendor/superfish/superfish.min.js"></script>
  <script src="/resources/assets/vendor/hoverIntent/hoverIntent.js"></script>
  
  <!-- Template Main JS File -->
  <script src="/resources/assets/js/main.js"></script>

  <!-- Custom Js -->
  <script src="/resources/assets/js/custom.js"></script>
  
  <script type="text/javascript">
  
//상품 등록 요청
 // function regist(){
 // 	$("form").attr({
 // 		action:"/admin/inc/payment",
//  		method:"post",
 // 		enctype:"multipart/form-data"
 // 	});
 // 	$("form").submit();
//  }
  </script>
</body>
</html>