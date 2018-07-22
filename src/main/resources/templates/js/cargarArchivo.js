$("input[name=file]").change(function () {
    if (this.files && this.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            var element = document.getElementById("#eje");
            element.parentNode.removeChild(element);
            var img = $('<img>').attr('src', e.target.result);
            $('.upload-image-preview').html(img);
        };

        reader.readAsDataURL(this.files[0]);
    }
});