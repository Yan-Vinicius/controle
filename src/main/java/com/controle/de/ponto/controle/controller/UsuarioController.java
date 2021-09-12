package com.controle.de.ponto.controle.controller;

import com.controle.de.ponto.controle.model.Calendario;
import com.controle.de.ponto.controle.model.Usuario;
import com.controle.de.ponto.controle.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario createUusuario(@RequestBody Usuario usuario){

        return usuarioService.saveUsuario(usuario);

    }

    @GetMapping
    public List<Usuario> getUsuarioList(){

        return usuarioService.findAll();

    }

    @GetMapping("/{idUser}")
    public ResponseEntity<Usuario> getUsuarioByID(@PathVariable("idUser") Long id) throws Exception{

        return ResponseEntity.ok(usuarioService.getById(id).orElseThrow(() -> new NoSuchElementException("Não encontrado")));

    }

    @PutMapping
    public Usuario updateUsuario(@RequestBody Usuario usuario){

        return usuarioService.updateUsuario(usuario);

    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<Usuario> deleteByID(@PathVariable("idUser") Long id) throws Exception{

        try {

            usuarioService.deleteUsuario(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return (ResponseEntity<Usuario>) ResponseEntity.ok();

    }

}
