<#list list2 as notificacion>
    <li>
        <#if (notificacion.tipoNotificacion=="MENCION") >

            <a href="/post/${notificacion.articulo.id}">
                <div class="media">
                        <#if (notificacion.origen.fotoPerfil)??>

                        <img src="../${notificacion.origen.fotoPerfil}" alt="" width="46" height="46"
                             class="circle responsive-img">
                        </#if>
                    <div class="media_body">
                        <p><b>${notificacion.origen.nombre} ${notificacion.origen.apellido}</b> te ha
                            mencionado en un
                            <small>post</small>
                            .
                        </p>
                    <#--<h6>5 Minute ago</h6>-->
                    </div>
                </div>
            </a>

        <#else >
            <a href="/post/${notificacion.articulo.id}#comentario">
                <div class="media">
                    <#if (notificacion.origen.fotoPerfil)??>

                        <img src="../${notificacion.origen.fotoPerfil}" alt="" width="46" height="46"
                             class="circle responsive-img">
                    </#if>
                    <div class="media_body">
                        <p><b>${notificacion.origen.nombre} ${notificacion.origen.apellido}</b> te ha
                            comentado en un
                            <small>post</small>
                            .
                        </p>
                    <#--<h6>5 Minute ago</h6>-->
                    </div>
                </div>
            </a>
        </#if>

    </li>
</#list>


