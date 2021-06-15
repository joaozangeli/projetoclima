
var x = document.getElementById("demo");

if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
} else {
    x.innerHTML = "Geolocation is not supported by this browser.";
}

    function showPosition(position) {
        x.innerHTML = "Latitude: " + position.coords.latitude +
            "<br>Longitude: " + position.coords.longitude;

            $.ajax({
                    url: "/sendposition",
                    method: "POST",
                    dataType: "json",
                    data: {lat:position.coords.latitude, lng:position.coords.longitude}
                }).then(function(data) {
                         console.log("cheguei aqui");
                });
    }
    console.log(x);
