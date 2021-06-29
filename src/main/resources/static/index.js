document.addEventListener("DOMContentLoaded", function(event){

    if(navigator.geolocation){
       navigator.geolocation.getCurrentPosition( function(position){
            const lat = position.coords.latitude;
            const lng =  position.coords.longitude;

           console.log(position.coords.latitude + " " + position.coords.longitude);



    } else {
       alert("Seu navegador não suporta geolocalização.");
    }
});

