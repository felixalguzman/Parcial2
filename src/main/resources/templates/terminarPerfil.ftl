<!DOCTYPE html>
<html lang="en">

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
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Calendar CSS-->
    <script src="../vendors/calendar/calendario.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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

<!-- Tranding-select and banner Area -->
<div class="banner_area banner_2">
<#--<img src="images/banner-2.jpg" alt="" class="banner_img">  -->
    <div class="media profile_picture">
    <#--<a href="profile.html"><img src="images/profile-hed-1.jpg" alt="" class="circle"></a> -->
        <div class="media_body">
            <a href="profile.html">Denzel Washington</a>
        <#--<h6>Dhaka, Bangladesh</h6>-->
        </div>
    </div>
</div>

<!-- End Tranding Area -->

<!-- Min Container area -->
<section class="min_container photo_pages">
    <div class="section_row row">
        <div class="col s12">
            <h2>Completar información del perfil</h2>
        </div>

        <form class="input_group" method="post" action="/terminar">


            <div class="input-field">
                <div class="calendar_widget">
                    <h4 class="categories_tittle">Fecha Nacimiento</h4>

                    <input type="date" placeholder="Fecha Nacimiento" name="fechaNacimiento">
                </div>


                <h4>Lugar de Nacimiento</h4>
                <input type="text" placeholder="Lugar Nacimiento" name="lugarNacimiento">


                <h4>Ciudad donde vive</h4>
                <input type="text" placeholder="Ciudad" name="ciudad">


                <h4>Trabajos</h4>
                <#--<input type="date" placeholder="Fecha Nacimiento" name="fechaNacimiento">-->

                <button class="waves-effect btn post_btn modal-tri">Guardar</button>
            </div>





        </form>

    </div>

</section>
<!-- End Min Container area -->

<!-- Footer area -->
<footer class="footer_area">
    <div class="footer_row row">

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
<div id="post_modal" class="add_post modal">
    <h2>Create A New Post</h2>
    <form class="input_group">
        <div class="input-field">
            <input type="text" class="validate" placeholder="Add a tittle">
            <textarea class="textarea" placeholder="Add some description"></textarea>
        </div>
        <div class="upload_photo row">
            <ul class="tabs tab_nav">
                <li class="tab col s6"><a href="#photo"><i class="ion-ios-camera"></i>Add Photo</a></li>
                <li class="tab col s6"><a class="" href="#video"><i class="ion-ios-videocam"></i>Add video</a></li>
            </ul>
            <div id="photo" class="col s12 tabs_content">
                <div class="photo_u">
                    <img src="images/upload.png" alt="">
                    <h4>Select files to upload
                        <small>or drag &amp; drop files</small>
                    </h4>
                </div>
            </div>
            <div id="video" class="col s12 tabs_content">
                <div class="photo_u">
                    <img src="images/upload.png" alt="">
                    <h4>Select files to upload
                        <small>or drag &amp; drop files</small>
                    </h4>
                </div>
            </div>
        </div>
        <div class="input-field col s12 select_option">
            <select>
                <option value="" disabled selected>Choose a category</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="2">Option 2</option>
                <option value="2">Option 2</option>
            </select>

            <div class="chips chips-placeholder" data-index="0" data-initialized="true">
                <input class="input" placeholder="Enter a tag">
            </div>
        </div>
        <div class="input-field add_link">
            <input type="text" class="validate" placeholder="Add a link">
            <span>optional</span>
        </div>
        <div class="yes_no">
            <h4>Anyone can submit?</h4>
            <div class="flipswitch"></div>
        </div>
        <div class="row submit_btn_area">
            <div class="col s6">
                <button class="waves-effect"><i class="ion-folder"></i>Save draft</button>
            </div>
            <div class="col s6">
                <button class="waves-effect col s6"><i class="ion-eye"></i>Preview post</button>
            </div>
            <div class="col s12">
                <button class="waves-effect publish">Publish</button>
            </div>
        </div>
    </form>
</div>
<!-- End Add post poup area -->

<!-- jQuery JS -->
<script src="js/jquery-3.3.1.min.js"></script>
<!-- Materialize JS -->
<script src="js/materialize.min.js"></script>
<!-- Calendar JS -->
<script src="vendors/calendar/dcalendar.picker.js"></script>
<!-- Load JS -->
<script src="vendors/infinite-scroll/jquery.jscroll.js"></script>
<!-- Check Button js -->
<script src="vendors/check-button/jquery.jqflipswitch.min.js"></script>
<script src="vendors/check-button/jquery.jqflipswitch.js"></script>
<!-- Theme JS -->
<script src="js/theme.js"></script>
</body>

<!-- Mirrored from uxart.io/downloads/openlist-html/all-template/photos.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 21 Jul 2018 03:35:46 GMT -->
</html>