<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from uxart.io/downloads/openlist-html/all-template/block-list.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 21 Jul 2018 03:35:23 GMT -->
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
    <!-- Check-button CSS-->
    <link rel="stylesheet" href="../vendors/calendar/dcalendar.picker.css">
    <!-- Calendar CSS-->
    <link rel="stylesheet" href="../vendors/check-button/jqflipswitch.default.style.css">
    <script src="../js/jquery-3.3.1.min.js"></script>
    <!--Theme Styles CSS-->
    <link rel="stylesheet" href="../css/style.css" media="all"/>

    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="../js/html5shiv.min.js"></script>
    <script src="../js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- Header_Area -->
     <#include "menu.ftl">
<!-- End  Header_Area -->

<!-- Notifications area -->
<section class="notifications_area">
    <div class="notifications">

        <script>

            $(document).ready(function () {
                $.ajax({
                    url: '/addAmigos/1', success: function (data) {
                        $('.jscroll-inner').html(data);
                    }
                });
            });


        </script>

        <!-- Dropdown Structure -->
        <div class="hed_notic">Usuarios <span><i class="ion-ios-gear-outline"></i></span></div>
        <ul class="notifications_content follow">

            <div class="jscroll-inner">

            </div>


        </ul>
    </div>
</section>


<!-- End Notifications area -->


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

</html>