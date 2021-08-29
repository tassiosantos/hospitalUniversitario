package com.hospital.hospital_universitario.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospital_universitario.models.ExameDTO;
import com.hospital.hospital_universitario.models.Medico;
import com.hospital.hospital_universitario.models.Paciente;
import com.hospital.hospital_universitario.models.SolicitacaoExame;
import com.hospital.hospital_universitario.repositories.SolicitacaoExameRepository;


@Service
public class SolicitacaoExameService {
    
    private final SolicitacaoExameRepository solicitacaoExameRepository;
    private final MedicoService medicoService;
    private final PacienteService pacienteService;

    @Autowired
    public SolicitacaoExameService(SolicitacaoExameRepository solicitacaoExameRepository, MedicoService medicoService, PacienteService pacienteService){
        this.solicitacaoExameRepository = solicitacaoExameRepository;
        this.medicoService = medicoService;
        this.pacienteService = pacienteService;
    }

    public List<SolicitacaoExame> getSolicitacaoExames(){
        List<SolicitacaoExame> solicitacoes = solicitacaoExameRepository.findAll();
        return solicitacoes;
    }

    public SolicitacaoExame getSolicitacaoExameByNumber(int solicitacaoExameNumber){
        SolicitacaoExame solicitacaoExame = solicitacaoExameRepository.findById(solicitacaoExameNumber);
        return solicitacaoExame;
    }

    public List<ExameDTO> getSolicitacaoExameByPacienteId(int pacienteId){
        List<SolicitacaoExame> solicitacoes = solicitacaoExameRepository.findByPacienteId(pacienteId);
        List<ExameDTO> exames = new ArrayList<ExameDTO>();
        for(SolicitacaoExame solicitacao : solicitacoes){
            ExameDTO exame = new ExameDTO();
            extracted(solicitacao, exame);
            Medico medico = medicoService.getMedicoById(solicitacao.getRegistroMedico());
            Paciente paciente = pacienteService.getPacienteById(solicitacao.getPacienteId());
            exame.setMedico(medico);
            exame.setPaciente(paciente);
            exames.add(exame);
        }
        return exames;
    }

    private void extracted(SolicitacaoExame solicitacao, ExameDTO exame) {
        BeanUtils.copyProperties(solicitacao, exame);
    }

    public SolicitacaoExame newSolicitacaoExame(SolicitacaoExame newSolicitacaoExame) {
        SolicitacaoExame solicitacao = this.solicitacaoExameRepository.save(newSolicitacaoExame);
        return solicitacao;
    }

    public SolicitacaoExame update(SolicitacaoExame updatedSolicitacaoExame) {
        SolicitacaoExame solicitacaoExame = this.solicitacaoExameRepository.save(updatedSolicitacaoExame);
        return solicitacaoExame;
    }
    
    public void delete(SolicitacaoExame solicitacao) {
        this.solicitacaoExameRepository.delete(solicitacao);
    }
}
