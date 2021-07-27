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

    public Medico getMedicoByNumber(String medicoNumber){
        Medico medico = medicoRepository.findById(Integer.parseInt(medicoNumber));
        return medico;
    }

    public void newLaudo(Medico newMedico) {
        this.medicoRepository.save(newMedico);
    }

    public Medico update(Medico updatedMedico) {
        Medico medico = this.medicoRepository.save(updatedMedico);
        return medico;
    }
}
