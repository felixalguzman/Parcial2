<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from uxart.io/downloads/openlist-html/all-template/details.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 21 Jul 2018 03:34:39 GMT -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <title>Open List | Html template</title>


    <!-- Favicon -->
    <link rel="icon" href="../images/favicon.png" type="image/x-icon"/>
    <!-- Materialize CSS -->
    <link rel="stylesheet" href="../css/materialize.min.css">
    <!-- Tooltip CSS -->
    <link rel="stylesheet" href="../vendors/tooltip/balloon.min.css">
    <!-- Icon CSS-->
    <link rel="stylesheet" href="../vendors/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../vendors/font-awesome/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Calendar CSS-->
    <link rel="stylesheet" href="../vendors/calendar/dcalendar.picker.css">
<#--<script src="../js/cargarArchivo.js"></script>-->
<#--<script src="../js/ajax.js"></script>-->
    <!-- jQuery JS -->
    <script src="../js/jquery-3.3.1.min.js"></script>
    <!-- Check Button js -->
    <script src="../vendors/check-button/jquery.jqflipswitch.min.js"></script>
    <script src="../vendors/check-button/jquery.jqflipswitch.js"></script>


    <!--Theme Styles CSS-->
    <link rel="stylesheet" href="../css/style.css" media="all"/>

    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.3.5/jquery.fancybox.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.3.5/jquery.fancybox.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- Header_Area -->
    <#include "menu.ftl">
<!-- End  Header_Area -->

<!-- Min Container area -->
<section class="min_container min_container_2">
    <div class="section_row">
        <div class="middle_section col">


        <#--Comentarios-->
            <div class="post post_details">
            <#--<#include "comentarios.ftl">-->
            </div>
        </div>

        <!-- left side bar -->
        <div class="col">
            <div class="left_side_bar">
                <div class="categories">
                    <h3 class="categories_tittle">Post Categories</h3>
                    <ul class="categories_icon">
                        <li><a class="tooltip" data-balloon="Rate Post" data-balloon-pos="up"><i
                                class="ion-ios-star"></i></a></li>
                        <li><a href="#" class="tooltip" data-balloon="Time Post" data-balloon-pos="up"><i
                                class="ion-android-time"></i></a></li>
                        <li><a href="#" class="tooltip" data-balloon="Music Post" data-balloon-pos="up"><img
                                src="images/icons/sound.png" alt=""></a></li>
                        <li><a href="#" class="tooltip" data-balloon="Images Post" data-balloon-pos="up"><i
                                class="ion-android-image"></i></a></li>
                        <li><a href="#" class="tooltip" data-balloon="chart Post" data-balloon-pos="up"><i
                                class="large material-icons">insert_chart</i></a></li>
                    </ul>
                </div>
                <div class="interests">
                    <h3 class="categories_tittle">Your Interests <span>Edit</span></h3>
                    <ul class="interests_list">
                    <#--<li><a href="#"><i class="ion-android-radio-button-off"></i>Arts</a></li>-->
                    <#--<li><a href="#"><i class="ion-android-radio-button-off"></i>Beauty</a></li>-->
                    <#--<li><a href="#"><i class="ion-android-radio-button-off"></i>Entertainment</a></li>-->
                    <#--<li><a href="#"><i class="ion-android-radio-button-off"></i>Travel</a></li>-->
                    <#--<li><a href="#"><i class="ion-android-radio-button-off"></i>Personal</a></li>-->
                    <#--<li><a href="#"><i class="ion-android-radio-button-off"></i>Politics</a></li>-->
                    <#--<li><a href="#"><i class="ion-android-radio-button-off"></i>Space Science</a></li>-->
                    </ul>
                </div>
                <div class="profile">
                    <h3 class="categories_tittle">Profile <span>Edit</span></h3>
                    <ul class="profile_pic">
                    <#--<li><a href="#"><img src="images/profile-1.jpg" alt="" class="circle"></a></li>-->
                    <#--<li><a href="#"><img src="images/profile-2.jpg" alt="" class="circle"></a></li> -->
                    <#--<li><a href="#"><img src="images/profile-3.jpg" alt="" class="circle"></a></li> -->
                    <#--<li><a href="#"><img src="images/profile-4.jpg" alt="" class="circle"></a></li> -->
                    <#--<li><a href="#"><img src="images/profile-5.jpg" alt="" class="circle"></a></li> -->
                    <#--<li><a href="#"><img src="images/profile-6.jpg" alt="" class="circle"></a></li> -->
                    <#--<li><a href="#"><img src="images/profile-7.jpg" alt="" class="circle"></a></li> -->
                    <#--<li><a href="#"><img src="images/profile-8.jpg" alt="" class="circle"></a></li> -->
                    <#--<li><a href="#"><img src="images/profile-9.jpg" alt="" class="circle"></a></li> -->
                    <#--<li><a href="#"><img src="images/profile-10.jpg" alt="" class="circle"></a></li> -->
                    </ul>
                </div>
                <div class="badges">
                    <h3 class="categories_tittle">Badges</h3>
                    <ul class="badges_list">
                    <#--<li><a href="#"><i class="ion-bonfire"></i><span>6</span></a></li>-->
                    <#--<li><a href="#"><i class="ion-bluetooth"></i></a></li>-->
                    <#--<li><a href="#"><i class="ion-coffee"></i></a></li>-->
                    <#--<li><a href="#"><i class="ion-clock"></i> <span>3</span></a></li>-->
                    <#--<li><a href="#"><i class="ion-camera"></i></a></li>-->
                    <#--<li><a href="#"><i class="ion-ios-bell-outline"></i><span>2</span></a></li>-->
                    <#--<li><a href="#"><i class="ion-bluetooth"></i></a></li>-->
                    <#--<li><a href="#"><i class="ion-coffee"></i></a></li>-->
                    <#--<li><a href="#"><i class="ion-clock"></i></a></li>-->
                    </ul>
                </div>


                <div class="advertis">
                    <a href="#"><img src="images/advertis.jpg" alt=""></a>
                </div>
            </div>
        </div>
        <!-- Right side bar -->
        <div class="right_side_bar col">
            <div class="right_sidebar_iner">
                <div class="calendar_widget">
                    <h3 class="categories_tittle">Calendar</h3>
                    <table class="calendar"></table>
                </div>

            </div>
        </div>
    </div>
