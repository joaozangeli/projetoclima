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
                forecast.setMensagem("Tempestade");
                forecast.setUrl_imagem("");

                break;
            case "snow":
                forecast.setMensagem("Neve");
                forecast.setUrl_imagem("");

                break;
            case "hail":
                forecast.setMensagem("Granizo");
                forecast.setUrl_imagem("");

                break;
            case "rain":
                forecast.setMensagem("Está chovendo");
                forecast.setUrl_imagem("");

                break;
            case "fog":
                forecast.setMensagem("Névoa");
                forecast.setUrl_imagem("");

                break;
            case "clear_day":
                forecast.setMensagem("Dia Claro");
                forecast.setUrl_imagem("");

                break;
            case "clear_night":
                forecast.setMensagem("Noite clara");
                forecast.setUrl_imagem("");

                break;
            case "cloud":
                forecast.setMensagem("Está nublado");
                forecast.setUrl_imagem("");

                break;
            case "cloudly_day":
                forecast.setMensagem("Dia nublado");
                forecast.setUrl_imagem("");

                break;
            case "cloudly_night":
                forecast.setMensagem("Noite nublada ");
                forecast.setUrl_imagem("cloudly-night.jpeg");

                break;
            case "none_day":
                forecast.setMensagem("Não achou condição do dia.");
                forecast.setUrl_imagem("");

                break;
            case "none_night":
                forecast.setMensagem("Não achou condição da noite.");
                forecast.setUrl_imagem("");

                break;
            default:
                forecast.setMensagem("Não achou a condição.");
                forecast.setUrl_imagem("");


        }


        forecast.setMensagem("qualquer coisa");

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
