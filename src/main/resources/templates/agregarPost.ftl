<#--<link rel="stylesheet" href="../vendors/check-button/switch.css">-->
<script type="text/javascript" src="http://ichord.github.io/Caret.js/src/jquery.caret.js"></script>
<script type="text/javascript" src="../../dist/js/jquery.atwho.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/at.js/1.4.0/css/jquery.atwho.min.css">
<script type="text/javascript" src="../../js/autoComplete.js"></script>
<script type="text/javascript" src="../../js/cargarArchivo.js"></script>

<script>
    function validar() {

        if (form.descripcion.value === "" && form.foto.files.length === 0){
            alert("Debe agregar una descripcion o una foto");
            return false;

        }

        document.forms['form'].submit();
    }
</script>

<div id="post_modal" class="add_post modal">
    <h2>Nuevo Post</h2>
    <form class="input_group validar" name="form" method="post"  enctype="multipart/form-data" onsubmit="event.preventDefault(); validar()" action="/publicar">
        <div class="input-field">
            <input type="text" class="validate" name="titulo" placeholder="Titulo del post">
            <textarea class="textarea inputor" id="inputor" name="descripcion" placeholder="Descripción del post. Puedes etiquetar a algún amigo con @"
            ></textarea>
        </div>
        <div class="upload_photo row">
            <ul class="tabs tab_nav">
                <li class="tab col s12"><a href="#photo"><i class="ion-ios-camera"></i>Agregar Foto</a></li>
            </ul>
            <div id="photo" class="col s12 tabs_content">
                <div class="photo_u upload-image-preview">
                    <img id="blah" src="../../images/upload.png" alt="">
                    <h4 id="titulo">Selecciona una foto
                    <#--<small>or drag &amp; drop files</small>-->
                    </h4>
                </div>
                <div class="input-field col s12">
                    <input type='file' accept="image/*" name="foto" onchange="readURL(this);" class="waves-effect"/>

                </div>
            </div>
        </div>
        <div class="input-field col s12 select_option">
            <div class="input-field">
                <input type="text" placeholder="Etiqueta, Etiqueta2" name="etiquetas">
            </div>
        </div>


        <h4>Publico <span class="tooltip" data-balloon-pos="right"
                          data-balloon="Los usuarios no registrados pueden ver la publicacion sin iniciar sesión"><i
                class="ion-help"></i> </span></h4>
        <input type="checkbox" id="togBtn" name="publico">
        <label for="togBtn" class="switch" style="display: inline-block;width: 300px;height: 90px;">

        </label>


        <br>
        <br>
        <br>

        <div class="row submit_btn_area">

            <div class="col s12">
                <button class="waves-effect publish">Publicar</button>
            </div>
        </div>
    </form>
</div>