package com.senac.projetoclima.controllers;

import com.senac.projetoclima.models.Position;
import com.senac.projetoclima.models.Results;
import com.senac.projetoclima.repositories.PositionRepository;
import com.senac.projetoclima.repositories.ResultsRepository;
import com.senac.projetoclima.schedulingtasks.TarefaAgendada;
import com.senac.projetoclima.services.ResultServices;
import javafx.geometry.Pos;
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
    ResultServices resultServices;

    private static String position = "";

    private int temperatura;
    private String cidade;

    @GetMapping("/")
    public String index(Model model){



        return "index";
    }






}
