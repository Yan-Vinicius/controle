package com.controle.de.ponto.controle.controller;

import com.controle.de.ponto.controle.model.Calendario;
import com.controle.de.ponto.controle.model.Movimentacao;
import com.controle.de.ponto.controle.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao createMovimentacao(@RequestBody Movimentacao movimentacao){

        return movimentacaoService.saveMovimentacao(movimentacao);
    }

    @GetMapping
    public List<Movimentacao> getMovimentacaoList(){

        return movimentacaoService.findAll();

    }

    @GetMapping("/{idMovimento}")
    public ResponseEntity<Movimentacao> getMovimentacaoByID(@PathVariable("idMovimento") Long id) throws Exception{

        return ResponseEntity.ok(movimentacaoService.getById(id).orElseThrow(() -> new NoSuchElementException("Não encontrado")));

    }

    @PutMapping
    public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao){

        return movimentacaoService.updateMovimentacao(movimentacao);

    }

    @DeleteMapping("/{idMovimento}")
    public ResponseEntity<Movimentacao> deleteByID(@PathVariable("idMovimento") Long id) throws Exception{

        try {

            movimentacaoService.deleteMovimentacao(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return (ResponseEntity<Movimentacao>) ResponseEntity.ok();

    }
}