</section>
<!-- End Min Container area -->

<!-- Footer area -->
<footer class="footer_area">
    <div class="copy_right">
        © 2018 <a href="#">Open List</a>. All rights reserved.
    </div>
</footer>
<!-- End Footer area -->

<!-- Add post poup area -->

       <#include "agregarPost.ftl">

<!-- End Add post poup area -->

<!-- Popup area -->
<div id="modal2" class="login_popup_aera modal">
    <div class="login_popup_row">
        <img src="images/login-logo.png" alt="">
        <h4>Crea una nueva cuenta or <a href="#modal1" class="modal-trigger modal-close">Sign in</a></h4>
        <form class="input_group" method="POST" action="/registrar">
            <div class="input-field">
                <input type="text" class="validate" name="nombre" placeholder="Nombre" required>
                <input type="text" class="validate" name="apellido" placeholder="Apellido" required>
                <input type="text" class="validate" name="username" placeholder="Username" required>
                <input type="email" class="validate" name="email" placeholder="Email" required>
                <input type="password" class="validate" name="password" placeholder="Password" required>
            </div>
            <p>
                <input type="checkbox" id="test" required/>
                <label for="test">I accept the <a href="#">Terms and Services</a></label>
            </p>
            <button class="waves-effect">Register</button>
        </form>
        <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat"><i class="ion-close-round"></i></a>
    </div>
</div>
<!-- Log In Popup -->
<div id="modal1" class="login_popup_aera modal">
    <div class="login_popup_row">
        <img src="images/login-logo.png" alt="">
        <h4>Inicia sesion o <a href="#modal2" class="modal-trigger modal-close">crea una cuenta</a></h4>

        <h6>Inicia sesion con tu usuario</h6>
        <form class="input_group" method="GET" action="/iniciarSesion">
            <div class="input-field">
                <input type="text" class="validate" name="username" placeholder="Username">
                <input type="password" class="validate" name="password" placeholder="Password">
            </div>
            <p>
                <input type="checkbox" id="test2" name="recordar"/>
                <label for="test2">Remember me <a href="#">Forget password?</a></label>
            </p>
            <button class="waves-effect">SIgn in</button>
        </form>
        <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat"><i class="ion-close-round"></i></a>
    </div>
</div>
<!-- End Popup area -->

<!-- Materialize JS -->
<script src="../js/materialize.min.js"></script>
<!-- Calendar JS -->
<script src="../vendors/calendar/dcalendar.picker.js"></script>
<!-- Load JS -->
<script src="../vendors/infinite-scroll/jquery.jscroll.js"></script>
<!-- Theme JS -->
<script src="../js/theme.js"></script>
</body>

<!-- Mirrored from uxart.io/downloads/openlist-html/all-template/details.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 21 Jul 2018 03:35:10 GMT -->
</html>