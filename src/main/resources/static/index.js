const changeTextByTemp = (temp) => {
    //aqui vc pode usar um switch case mas eu vou deixar
    //um if statement so de exemplo q dps vc faz o resto

    const text = document.getElementById("text-temperatura");
    if(temp >= 22) {
      text.innerText = "Ta quente"
    }
    else if(temp <= 21 && temp >= 15) {
      text.innerText = "Ta meio a meio"
    } else {
        text.innerText = "Ta frio"
    }
}

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

                 //modificar valor temperatura a partir do id
                 var x = document.getElementById("temperatura");
                 x.innerText = resp;

                 // funcao q muda o texto de acordo com a temperatura (resp)
                 changeTextByTemp(resp)

                 // passa o texto e a temperatura por interpolacao para a url do whatsapp
                 var texto = "Confira a temperatura!";
                 var textoEncoded = encodeURIComponent (texto);
                 var link = `https://wa.me/5527988063886?text=${textoEncoded}%0a${x.innerText}°C neste momento`;
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

