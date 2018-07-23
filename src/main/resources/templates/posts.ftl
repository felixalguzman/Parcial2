<script src="../js/ajax.js"></script>
    <script src="../js/jquery-3.3.1.min.js"></script>



<#list list as articulo>

            <div class="post">
                <div class="post_content">
                <#--<a href="#" class="post_img">-->
                <#--&lt;#&ndash;<img src="images/post-7.jpg" alt="">&ndash;&gt;-->
                <#--</a>-->
                    <div class="row author_area">

                        <div class="col s4 author">

                        <#--<div class="col s4 media_left">-->
                        <#--&lt;#&ndash;foto&ndash;&gt;-->
                        <#--</div>-->

                            <div class="col s8 media_body">
                                <a href="/perfil/${articulo.usuario.id}">${articulo.usuario.nombre} ${articulo.usuario.apellido}</a>
                            <#--<span>${tiempoPublicado}</span>-->
                            </div>
                        </div>
                    </div>

                    <#if (articulo.titulo??)>
                        <a href="/post/${articulo.id}" class="post_heding">${articulo.titulo}</a>
                    </#if>

                    <p>${articulo.cuerpo}</p>


                </div>

                <div class="like_comment_area row">
                    <div class="col s4 btn_floating">
                    <#--<a class="btn-floating waves-effect"><i class="ion-android-share-alt"></i></a>-->
                    <#--<h6>128k</h6>-->
                    </div>
                    <div class="col s4 updown_btn">
                    <#--<a href="#"><i class="ion-android-arrow-dropdown-circle"></i></a>-->
                    <#--<a href="#"><i class="ion-android-arrow-dropup-circle"></i></a>-->
                        <a href="#" class="count_n" style="text-align: center">483</a>
                    </div>
                    <div class="col s4 updown_btn comment_c">
                        <a href="#"><i class="ion-ios-chatboxes-outline"></i></a>
                        <a href="#" class="count_n">14</a>
                    </div>
                </div>

                <div class="like_comment_area">
                    <a href="/post/${articulo.id}" class="submit_open_list modal-trigger">Leer más</a>
                </div>


                <br>


            </div>


</#list>

    <!-- Pagination -->
<div class="pagination_area">
    <ul class="pagination" style="text-align: center">
                    <#if actual gt 1>
                        <li class="page-item">
                            <a id="atras" data-ruta="/inicio/${actual - 1}" class="waves-effect">&larr;</a>
                        </li>

                    <#else>
                      <li class="page-item disabled">
                          <a class="disabled"> &larr;</a>
                      </li>

                    </#if>

                    <#if paginas gt actual>
                       <li class="page-item">
                           <a id="adelante" data-ruta="/inicio/${actual + 1}" class="waves-effect">&rarr;</a>
                       </li>
                    <#else>

                    <li class="page-item disabled">
                        <a class="disabled"> &rarr;</a>
                    </li>

                    </#if>

    </ul>
</div>