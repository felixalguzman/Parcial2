<script src="../js/ajaxUsuarios.js"></script>
    <script src="../js/jquery-3.3.1.min.js"></script>

<script>

    function cambiarUsuario() {


        document.getElementById('cambio').style.visibility = 'hidden';
    }


</script>

<#list list as usuario>
    <li class="block_list">
        <a>
            <div class="media">
                  <#if usuario.fotoPerfil??>
                                <img src="../${usuario.fotoPerfil}" alt=""
                                     class="circle responsive-img">
                  </#if>

                <div class="media_body">
                    <p><a href="/perfil/${usuario.id}"><b>${usuario.nombre} ${usuario.apellido}</b></a></p>
                    <form method="post" name="form" action="/agregar/${usuario.id}">
                        <input type="text" id="id" name="id" value="${usuario.id}" hidden>
                               <div class="btn_group">
                                   <button type="submit" id="cambio" class="waves-effect btn post">Enviar Solicitud de Amistad</button>
                               </div>
                    </form>

                </div>
            </div>
        </a>
    </li>
</#list>

   <!-- Pagination -->
<div class="pagination_area">
    <ul class="pagination" style="text-align: center">
                    <#if actual gt 1>
                        <li class="page-item">
                            <a id="atras" data-ruta="/addAmigos/${actual - 1}" class="waves-effect">&larr;</a>
                        </li>

                    <#else>
                      <li class="page-item disabled">
                          <a class="disabled"> &larr;</a>
                      </li>

                    </#if>

                    <#if paginas gt actual>
                       <li class="page-item">
                           <a id="adelante" data-ruta="/addAmigos/${actual + 1}" class="waves-effect">&rarr;</a>
                       </li>
                    <#else>

                    <li class="page-item disabled">
                        <a class="disabled"> &rarr;</a>
                    </li>

                    </#if>

    </ul>
</div>
