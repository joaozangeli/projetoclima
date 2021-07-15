package com.senac.projetoclima.controllersRest;

import com.senac.projetoclima.models.Position;
import com.senac.projetoclima.models.Results;
import com.senac.projetoclima.services.ResultServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultsRestController {
    @Autowired
    ResultServices resultServices;


    @PostMapping(value="/sendposition")
    public String sendPosition(@RequestBody Position position){


        Results results = resultServices.verificarResults(position.getLatitude(),position.getLongitude());

        return String.valueOf(results.getTemp());
    }
}
