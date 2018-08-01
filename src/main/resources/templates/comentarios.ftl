<script type="text/javascript" src="http://ichord.github.io/Caret.js/src/jquery.caret.js"></script>
<script type="text/javascript" src="../dist/js/jquery.atwho.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/at.js/1.4.0/css/jquery.atwho.min.css">
<script type="text/javascript" src="../js/autoComplete.js"></script>

<div class="like_comment_area row">

    <div class="col s12 updown_btn comment_c">
        <a href="#"><i class="ion-ios-chatboxes-outline"></i></a>
        <a href="#" name="comentario" class="count_n count_n_2">${articulo.comentarioSet?size} comentarios</a>
    </div>
    <div class="col s12 comment_input_box">
        <div class="input-field comment_input">
            <form method="post" action="/agregarComentario">

                <input placeholder="Agregar un comentario" name="comentario" id="inputor" required class="validate inputor" type="text">
                <input type="hidden" name="articulo" value="${articulo.id}">
                <input type="hidden" name="autor" value="${articulo.usuario.id}">

                <button type="submit" class="btn-large">Post</button>
            </form>


            <br>
            <br>
        </div>
    </div>
    <div class="col p0 s12">
        <#if articulo.comentarioSet?? >

            <#list articulo.comentarioSet as comentario>

        <div class="media">
                <#if (comentario.autor.fotoPerfil)??>
                    <img src="../${comentario.autor.fotoPerfil}" alt="" height="60" width="51"
                         class="circle responsive-img">
                </#if>
            <div class="media_body">
                <h4><a href="/perfil/${comentario.autor.id}">${comentario.autor.nombre} ${comentario.autor.apellido}</a>
                </h4>
                <p>${comentario.comentario}</p>
            <#--<span><a href=""><i class="ion-ios-arrow-thin-up"></i></a>483<a href="#"><i-->
            <#--class="ion-ios-arrow-thin-down"></i></a></span>-->

            <#--<a href="#" class="view_mor_r">View more replies...</a>-->
            </div>
        </div>
            <#--<a href="#" class="load_more">Load more comments</a>-->

            </#list>

        </#if>

    </div>
</div>