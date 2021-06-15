package com.senac.projetoclima.controllers;

import com.senac.projetoclima.models.Position;
import com.senac.projetoclima.repositories.PositionRepository;
import com.senac.projetoclima.repositories.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class IndexController {
    @Autowired
    PositionRepository positionRepository;

    private static String position = "";


    @RequestMapping("/")
    public String index(Model model){

        Position pos = positionRepository.getById(1L);
        model.addAttribute("latitude", pos.getLatitude());
        model.addAttribute("longitude", pos.getLongitude());

        model.addAttribute("serverTime", new Date().toString())  ;



        return "index";
    }


    @RequestMapping(value="/sendposition", method=RequestMethod.POST)
    public String sendPosition(@RequestBody String lat, String lng){
        System.out.println("Latitude: " + lat + "Longitude: " + lng);
        return "home/position";
    }
}
