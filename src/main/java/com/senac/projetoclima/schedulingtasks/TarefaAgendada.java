package com.senac.projetoclima.schedulingtasks;

import com.senac.projetoclima.models.Results;
import com.senac.projetoclima.models.Root;
import com.senac.projetoclima.repositories.ResultsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TarefaAgendada {
    @Autowired
    ResultsRepository resultsRepository;



    @Scheduled(fixedRate = 5000)
    public void verificarResults(){
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
        String lat="-20.3174967";
        String longi="-40.3085394";

        Root root =  restTemplate.getForObject(
                "https://api.hgbrasil.com/weather?key=fae1d340&lat="+lat+"&lon="+longi+"",
                Root.class);

        Results results = new Results();

        results = root.getResults();

        Results resultsEncontrado = resultsRepository.findResultsByDate(results.getDate());
        if (resultsEncontrado == null){
            System.out.println("Criando novo registro");

            resultsRepository.save(results);
        }else {
            System.out.println("registro encontrado");
            Results resultsAtualizado = resultsEncontrado.update(results);


            resultsRepository.save(resultsAtualizado);
        }



        System.out.println();
    }
}
