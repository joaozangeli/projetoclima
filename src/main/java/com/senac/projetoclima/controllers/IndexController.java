package com.senac.projetoclima.controllers;

import com.senac.projetoclima.models.Position;
import com.senac.projetoclima.models.Results;
import com.senac.projetoclima.repositories.PositionRepository;
import com.senac.projetoclima.repositories.ResultsRepository;
import com.senac.projetoclima.services.ClimaService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class IndexController {
    @Autowired
    PositionRepository positionRepository;

    @Autowired
    ResultsRepository resultsRepository;

    @Autowired
    ClimaService climaService;

    private static String position = "";

    private int temperatura;
    private String cidade;

    @GetMapping("/")
    public String index(){


        return "index";
    }


    @PostMapping("/")
    public ModelAndView findClima(){

        ModelAndView modelAndView = new ModelAndView("index");
        Results results = new Results();

        results = climaService.findClima("-20.5410651","40.0000");

        modelAndView.addObject("results",results);

        return modelAndView;
    }
    private int getInfoTemp(){


        //Results ultimo = resultsRepository.
        int t = 0;

        //int ultimo = resultsRepository.findAll().size() -1;
        for ( Results r: resultsRepository.findAll() ) {
            t = r.getTemp();
        }

        System.out.println(t);
        //System.out.println(resultsRepository.findFirst());
        //System.out.println(resultsRepository.findAll().stream().findFirst().get().getTemp());
        return t;

    }

    private String getInfoCity(){
        return resultsRepository.findAll().get(0).getCity();
    }

    @RequestMapping(value="/sendposition", method=RequestMethod.POST)
    public String sendPosition(@RequestBody String lat, String lng){
        System.out.println("Latitude: " + lat + "Longitude: " + lng);
        return "home/position";
    }
}
