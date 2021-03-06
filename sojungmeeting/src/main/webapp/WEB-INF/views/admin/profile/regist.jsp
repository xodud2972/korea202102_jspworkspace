<%@page import="com.koreait.meeting.domain.ProFile"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	ProFile proFile=(ProFile)request.getAttribute("proFile");
%>
<!DOCTYPE html>
<html>

  <head>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
	
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />

    <title>Avilon Bootstrap Template</title>
    <meta content="" name="description" />
    <meta content="" name="keywords" />

    <!-- Favicons -->
    <link href="/resources/assets/img/favicon.png" rel="icon" />
    <link href="/resources/assets/img/apple-touch-icon.png" rel="apple-touch-icon" />

    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700|Open+Sans:300,300i,400,400i,700,700i"
      rel="stylesheet"
    />

    <!-- Vendor CSS Files -->
    <link
      href="/resources/assets/vendor/bootstrap/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link href="/resources/assets/vendor/ionicons/css/ionicons.min.css" rel="stylesheet" />
    <link href="/resources/assets/vendor/animate.css/animate.min.css" rel="stylesheet" />
    <link
      href="/resources/assets/vendor/font-awesome/css/font-awesome.min.css"
      rel="stylesheet"
    />
    <link href="/resources/assets/vendor/venobox/venobox.css" rel="stylesheet" />

    <!-- Template Main CSS File -->
    <link href="/resources/assets/css/style.css" rel="stylesheet" />

    <!-- custom CSS File -->
    <link href="/resources/assets/css/profilecustom.css" rel="stylesheet" />
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
            <li class="menu-has-children">
              <a href="">Love Matching</a>
              <ul>
                <li><a href="#">My Page</a></li>
                <li class="menu-has-children">
                  <a href="#">Gallery</a>
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
        </nav>
        <!-- #nav-menu-container -->
      </div>
    </header>
    <!-- End Header -->

    <main id="main">
      <h4>Payment Page</h4>
      <p>????????? ????????? ????????? ?????? ??????????????? ????????????.</p>
      <br />

      <div id="container">
        <!-- ????????? ?????? -->
        <!-- The four columns -->
        <div class="picture">
          <div class="picture_row" id="pictureList"></div>
          <div class="picture_swiper">
            <span
              onclick="this.parentElement.style.display='none'"
              class="closebtn"
              >&times;</span
            >
            <img id="expandedImg" />
            <div id="imgtext"></div>
          </div>
        </div>
        <!-- ????????? ??? -->
        <div class="row">
          <div class="col-75">
            <div class="base_container">
              <form action="/action_page.php">
                <div class="row">
                  <div class="col-50">
                    <label for="fname"
                      ><i class="fa fa-user"></i>NickName</label
                    >
                    <input
                      type="text"
                      id="fname"
                      name="nickname"
                      placeholder="Your name.."
                    />
                    <label for="email"><i class="fa fa-envelope"></i>Age</label>
                    <input
                      type="text"
                      id="email"
                      name="age"
                      placeholder="Your age.."
                    />
                    <label for="adr"
                      ><i class="fa fa-address-card-o"></i> sex</label
                    >
                    <input
                      type="text"
                      id="adr"
                      name="sex"
                      placeholder="Your sex.."
                    />
                    <label for="city"
                      ><i class="fa fa-institution"></i>Height</label
                    >
                    <input
                      type="text"
                      id="city"
                      name="height"
                      placeholder="Your height.."
                    />

                    <div class="row">
                      <div class="col-50">
                        <label for="subject">Introduce</label>
                        <textarea
                          id="text"
                          name="introduce"
                          placeholder="Your Introduce.."
                          style="width: 100%"
                        ></textarea>
                      </div>
                    </div>
                  </div>

                  <div class="col-50">
                    <div class="row">
                      <div class="col-50">
                        <label for="fname"
                          ><i class="fa fa-user"></i>Weight</label
                        >
                        <input
                          type="text"
                          id="fname"
                          name="weight"
                          placeholder="Your weight.."
                        />
                        <label for="email"
                          ><i class="fa fa-envelope"></i> Job</label
                        >
                        <input
                          type="text"
                          id="email"
                          name="job"
                          placeholder="Your job.."
                        />
                        <label for="adr"
                          ><i class="fa fa-address-card-o"></i>Area</label
                        >
                        <input
                          type="text"
                          id="adr"
                          name="area"
                          placeholder="Your area.."
                        />
                        <label for="city"
                          ><i class="fa fa-institution"></i>Interest</label
                        >
                        <input
                          type="text"
                          id="city"
                          name="interest"
                          placeholder="Your interest.."
                        />

                        <div class="row">
                          <div class="col-50">
                            <label for="state">MBTI</label>
                            <input
                              type="text"
                              id="state"
                              name="mbti"
                              placeholder="Your MBTI.."
                            />
                          </div>

                          <div class="form-group">
                            <label for="exampleInputFile">File input</label>
                            <div class="input-group">
                              <div class="custom-file">
                                <input
                                  type="file"
                                  class="custom-file-input"
                                  id="exampleInputFile"
                                  name="photo"
                                />
                                <labelre
                                  class="custom-file-label"
                                  for="exampleInputFile"
                                  >Choose file</label
                                >
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

               
 				 <input type="button" value="Regist" id="bt_regist">
	       		 <input type="button" value="Update" id="bt_update">
	        	 
                </div>
              </form>
            </div>
          </div>
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


    <script>
    "use strct";

    var inputFile = document.querySelector("#exampleInputFile");
    var pictureList = document.getElementById("pictureList");

    pictureList.addEventListener("click", (e) => {
      const { target } = e;
      if (target.tagName !== "IMG") return;

      var expandImg = document.getElementById("expandedImg");
      var imgText = document.getElementById("imgtext");
      expandImg.src = target.src;
      imgText.innerHTML = target.alt;
      expandImg.parentElement.style.display = "block";
    });

    inputFile.addEventListener("change", (e) => {
      const [file] = e.target.files;
      const newImage = document.createElement("img");

      if (file) {
        newImage.src = URL.createObjectURL(file);
        pictureList.appendChild(newImage);
      }
    });
    
    $(function(){
  		CKEDITOR.replace("content");
  		
  		//????????? ????????? ???????????? 
  		$("#bt_regist").click(function(){
  			if(confirm("??????????????????????")){
  				regist();	
  			}
  		});
  		
  		//????????? ????????? ???????????? 
  		$("#bt_update").click(function(){
  			if(confirm("??????????????????????")){
  				update();	
  			}
  		});
  	});
    
    
    function regist(){
     	$("form").attr({
     		action:"/profile/regist",
    		method:"post",
    		enctype:"multipart/form-data"
     		});
     	$("form").submit();
    }
    
  	function del(){
  		$("form").attr({
  			"action":"/error/result",
  			"method":"post"
  		});	
  		$("form").submit();	
  	}
  	function edit(){
  		$("form").attr({
  			"action":"/profile/regist",
  			"method":"post"
  		});	
  		$("form").submit();
  	}

    

      
    </script>
  </body>
</html>
