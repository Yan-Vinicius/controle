package com.controle.de.ponto.controle.service;

import com.controle.de.ponto.controle.model.NivelAcesso;
import com.controle.de.ponto.controle.model.Usuario;
import com.controle.de.ponto.controle.repository.NivelAcessoRepository;
import com.controle.de.ponto.controle.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getById(Long id) {

        return usuarioRepository.findById(id);

    }

    public Usuario updateUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {

        usuarioRepository.deleteById(id);

    }
}
