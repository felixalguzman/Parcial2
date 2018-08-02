<#list list3 as amigo>
    <li>

        <div class="media">
                    <#if (amigo.usuario1.fotoPerfil)??>
                        <a href="/perfil/${amigo.usuario1.id}">
                            <img src="../${amigo.usuario1.fotoPerfil}" alt="" width="46" height="46"
                                 class="circle responsive-img">
                        </a>
                    </#if>
            <div class="media_body">
                <p><b><a href="/perfil/${amigo.usuario1.id}">${amigo.usuario1.nombre} ${amigo.usuario1.apellido}</a></b> te ha seguido
                    .
                </p>
            <#--<h6>5 Minute ago</h6>-->
            </div>
        </div>


    </li>
</#list>


