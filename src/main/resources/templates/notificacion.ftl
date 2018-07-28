<#list list2 as notificacion>
    <li>
        <a href="/post/${notificacion.articulo.id}">
            <div class="media">
            <#--<img src="images/profile-6.jpg" alt="" class="circle responsive-img">-->
                <div class="media_body">
                    <p><b>${notificacion.origen.nombre} ${notificacion.origen.apellido}</b> te ha
                        <#if (notificacion.tipoNotificacion=="MENCION") >
                                mencionado en un
                            <small>post</small>
                            .
                        </#if>
                    </p>
                <#--<h6>5 Minute ago</h6>-->
                </div>
            </div>
        </a>
    </li>
</#list>


