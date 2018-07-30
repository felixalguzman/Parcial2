<div class="like_comment_area row">

    <div class="col s12 updown_btn comment_c">
        <a href="#"><i class="ion-ios-chatboxes-outline"></i></a>
        <a href="#" class="count_n count_n_2">${list?size} comentarios</a>
    </div>
    <div class="col s12 comment_input_box">
        <div class="input-field comment_input">
            <form method="post" action="/agregarComentario">

                <input placeholder="Placeholder" name="comentario" class="validate" type="text">
                <input type="hidden" name="articulo" value="${articulo.id}">
                <input type="hidden" name="autor" value="${articulo.usuario.id}">

                <button type="submit" class="btn-large">Post</button>
            </form>


            <br>
            <br>
        </div>
    </div>
    <div class="col p0 s12">
    <#list list as comentario>

        <div class="media">
                <#if (comentario.autor.fotoPerfil)??>
                    <img src="../${comentario.autor.fotoPerfil}" alt="" height="60" width="51"
                         class="circle responsive-img">
                </#if>
            <div class="media_body">
                <h4><a href="#">${comentario.autor.nombre} ${comentario.autor.apellido}</a> </h4>
                <p>${comentario.comentario}</p>
                <span><a href=""><i class="ion-ios-arrow-thin-up"></i></a>483<a href="#"><i
                        class="ion-ios-arrow-thin-down"></i></a></span>

            <#--<a href="#" class="view_mor_r">View more replies...</a>-->
            </div>
        </div>
    <#--<a href="#" class="load_more">Load more comments</a>-->

    </#list>
    </div>
</div>