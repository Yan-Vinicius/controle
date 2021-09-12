package com.controle.de.ponto.controle.controller;

import com.controle.de.ponto.controle.model.Calendario;
import com.controle.de.ponto.controle.model.Ocorrencia;
import com.controle.de.ponto.controle.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping
    public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia){

        return ocorrenciaService.saveOcorrencia(ocorrencia);
    }

    @GetMapping
    public List<Ocorrencia> getOcorrenciaList(){

        return ocorrenciaService.findAll();

    }

    @GetMapping("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> getOcorrenciaByID(@PathVariable("idOcorrencia") Long id) throws Exception{

        return ResponseEntity.ok(ocorrenciaService.getById(id).orElseThrow(() -> new NoSuchElementException("Não encontrado")));

    }

    @PutMapping
    public Ocorrencia updateOcorrencia(@RequestBody Ocorrencia ocorrencia){

        return ocorrenciaService.updateOcorrencia(ocorrencia);

    }

    @DeleteMapping("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> deleteByID(@PathVariable("idOcorrencia") Long id) throws Exception{

        try {

            ocorrenciaService.deleteOcorrencia(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return (ResponseEntity<Ocorrencia>) ResponseEntity.ok();

    }
}
