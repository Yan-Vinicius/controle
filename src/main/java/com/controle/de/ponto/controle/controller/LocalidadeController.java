package com.controle.de.ponto.controle.controller;

import com.controle.de.ponto.controle.model.Localidade;
import com.controle.de.ponto.controle.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    public Localidade createLocalidade(@RequestBody Localidade localidade){

        return localidadeService.saveLocalidade(localidade);
    }

    @GetMapping
    public List<Localidade> getLocalidadeList(){

        return localidadeService.findAll();

    }

    @GetMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> getLocalidadeByID(@PathVariable("idLocalidade") Long id) throws Exception{

        return ResponseEntity.ok(localidadeService.getById(id).orElseThrow(() -> new NoSuchElementException("Não encontrado")));

    }

    @PutMapping
    public Localidade updateLocalidade(@RequestBody Localidade localidade){

        return localidadeService.saveLocalidade(localidade);

    }

    @DeleteMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> deleteByID(@PathVariable("idLocalidade") Long id) throws Exception{

        try {

            localidadeService.deleteLocalidade(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return (ResponseEntity<Localidade>) ResponseEntity.ok();

    }
}
