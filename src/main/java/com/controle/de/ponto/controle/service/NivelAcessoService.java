package com.controle.de.ponto.controle.service;

import com.controle.de.ponto.controle.model.JornadaTrabalho;
import com.controle.de.ponto.controle.model.NivelAcesso;
import com.controle.de.ponto.controle.repository.JornadaRepository;
import com.controle.de.ponto.controle.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelAcessoService {

    NivelAcessoRepository nivelAcessoRepository;

    @Autowired
    public NivelAcessoService(NivelAcessoRepository nivelAcessoRepository) {
        this.nivelAcessoRepository = nivelAcessoRepository;
    }

    public NivelAcesso saveNivelAcesso(NivelAcesso nivelAcesso){
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public List<NivelAcesso> findAll() {
        return nivelAcessoRepository.findAll();
    }

    public Optional<NivelAcesso> getById(Long id) {

        return nivelAcessoRepository.findById(id);

    }

    public NivelAcesso updateNivelAcesso(NivelAcesso nivelAcesso){
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public void deleteNivelAcesso(Long id) {

        nivelAcessoRepository.deleteById(id);

    }

}
