package com.controle.de.ponto.controle.service;

import com.controle.de.ponto.controle.model.JornadaTrabalho;
import com.controle.de.ponto.controle.model.Localidade;
import com.controle.de.ponto.controle.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {

    LocalidadeRepository localidadeRepository;

    @Autowired
    public LocalidadeService(LocalidadeRepository localidadeRepository){this.localidadeRepository = localidadeRepository;}

    public Localidade saveLocalidade(Localidade localidade){

        return localidadeRepository.save(localidade);

    }

    public List<Localidade> findAll() {
        return localidadeRepository.findAll();
    }

    public Optional<Localidade> getById(Long idLocalidade) {

        return localidadeRepository.findById(idLocalidade);

    }

    public Localidade updateLocalidade(Localidade localidade){
        return localidadeRepository.save(localidade);
    }

    public void deleteLocalidade(Long idLocalidade) {

        localidadeRepository.deleteById(idLocalidade);

    }

}
