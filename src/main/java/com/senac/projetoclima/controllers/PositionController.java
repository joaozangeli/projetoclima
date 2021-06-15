package com.senac.projetoclima.controllers;

import com.senac.projetoclima.models.Position;
import com.senac.projetoclima.repositories.PositionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/position"})
public class PositionController {

        private PositionRepository repository;

        PositionController(PositionRepository positionRepository){
            this.repository = positionRepository;
        }

        /**
         * GET ALL:  Obtém a lista de registros.
         * @return lista de registros
         */
        @GetMapping
        public List findAll(){
            return repository.findAll();
        }

        /**
         * UPDATE: Atualizar o registro
         * @param id
         * @param position
         * @return
         */
        @PutMapping(value="/{id}")
        public ResponseEntity update(@PathVariable("id") long id,
                                     @RequestBody Position position) {
            return repository.findById(id)
                    .map(record -> {
                        record.setLatitude(position.getLatitude());
                        record.setLongitude(position.getLongitude());

                        Position updated  = repository.save(record);

                        return ResponseEntity.ok().body(updated);
                    }).orElse(ResponseEntity.notFound().build());
        }

        /**
         * GET: Obter o registro informado
         * @param id
         * @return
         */
        @GetMapping(path = {"/{id}"})
        public ResponseEntity findById(@PathVariable long id){
            return repository.findById(id)
                    .map(record -> ResponseEntity.ok().body(record))
                    .orElse(ResponseEntity.notFound().build());
        }


        /**
         * POST: Criar ou acrescentar novo registro
         * @param position
         * @return
         */
        @PostMapping
        public Position create(@RequestBody Position position){
            return repository.save(position);
        }


        /**
         * DELETE - Excluir o registro
         * @param id
         * @return
         */
        @DeleteMapping(path ={"/{id}"})
        public ResponseEntity <?> delete(@PathVariable long id) {
            return repository.findById(id)
                    .map(record -> {
                        repository.deleteById(id);
                        return ResponseEntity.ok().build();
                    }).orElse(ResponseEntity.notFound().build());
        }

    }


