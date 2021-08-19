package com.senac.projetoclima.controllersRest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.senac.projetoclima.models.Forecast;
import com.senac.projetoclima.models.Position;
import com.senac.projetoclima.models.Results;
import com.senac.projetoclima.services.ResultServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@RestController
public class ResultsRestController {
    @Autowired
    ResultServices resultServices;


    @PostMapping(value="/sendposition")
    public String sendPosition(@RequestBody Position position){


        Forecast forecast = resultServices.verificarResults(position.getLatitude(),position.getLongitude());

        switch (forecast.getCondition()){

            case "storm":
                forecast.setMensagem("Tempestade amanhã");
                forecast.setUrl_imagem("TEMPESTADE.jpg");

                break;
            case "snow":
                forecast.setMensagem("Neve amanhã");
                forecast.setUrl_imagem("NEVE.jpg");

                break;
            case "hail":
                forecast.setMensagem("Chuva com granizo amanhã");
                forecast.setUrl_imagem("GRANIZO.jpg");

                break;
            case "rain":
                forecast.setMensagem("Chuva amanhã");
                forecast.setUrl_imagem("CHUVA.jpg");
                //"vai chover"
                break;
            case "fog":
                forecast.setMensagem("Névoa amanha");
                forecast.setUrl_imagem("NEBLINA.jpg");

                break;
            case "clear_day":
                forecast.setMensagem("Dia claro amanhã");
                forecast.setUrl_imagem("DIA_CLARO.jpg");

                break;
            case "clear_night":
                forecast.setMensagem("Noite clara amanhã");
                forecast.setUrl_imagem("NOITE_CLARA.jpg");

                break;
            case "cloud":
                forecast.setMensagem("Nuvens carregadas amanhã");
                forecast.setUrl_imagem("NUBLADO.jpg");

                break;
            case "cloudly_day":
                forecast.setMensagem("Dia nublado amanhã");
                forecast.setUrl_imagem("DIA_NUBLADO.jpg");

                break;
            case "cloudly_night":
                forecast.setMensagem("Noite nublada amanhã");
                forecast.setUrl_imagem("NOITE_NUBLADA.jpg");

                break;
            case "none_day":
                forecast.setMensagem("Não achou condição do dia seguinte.");
                forecast.setUrl_imagem("");

                break;
            case "none_night":
                forecast.setMensagem("Não achou condição da noite seguinte.");
                forecast.setUrl_imagem("error.jpg");

                break;
            default:
                forecast.setMensagem("Não achou a condição.");
                forecast.setUrl_imagem("error.jpg");


        }




        String json="";

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            json = ow.writeValueAsString(forecast);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
}
