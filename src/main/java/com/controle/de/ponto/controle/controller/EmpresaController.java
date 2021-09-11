package com.controle.de.ponto.controle.controller;

import com.controle.de.ponto.controle.model.Calendario;
import com.controle.de.ponto.controle.model.Empresa;
import com.controle.de.ponto.controle.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa){

        return empresaService.saveEmpresa(empresa);
    }

    @GetMapping
    public List<Empresa> getEmpresaList(){

        return empresaService.findAll();

    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getEmpresaByID(@PathVariable("idEmpresa") Long id) throws Exception{

        return ResponseEntity.ok(empresaService.getById(id).orElseThrow(() -> new NoSuchElementException("Não encontrado")));

    }

    @PutMapping
    public Empresa updateEmpresa(@RequestBody Empresa empresa){

        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> deleteByID(@PathVariable("idEmpresa") Long id) throws Exception{

        try {

            empresaService.deleteEmpresa(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return (ResponseEntity<Empresa>) ResponseEntity.ok();

    }

}
