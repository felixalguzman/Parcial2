<div id="post_modal" class="add_post modal">
    <h2>Nuevo Post</h2>
    <form class="input_group" method="post" action="/publicar">
        <div class="input-field">
            <textarea class="textarea" name="descripcion" placeholder="Descripción del post" required></textarea>
        </div>
        <div class="upload_photo row">
            <ul class="tabs tab_nav">
                <li class="tab col s12"><a href="#photo"><i class="ion-ios-camera"></i>Agregar Foto</a></li>
            </ul>
            <div id="photo" class="col s12 tabs_content">
                <div class="photo_u upload-image-preview">
                    <img id="eje" src="images/upload.png" alt="">
                    <h4>Selecciona una foto
                        <#--<small>or drag &amp; drop files</small>-->
                    </h4>
                </div>
                <div class="input-field col s12">
                    <input type='file' id="imgInp" name="file" class="waves-effect" onchange="readURL(this);" />

                </div>
            </div>
        </div>
        <div class="input-field col s12 select_option">
            <div class="chips chips-placeholder" data-index="0" data-initialized="true">
                <input  type="text" placeholder="Etiqueta Etiqueta2">
            </div>
        </div>


        <div class="row submit_btn_area">

            <div class="col s12">
                <button class="waves-effect publish">Publicar</button>
            </div>
        </div>
    </form>
</div>