package com.senac.projetoclima.controllers;

import com.senac.projetoclima.repositories.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    ResultsRepository resultsRepository;

    private int temperatura = 0;

    @RequestMapping("/")
    public String index(Model model){

        temperatura = getInfoTemp();

        model.addAttribute("temperatura", temperatura);


        return "index";
    }

    private int getInfoTemp(){

        int t = resultsRepository.findAll().get(0).getTemp();
        return t;

    }

    @RequestMapping(value = "/sendposition", method =  RequestMethod.POST)
    public void sendPosition(String lat, String lng){
        System.out.println("latitude: " + lat + "longitude: " + lng);
    }

}
