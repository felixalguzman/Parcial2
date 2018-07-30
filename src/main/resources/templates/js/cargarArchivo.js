function readURL(input) {
    if (input.files && input.files[0]) {
        let reader = new FileReader();

        reader.onload = function (e) {
            $('#blah')
                .attr('src', e.target.result)
                .width(150)
                .height(200);
            let output = document.getElementById('blah');
            $('#base64').val(output.src);
            console.log($('#base64').val())

        };
        document.getElementById("titulo").innerHTML = "";
        reader.readAsDataURL(input.files[0]);


    }
}