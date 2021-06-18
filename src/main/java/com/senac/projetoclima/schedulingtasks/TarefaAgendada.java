package com.senac.projetoclima.schedulingtasks;

import com.senac.projetoclima.models.Results;
import com.senac.projetoclima.models.Root;
import com.senac.projetoclima.repositories.PositionRepository;
import com.senac.projetoclima.repositories.ResultsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.List;

@Component
public class TarefaAgendada {
    @Autowired
    ResultsRepository resultsRepository;

    @Autowired
    PositionRepository positionRepository;

    private String lat;
    private String lng;

    @Scheduled(fixedRate = 50000000)
    public void verificarResults(){
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
        String lat=   positionRepository.getById(1L).getLatitude(); //"-20.3174967";
        String longi= positionRepository.getById(1L).getLongitude();   //"-40.3085394";

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

            int i = resultsRepository.findAll().indexOf(resultsAtualizado);

            resultsRepository.getOne((long) i);
            resultsRepository.save( resultsRepository.getOne((long) i));
        }

        System.out.println();
    }
}
