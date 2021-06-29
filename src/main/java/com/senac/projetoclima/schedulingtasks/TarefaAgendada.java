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

import java.sql.SQLOutput;
import java.util.List;

@Component
public class TarefaAgendada {
    @Autowired
    ResultsRepository resultsRepository;
    private String lat;
    private String lng;
    @Scheduled(fixedRate = 500000)
    public void verificarResults(){



    }
}
