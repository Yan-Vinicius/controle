package com.controle.de.ponto.controle.controller;

import com.controle.de.ponto.controle.model.BancoHoras;
import com.controle.de.ponto.controle.model.JornadaTrabalho;
import com.controle.de.ponto.controle.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/bancoHoras")
public class BancoHorasController {

    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    public BancoHoras createBanco(@RequestBody BancoHoras bancoHoras){

        return bancoHorasService.saveBancohoras(bancoHoras);
    }

    @GetMapping
    public List<BancoHoras> getBancoHorasList(){

        return bancoHorasService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<BancoHoras> getBancoHorasByID(@PathVariable("id") Long id) throws Exception{

        return ResponseEntity.ok(bancoHorasService.getById(id).orElseThrow(() -> new NoSuchElementException("Não encontrado")));

    }

    @PutMapping
    public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras){

        return bancoHorasService.updateBancoHoras(bancoHoras);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BancoHoras> deleteByID(@PathVariable("id") Long id) throws Exception{

        try {


            bancoHorasService.deleteBancoHoras(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return (ResponseEntity<BancoHoras>) ResponseEntity.ok();

    }


}
