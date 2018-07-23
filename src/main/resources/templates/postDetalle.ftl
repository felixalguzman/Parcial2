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

    <!--Theme Styles CSS-->
    <link rel="stylesheet" href="../css/style.css" media="all"/>

    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
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
            <div class="jscroll-inner">
                <!-- Post -->

                <div class="post post_details">
                    <div class="post_content">
                        <a href="#" class="post_img">
                        <#--<img src="images/post-7.jpg" alt="">-->
                        </a>
                    <#if (articulo.titulo??)>
                    <div class="post_heding_aea">
                        <a class="post_heding">${articulo.titulo}</a>

                    </div>
                    </#if>
                        <div class="post_heding_aea">
                        <#--<a href="#" class="post_heding">Why Is It I Can Never Think Of Anything Good To Make For Supper</a>-->
                            <h4 class="by_author"><img src="images/author-s-1.jpg" alt="" class="circle">
                                <a href="#">${articulo.usuario.nombre}  ${articulo.usuario.apellido} </a> ${tiempoPublicado}
                            </h4>
                        </div>
                        <div class="socail_share_area row">

                            <p>${articulo.cuerpo}</p>
                        </div>


                        <div class="next_btn_col next_btn_2">
                        <#--<a href="#" class="next_btn waves-effect">Next Page (10/22)</a>-->
                        </div>

                    </div>
                </div>

                <!-- End Post -->
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
                        <li><a href="#"><i class="ion-android-radio-button-off"></i>Arts</a></li>
                        <li><a href="#"><i class="ion-android-radio-button-off"></i>Beauty</a></li>
                        <li><a href="#"><i class="ion-android-radio-button-off"></i>Entertainment</a></li>
                        <li><a href="#"><i class="ion-android-radio-button-off"></i>Travel</a></li>
                        <li><a href="#"><i class="ion-android-radio-button-off"></i>Personal</a></li>
                        <li><a href="#"><i class="ion-android-radio-button-off"></i>Politics</a></li>
                        <li><a href="#"><i class="ion-android-radio-button-off"></i>Space Science</a></li>
                    </ul>
                </div>
                <div class="profile">
                    <h3 class="categories_tittle">Profile <span>Edit</span></h3>
                    <ul class="profile_pic">
                        <li><a href="#"><img src="images/profile-1.jpg" alt="" class="circle"></a></li>
                        <li><a href="#"><img src="images/profile-2.jpg" alt="" class="circle"></a></li>
                        <li><a href="#"><img src="images/profile-3.jpg" alt="" class="circle"></a></li>
                        <li><a href="#"><img src="images/profile-4.jpg" alt="" class="circle"></a></li>
                        <li><a href="#"><img src="images/profile-5.jpg" alt="" class="circle"></a></li>
                        <li><a href="#"><img src="images/profile-6.jpg" alt="" class="circle"></a></li>
                        <li><a href="#"><img src="images/profile-7.jpg" alt="" class="circle"></a></li>
                        <li><a href="#"><img src="images/profile-8.jpg" alt="" class="circle"></a></li>
                        <li><a href="#"><img src="images/profile-9.jpg" alt="" class="circle"></a></li>
                        <li><a href="#"><img src="images/profile-10.jpg" alt="" class="circle"></a></li>
                    </ul>
                </div>
                <div class="badges">
                    <h3 class="categories_tittle">Badges</h3>
                    <ul class="badges_list">
                        <li><a href="#"><i class="ion-bonfire"></i><span>6</span></a></li>
                        <li><a href="#"><i class="ion-bluetooth"></i></a></li>
                        <li><a href="#"><i class="ion-coffee"></i></a></li>
                        <li><a href="#"><i class="ion-clock"></i> <span>3</span></a></li>
                        <li><a href="#"><i class="ion-camera"></i></a></li>
                        <li><a href="#"><i class="ion-ios-bell-outline"></i><span>2</span></a></li>
                        <li><a href="#"><i class="ion-bluetooth"></i></a></li>
                        <li><a href="#"><i class="ion-coffee"></i></a></li>
                        <li><a href="#"><i class="ion-clock"></i></a></li>
                    </ul>
                </div>
                <div class="calendar_widget">
                    <h3 class="categories_tittle">Calendar</h3>
                    <table class="calendar"></table>
                </div>
                <div class="social_Sharing">
                    <h3 class="categories_tittle">Social Sharing</h3>
                    <ul class="social_icon">
                        <li><a href="#"><i class="ion-social-twitter"></i></a></li>
                        <li><a href="#" class="tumblr"><i class="ion-social-tumblr"></i></a></li>
                        <li><a href="#" class="googleplus"><i class="ion-social-googleplus"></i></a></li>
                        <li><a href="#" class="pinterest"><i class="ion-social-pinterest"></i></a></li>
                        <li><a href="#" class="facebook"><i class="ion-social-facebook"></i></a></li>
                    </ul>
                </div>
                <div class="advertis">
                    <a href="#"><img src="images/advertis.jpg" alt=""></a>
                </div>
            </div>
        </div>
        <!-- Right side bar -->

    </div>
</section>
<!-- End Min Container area -->

