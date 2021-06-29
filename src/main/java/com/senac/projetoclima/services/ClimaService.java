package com.senac.projetoclima.services;

import com.senac.projetoclima.models.Results;
import com.senac.projetoclima.models.Root;
import com.senac.projetoclima.repositories.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {

    @Autowired
    ResultsRepository resultsRepository;

    public Results findClima(String lat, String longi){
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();


        Root root =  restTemplate.getForObject(
                "https://api.hgbrasil.com/weather?key=7b50a319&lat="+lat+"&lon="+longi+"",
                Root.class);


        Results results = new Results();

        results = root.getResults();

        Results resultsEncontrado = resultsRepository.findResultsByCityAndDate(results.getCity(), results.getDate());
        if (resultsEncontrado ==null){
            System.out.println("Criando novo registro");

            resultsRepository.save(results);
        }else {
            System.out.println("registro encontrado");
            Results resultsAtualizado = resultsEncontrado.update(results);


            resultsRepository.save(resultsAtualizado);
        }

        return resultsEncontrado;

    }
}
