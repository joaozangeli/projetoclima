document.addEventListener("DOMContentLoaded", function(event){

    if(navigator.geolocation){
       navigator.geolocation.getCurrentPosition( function(position){
            const lat = position.coords.latitude;
            const lng =  position.coords.longitude;

           console.log(position.coords.latitude + " " + position.coords.longitude);

           $.ajax({
            contentType: "application/json; charset=utf-8",
              url: '/sendposition',
              type: "POST",
              contentType: 'application/json',
              data: JSON.stringify({latitude: lat, longitude: lng }),
              success: function(resp){
                 console.log(resp);
                 //modificar valor temperatura a partir do id
                 var x = document.getElementById("temperatura");
                 x.innerText = resp;
              },
              error: function(error){
                console.log(error);
              }
           });

       });
    } else {
       alert("Seu navegador não suporta geolocalização.");
    }
});

