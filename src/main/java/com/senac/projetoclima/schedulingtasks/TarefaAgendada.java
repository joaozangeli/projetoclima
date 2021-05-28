package com.senac.projetoclima.schedulingtasks;

import com.senac.projetoclima.models.Results;
import com.senac.projetoclima.models.Root;
import com.senac.projetoclima.repositories.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TarefaAgendada {
    @Autowired
    ResultsRepository resultsRepository;



    @Scheduled(fixedRate = 5000)
    public void verificarResults(){
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        Root root =  restTemplate.getForObject(
                "https://api.hgbrasil.com/weather",
                Root.class);

        Results results = new Results();

        results = root.getResults();

        resultsRepository.save(results);

        System.out.println();
    }
}
