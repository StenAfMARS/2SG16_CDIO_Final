$("#logOnForm").submit(function(e) {
    e.preventDefault();
});

function switchPage(page, returning){
    $("#test").load(page, function (data) {
        if (!returning)
            history.pushState(null, "", page);
    });
}

window.onpopstate = function(event) {
    switchPage(document.location.toString(), true);
};

function setKeycard(kc){
    $("#kcController")[0].innerHTML = `.kc {display: none;} .kc${kc} {display: inline-block;}`;
}