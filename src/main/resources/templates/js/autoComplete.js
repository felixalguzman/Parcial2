
$(function(){
    $.fn.atwho.debug = true
    var emojis = [
        "smile", "iphone", "girl", "smiley", "heart", "kiss", "copyright", "coffee",
        "a", "ab", "airplane", "alien", "ambulance", "angel", "anger", "angry",
        "arrow_forward", "arrow_left", "arrow_lower_left", "arrow_lower_right",
        "arrow_right", "arrow_up", "arrow_upper_left", "arrow_upper_right",
        "art", "astonished", "atm", "b", "baby", "baby_chick", "baby_symbol",
        "balloon", "bamboo", "bank", "barber", "baseball", "basketball", "bath",
        "bear", "beer", "beers", "beginner", "bell", "bento", "bike", "bikini",
        "bird", "birthday", "black_square", "blue_car", "blue_heart", "blush",
        "boar", "boat", "bomb", "book", "boot", "bouquet", "bow", "bowtie",
        "boy", "bread", "briefcase", "broken_heart", "bug", "bulb",
        "person_with_blond_hair", "phone", "pig", "pill", "pisces", "plus1",
        "point_down", "point_left", "point_right", "point_up", "point_up_2",
        "police_car", "poop", "post_office", "postbox", "pray", "princess",
        "punch", "purple_heart", "question", "rabbit", "racehorse", "radio",
        "up", "us", "v", "vhs", "vibration_mode", "virgo", "vs", "walking",
        "warning", "watermelon", "wave", "wc", "wedding", "whale", "wheelchair",
        "white_square", "wind_chime", "wink", "wink2", "wolf", "woman",
        "womans_hat", "womens", "x", "yellow_heart", "zap", "zzz", "+1",
        "-1"
    ]
    var jeremy = decodeURI("J%C3%A9r%C3%A9my") // Jérémy

    var emojis = $.map(emojis, function(value, i) {return {key: value, name:value}});

    var at_config = {
        at: "@",
        data: "http://localhost:4567/rest/usuarios/",
        headerTpl: '<div class="atwho-header">Lista de Usuarios<small>↑&nbsp;↓&nbsp;</small></div>',
        insertTpl: '@${nombre}',
        displayTpl: "<li>${nombre} ${apellido} <small>${correo}</small></li>",
        limit: 200
    }
    var emoji_config = {
        at: ":",
        data: emojis,
        displayTpl: "<li>${name} <img src='https://assets-cdn.github.com/images/icons/emoji/${key}.png'  height='20' width='20' /></li>",
        insertTpl: ':${key}:',
        delay: 400
    }
    $inputor = $('#inputor').atwho(at_config).atwho(emoji_config);
    $inputor.caret('pos', 47);
    $inputor.focus().atwho('run');

    emoji_config.insertTpl = "<img src='https://assets-cdn.github.com/images/icons/emoji/${name}.png'  height='20' width='20' />"
    $('#editable').atwho(at_config).atwho(emoji_config);

    ifr = $('#iframe1')[0]
    doc = ifr.contentDocument || iframe.contentWindow.document
    if ((ifrBody = doc.body) == null) {
        // For IE
        doc.write("<body></body>")
        ifrBody = doc.body
    }
    ifrBody.contentEditable = true
    ifrBody.id = 'ifrBody'
    ifrBody.innerHTML = 'For <strong>WYSIWYG</strong> which using <strong>iframe</strong> such as <strong>ckeditor</strong>'
    $(ifrBody).atwho('setIframe', ifr).atwho(at_config)
});

