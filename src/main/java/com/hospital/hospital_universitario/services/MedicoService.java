package com.hospital.hospital_universitario.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospital_universitario.models.Medico;
import com.hospital.hospital_universitario.repositories.MedicoRepository;


@Service
public class MedicoService {
    
    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> getMedicos(){
        List<Medico> medicos = medicoRepository.findAll();
        return medicos;
    }

    public Medico getMedicoById(int medicoId){
        Medico medico = medicoRepository.findById(medicoId);
        return medico;
    }

    public Medico getMedicoByCrm(String crm){
        Medico medico = medicoRepository.findByCrm(crm);
        return medico;
    }

    public Medico newMedico(Medico newMedico) {
        Medico medico = this.medicoRepository.save(newMedico);
        return medico;
    }

    public Medico update(Medico updatedMedico) {
        Medico medico = this.medicoRepository.save(updatedMedico);
        return medico;
    }

    public void delete(Medico medico) {
        this.medicoRepository.delete(medico);
    }

    public Medico getMedicoByCrmSenha(String crm, String senha) {
        Medico medicoLogado = this.medicoRepository.findByCrmAndSenha(crm, senha);
        return medicoLogado;
    }
}
