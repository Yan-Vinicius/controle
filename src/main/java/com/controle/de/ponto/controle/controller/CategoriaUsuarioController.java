package com.controle.de.ponto.controle.controller;

import com.controle.de.ponto.controle.model.Calendario;
import com.controle.de.ponto.controle.model.CategoriaUsuario;
import com.controle.de.ponto.controle.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoriaUser")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public CategoriaUsuario createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){

        return categoriaUsuarioService.saveCategoriaUser(categoriaUsuario);
    }

    @GetMapping
    public List<CategoriaUsuario> getCategoriaUsuariooList(){

        return categoriaUsuarioService.findAll();

    }

    @GetMapping("/{idCateUser}")
    public ResponseEntity<CategoriaUsuario> getCategoriaUsuarioByID(@PathVariable("idCateUser") Long id) throws Exception{

        return ResponseEntity.ok(categoriaUsuarioService.getById(id).orElseThrow(() -> new NoSuchElementException("Não encontrado")));

    }

    @PutMapping
    public CategoriaUsuario updateCategoriaUSuario(@RequestBody CategoriaUsuario categoriaUsuario){

        return categoriaUsuarioService.updateCategoriaUser(categoriaUsuario);
    }

    @DeleteMapping("/{idCateUser}")
    public ResponseEntity<CategoriaUsuario> deleteByID(@PathVariable("idCateUser") Long id) throws Exception{

        try {

            categoriaUsuarioService.deleteCategoriaUser(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return (ResponseEntity<CategoriaUsuario>) ResponseEntity.ok();

    }
}