<!-- Footer area -->
<footer class="footer_area">
    <div class="footer_row row">
        <div class="col l3 m6 footer_col">
            <div class="popular_posts">
                <h3 class="categories_tittle">Popular Posts</h3>
                <div class="row valign-wrapper popular_item">
                    <div class="col s3 p_img">
                        <a href="#">
                            <img src="images/recent-post-1.jpg" alt="" class="circle responsive-img">
                        </a>
                    </div>
                    <div class="col s9 p_content">
                        <a href="#">Poster can be one of the <br> effective marketing and </a>
                        <span class="black_text">2 days ago</span>
                    </div>
                </div>
                <div class="row valign-wrapper popular_item">
                    <div class="col s3 p_img">
                        <a href="#">
                            <img src="images/recent-post-2.jpg" alt="" class="circle responsive-img">
                        </a>
                    </div>
                    <div class="col s9 p_content">
                        <a href="#">Color is so powerful that it can persuade, motivate, inspire</a>
                        <span class="black_text">3 days ago</span>
                    </div>
                </div>
                <div class="row valign-wrapper popular_item">
                    <div class="col s3 p_img">
                        <a href="#">
                            <img src="images/recent-post-3.jpg" alt="" class="circle responsive-img">
                        </a>
                    </div>
                    <div class="col s9 p_content">
                        <a href="#">What makes one logo better than another?</a>
                        <span class="black_text">4 days ago</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col l3 m6 footer_col footer_trending">
            <h3 class="categories_tittle">Trending</h3>
            <div class="trending_area">
                <ul class="collapsible trending_collaps" data-collapsible="accordion">
                    <li>
                        <div class="collapsible-header"><i class="ion-chevron-right"></i>Healthy Environment For Self
                            Esteem
                        </div>
                        <div class="collapsible-body">
                            <div class="row collaps_wrpper">
                                <div class="col s1 media_l">
                                    <b>1</b>
                                    <i class="ion-android-arrow-dropup-circle"></i>
                                </div>
                                <div class="col s11 media_b">
                                    <a href="#" class="close_btn"><i class="ion-close-round"></i></a>
                                    <p>If you will be traveling for a ski vacation, it is often difficult to know what
                                        to pack. You may not even have a problem</p>
                                    <h6>By <a href="#">Thomas Omalley</a></h6>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="collapsible-header"><i class="ion-chevron-right"></i>Burn The Ships</div>
                        <div class="collapsible-body">
                            <div class="row collaps_wrpper">
                                <div class="col s1 media_l">
                                    <b>1</b>
                                    <i class="ion-android-arrow-dropup-circle"></i>
                                </div>
                                <div class="col s11 media_b">
                                    <a href="#" class="close_btn"><i class="ion-close-round"></i></a>
                                    <p>If you will be traveling for a ski vacation, it is often difficult to know what
                                        to pack. You may not even have a problem</p>
                                    <h6>By <a href="#">Thomas Omalley</a></h6>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="collapsible-header active"><i class="ion-chevron-right"></i>Harness The Power Of
                            Your Dreams
                        </div>
                        <div class="collapsible-body">
                            <div class="row collaps_wrpper">
                                <div class="col s1 media_l">
                                    <b>1</b>
                                    <i class="ion-android-arrow-dropup-circle"></i>
                                </div>
                                <div class="col s11 media_b">
                                    <a href="#" class="close_btn"><i class="ion-close-round"></i></a>
                                    <p>If you will be traveling for a ski vacation, it is often difficult to know what
                                        to pack. You may not even have a problem</p>
                                    <h6>By <a href="#">Thomas Omalley</a></h6>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col l3 m6 footer_col">
            <div class="badges">
                <h3 class="categories_tittle">Badges</h3>
                <ul class="badges_list">
                    <li><a href="#"><i class="ion-bonfire"></i><span>6</span></a></li>
                    <li><a href="#"><i class="ion-bluetooth"></i></a></li>
                    <li><a href="#"><i class="ion-coffee"></i></a></li>
                    <li><a href="#"><i class="ion-clock"></i> <span>3</span></a></li>
                    <li><a href="#"><i class="ion-camera"></i></a></li>
                    <li><a href="#"><i class="ion-ios-bell-outline"></i><span>2</span></a></li>
                    <li><a href="#"><i class="ion-bluetooth"></i></a></li>
                    <li><a href="#"><i class="ion-coffee"></i></a></li>
                    <li><a href="#"><i class="ion-clock"></i></a></li>
                </ul>
            </div>

            <div class="social_Sharing">
                <h3 class="categories_tittle">Social Sharing</h3>
                <ul class="social_icon">
                    <li><a href="#"><i class="ion-social-twitter"></i></a></li>
                    <li><a href="#" class="tumblr"><i class="ion-social-tumblr"></i></a></li>
                    <li><a href="#" class="googleplus"><i class="ion-social-googleplus"></i></a></li>
                    <li><a href="#" class="pinterest"><i class="ion-social-pinterest"></i></a></li>
                    <li><a href="#" class="facebook"><i class="ion-social-facebook"></i></a></li>
                </ul>
            </div>
        </div>
        <div class="col l3 m6 footer_col">
            <img src="images/advertis-3.jpg" alt="" class="responsive-img">
        </div>
    </div>
    <div class="copy_right">
        © 2018 <a href="#">Open List</a>. All rights reserved.
    </div>
</footer>
<!-- End Footer area -->

<!-- Add post poup area -->
       <#include "agregarPost.ftl">

<!-- End Add post poup area -->

<!-- jQuery JS -->
<script src="../js/jquery-3.3.1.min.js"></script>
<!-- Materialize JS -->
<script src="../js/materialize.min.js"></script>
<!-- Calendar JS -->
<script src="../vendors/calendar/dcalendar.picker.js"></script>
<!-- Load JS -->
<script src="../vendors/infinite-scroll/jquery.jscroll.js"></script>
<!-- Check Button js -->
<script src="../vendors/check-button/jquery.jqflipswitch.min.js"></script>
<script src="../vendors/check-button/jquery.jqflipswitch.js"></script>
<!-- Theme JS -->
<script src="../js/theme.js"></script>
</body>

<!-- Mirrored from uxart.io/downloads/openlist-html/all-template/details.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 21 Jul 2018 03:35:10 GMT -->
</html>