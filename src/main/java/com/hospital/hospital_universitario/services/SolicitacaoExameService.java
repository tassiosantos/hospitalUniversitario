package com.hospital.hospital_universitario.services;

import java.util.List;
// import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospital_universitario.models.SolicitacaoExame;
import com.hospital.hospital_universitario.repositories.SolicitacaoExameRepository;


@Service
public class SolicitacaoExameService {
    
    private final SolicitacaoExameRepository solicitacaoExameRepository;

    @Autowired
    public SolicitacaoExameService(SolicitacaoExameRepository solicitacaoExameRepository){
        this.solicitacaoExameRepository = solicitacaoExameRepository;
    }

    public List<SolicitacaoExame> getPacientes(){
        List<SolicitacaoExame> solicitacoes = solicitacaoExameRepository.findAll();
        return solicitacoes;
    }
}
