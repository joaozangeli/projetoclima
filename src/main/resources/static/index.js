var x = document.getElementById("demo");

if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
} else {
    x.innerHTML = "Geolocation is not supported by this browser.";
}

    function showPosition(position) {
        x.innerHTML = "Latitude: " + position.coords.latitude +
            "<br>Longitude: " + position.coords.longitude;

            $.post("/sendposition", {lat:position.coords.latitude, long:position.coords.longitude}, function(resp){
            console.log(resp)
            } )
    }
    console.log(x);
