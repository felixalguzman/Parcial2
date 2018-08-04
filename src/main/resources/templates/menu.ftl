<nav class="header_area header_2">
    <div class="nav-wrapper">
        <a href="/inicio" class="brand-logo"><img src="../../images/logo.png" alt=""></a>
        <ul class="left_menu hide-on-med-and-down">
            <li><a href="/inicio" class="active">Inicio</a></li>
               <#if (usuario??)>
                  <li><a href="/perfil/${usuario.id}" class="">Perfil</a></li>
               </#if>
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
                        <ul id="dropdownFollow" class="dropdown-content">
                            <li class="hed_notic"> Followers</li>
                            <#include "amigo.ftl">
                            <li><a href="#" class="waves-effect chack_all_btn">Check All
                                Notifications</a></li>
                        </ul>

                        <!-- Notifications -->
                    <li class="notifications"><a class="dropdown-button" href="#!" data-activates="dropdown2"><i
                            class="ion-ios-bell-outline"></i><b class="n-number">${list2?size}</b></a>
                        <ul id="dropdown2" class="dropdown-content">
                            <li class="hed_notic">Notificaciones <span>Mark all as read <i
                                    class="ion-ios-gear-outline"></i></span></li>

                        <#include "notificacion.ftl">

                            <li><a href="#" class="waves-effect chack_all_btn">Check All
                                Notifications</a></li>
                        </ul>
                        <!-- Profile -->
                    <li class="user_dropdown">
                        <a class="dropdown-button" href="#!" data-activates="dropdown1">

                            <#if usuario.fotoPerfil??>
                                <img src="../../${usuario.fotoPerfil}" height="54" width="54" alt="" class="circle p_2">
                            </#if>

                        </a>
                        <!-- Dropdown Structure -->
                        <ul id="dropdown_s4" class="dropdown-content">
                            <li><a href="/perfil/${usuario.id}"><i class="ion-person"></i>Mi perfil</a></li>
                            <li class="b_t"><a href="#"><i class="ion-android-notifications"></i>Notification
                                settings</a></li>
                            <li class="b_b"><a href="/addAmigos/"><i class="ion-ios-person"></i>Agregar Amigos</a></li>
                            <#if usuario.admin >
                             <li class="b_b"><a href="/usuarios/"><i class="ion-ios-person"></i>Usuarios</a></li>
                            </#if>

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


    </div>
</nav>