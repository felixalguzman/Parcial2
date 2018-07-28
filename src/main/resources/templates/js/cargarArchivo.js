var el = document.getElementById('#archivo');
el.on('click', function(file) {
    let reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onloadend = function () {
        let img = document.createElement('img');
        img.src = reader.result;
        document.getElementById('eje').src(img);
        document.getElementById('titulo').innerHTML = "";
        console.log("entro");
    }
});

