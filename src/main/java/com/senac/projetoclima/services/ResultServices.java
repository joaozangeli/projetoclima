package com.senac.projetoclima.services;

import com.senac.projetoclima.models.Results;
import com.senac.projetoclima.models.Root;
import com.senac.projetoclima.repositories.PositionRepository;
import com.senac.projetoclima.repositories.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ResultServices {
    @Autowired
    ResultsRepository resultsRepository;

    @Autowired
    PositionRepository positionRepository;

    private String lat;
    private String lng;

    //@Scheduled(fixedRate = 50000000)
    public Results verificarResults(String lat, String lng){
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();


        Root root =  restTemplate.getForObject(
                "https://api.hgbrasil.com/weather?key=7b50a319&lat="+lat+"&lon="+lng+"",
                Root.class);


        Results results = new Results();

        results = root.getResults();

        Results resultsEncontrado=null;
        try{
            resultsEncontrado= resultsRepository.findResultsByCityAndDate(results.getCity(), results.getDate());

        }catch (Exception e){

        }


        if (resultsEncontrado == null){
            System.out.println("Criando novo registro");
            resultsRepository.save(results);
            return results;

        }else {
            System.out.println("registro encontrado");

            Results resultsAtualizado = resultsEncontrado.update(results);

            int i = resultsRepository.findAll().indexOf(resultsAtualizado);

            resultsRepository.getOne((long) i);
            resultsRepository.save( resultsRepository.getOne((long) i));

            return resultsAtualizado;
        }

    }
}
