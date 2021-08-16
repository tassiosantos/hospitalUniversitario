package com.hospital.hospital_universitario.services;

import java.util.List;
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

    public List<SolicitacaoExame> getSolicitacaoExames(){
        List<SolicitacaoExame> solicitacoes = solicitacaoExameRepository.findAll();
        return solicitacoes;
    }

    public SolicitacaoExame getSolicitacaoExameByNumber(int solicitacaoExameNumber){
        SolicitacaoExame solicitacaoExame = solicitacaoExameRepository.findById(solicitacaoExameNumber);
        return solicitacaoExame;
    }

    public void newMedico(SolicitacaoExame newSolicitacaoExame) {
        this.solicitacaoExameRepository.save(newSolicitacaoExame);
    }

    public SolicitacaoExame update(SolicitacaoExame updatedSolicitacaoExame) {
        SolicitacaoExame solicitacaoExame = this.solicitacaoExameRepository.save(updatedSolicitacaoExame);
        return solicitacaoExame;
    }
    
    public void delete(SolicitacaoExame solicitacao) {
        this.solicitacaoExameRepository.delete(solicitacao);
    }
}
