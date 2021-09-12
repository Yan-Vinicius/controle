package com.controle.de.ponto.controle.controller;

import com.controle.de.ponto.controle.model.Calendario;
import com.controle.de.ponto.controle.model.TipoData;
import com.controle.de.ponto.controle.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tipodata")
public class TipoDataController {

    @Autowired
    TipoDataService tipoDataService;

    @PostMapping
    public TipoData createTipoData(@RequestBody TipoData tipoData){

        return tipoDataService.saveTipoData(tipoData);

    }

    @GetMapping
    public List<TipoData> getTipoDataList(){

        return tipoDataService.findAll();

    }

    @GetMapping("/{idTipoData}")
    public ResponseEntity<TipoData> getTipoDataByID(@PathVariable("idTipoData") Long id) throws Exception{

        return ResponseEntity.ok(tipoDataService.getById(id).orElseThrow(() -> new NoSuchElementException("Não encontrado")));

    }

    @PutMapping
    public TipoData updateTipoData(@RequestBody TipoData tipoData){

        return tipoDataService.updateTipoData(tipoData);

    }

    @DeleteMapping("/{idTipoData}")
    public ResponseEntity<TipoData> deleteByID(@PathVariable("idTipoData") Long id) throws Exception{

        try {

            tipoDataService.deleteTipoData(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return (ResponseEntity<TipoData>) ResponseEntity.ok();

    }
}
