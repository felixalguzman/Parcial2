<nav class="header_area header_2">
    <div class="nav-wrapper">
        <a href="/inicio" class="brand-logo"><img src="../images/logo.png" alt=""></a>
        <ul class="left_menu hide-on-med-and-down">
            <!-- <li><a href="#">About membership</a></li>  -->
        </ul>

    <ul class="right right_menu hide-on-med-and-down">
        <!-- <li class="search_min">
           <div class="search_from">
                <input placeholder="Search Here" type="text">
                <a href="#" class="search_icon"><i class="ion-ios-search"></i></a>
           </div>
        </li> -->
                  
                <#if (usuario??)>
                       <li><a href="#post_modal" class="waves-effect btn post_btn modal-trigger"><i
                               class="ion-plus"></i><span>Add Post</span></a></li>
                    <!-- Follow feed -->
                    <li class="notifications follow"><a class="dropdown-button" href="#!" data-activates="dropdown4"><i
                            class="ion-ios-person-outline"></i><b class="n-number">7</b></a>
                        <!-- Messages -->
                    <li class="notifications messages"><a class="dropdown-button" href="#!"
                                                          data-activates="dropdown3"><i
                            class="ion-ios-chatboxes-outline"></i><b class="n-number">3</b></a>
                        <!-- Notifications -->
                    <li class="notifications"><a class="dropdown-button" href="#!" data-activates="dropdown2"><i
                            class="ion-ios-bell-outline"></i><b class="n-number">5</b></a>
                    <ul id="dropdown2" class="dropdown-content">
                        <li class="hed_notic">Notifications <span>Mark all as read <i class="ion-ios-gear-outline"></i></span></li>
                        <li>
                            <a href="#">
                                <div class="media">
                                    <img src="images/profile-6.jpg" alt="" class="circle responsive-img">
                                    <div class="media_body">
                                        <p><b>Dan Fisher</b> submitted a new photo  to a <small>post</small> post you are following.</p>
                                        <h6>5 Minute ago</h6>
                                    </div>
                                </div>
                            </a>
                        </li>




                        <li><a href="notifications.html" class="waves-effect chack_all_btn">Check All Notifications</a></li>
                    </ul>
                        <!-- Profile -->
                    <li class="user_dropdown"><a class="dropdown-button" href="#!" data-activates="dropdown1"><img
                            src="images/profile-pic.png" alt="" class="circle p_2"></a>
                        <!-- Dropdown Structure -->
                        <ul id="dropdown_s4" class="dropdown-content">
                            <li><a href="profile.html"><i class="ion-person"></i>My profile</a></li>
                            <li><a href="read-later.html"><i class="ion-android-folder-open"></i>Saved Articles</a></li>
                            <li class="b_t"><a href="#"><i class="ion-android-notifications"></i>Notification
                                settings</a></li>
                            <li class="b_b"><a href="#"><i class="ion-ios-locked"></i>Change Password</a></li>
                            <li><a href="#"><i class="ion-gear-b"></i>Settings</a></li>
                            <#--<li><a href="#"><i class="ion-ios-flag"></i>Privacy Policy</a></li>-->
                            <#--<li><a href="#"><i class="ion-podium"></i>FAQ</a></li>-->
                            <li><a href="/logOut"><i class="ion-power"></i>Salir</a></li>
                        </ul>
                    </li>
                </ul>
                <#else>
                        <li><a href="#modal1" class="waves-effect btn post_btn modal-trigger">Iniciar</a></li>

                </#if>
        </ul>

    </div>
</nav>