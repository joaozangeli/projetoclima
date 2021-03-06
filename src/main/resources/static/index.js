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
              success: function(resp){ //resp aqui eh a sua temperatura
                 console.log(resp); //Ex: out = 21

                 const object = JSON.parse(resp);

                 const coisa = document.getElementById("card");
                 card.style.backgroundImage="url("+(object.url_imagem)+")"

                 //modificar valor temperatura a partir do id
                 var temperatura_minima = document.getElementById("temperatura_minima");
                 var temperatura_maxima = document.getElementById("temperatura_maxima");

                 temperatura_minima.innerText = object.min;
                 temperatura_maxima.innerText = object.max;

                 // funcao q muda o texto de acordo com a temperatura (resp)
                 const text = document.getElementById("text-temperatura");
                 text.innerText = object.mensagem;

                 // passa o texto e a temperatura por interpolacao para a url do whatsapp
                 var link = `https://wa.me/?text=${object.mensagem} fonte https://funnyweather.herokuapp.com`;
                 document.getElementById("whatsapplink").href = link
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

