package com.senac.projetoclima.controllers;

import com.senac.projetoclima.repositories.PositionRepository;
import com.senac.projetoclima.services.ResultServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    @Autowired
    PositionRepository positionRepository;

    @Autowired
    ResultServices resultServices;


    private static String position = "";

    private int temperatura;
    private String cidade;

    @GetMapping("/")
    public String index(Model model){


        return "index";
    }






}
