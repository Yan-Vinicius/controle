package com.controle.de.ponto.controle.controller;

import com.controle.de.ponto.controle.model.Calendario;
import com.controle.de.ponto.controle.model.NivelAcesso;
import com.controle.de.ponto.controle.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nivelacesso")
public class NivelAcessoController {

    @Autowired
    NivelAcessoService nivelAcessoService;

    @PostMapping
    public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso){

        return nivelAcessoService.saveNivelAcesso(nivelAcesso);
    }

    @GetMapping
    public List<NivelAcesso> getNivelAcessoList(){

        return nivelAcessoService.findAll();

    }

    @GetMapping("/{idNivelAcesso}")
    public ResponseEntity<NivelAcesso> getNivelAcessoByID(@PathVariable("idNivelAcesso") Long id) throws Exception{

        return ResponseEntity.ok(nivelAcessoService.getById(id).orElseThrow(() -> new NoSuchElementException("Não encontrado")));

    }

    @PutMapping
    public NivelAcesso updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso){

        return nivelAcessoService.updateNivelAcesso(nivelAcesso);

    }

    @DeleteMapping("/{idNivelAcesso}")
    public ResponseEntity<NivelAcesso> deleteByID(@PathVariable("idNivelAcesso") Long id) throws Exception{

        try {

            nivelAcessoService.deleteNivelAcesso(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return (ResponseEntity<NivelAcesso>) ResponseEntity.ok();

    }
}
