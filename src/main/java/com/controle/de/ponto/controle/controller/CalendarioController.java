package com.controle.de.ponto.controle.controller;

import com.controle.de.ponto.controle.model.Calendario;
import com.controle.de.ponto.controle.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public Calendario createCalendario(@RequestBody Calendario calendario){

        return calendarioService.saveCalendario(calendario);
    }

    @GetMapping
    public List<Calendario> getCalendarioList(){

        return calendarioService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Calendario> getCalendarioByID(@PathVariable("id") Long id) throws Exception{

        return ResponseEntity.ok(calendarioService.getById(id).orElseThrow(() -> new NoSuchElementException("Não encontrado")));

    }

    @PutMapping
    public Calendario updateCalendario(@RequestBody Calendario calendario){

        return calendarioService.updateCalendario(calendario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Calendario> deleteByID(@PathVariable("id") Long id) throws Exception{

        try {

            calendarioService.deleteCalendario(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return (ResponseEntity<Calendario>) ResponseEntity.ok();

    }

}

