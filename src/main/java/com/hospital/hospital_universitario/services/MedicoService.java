package com.hospital.hospital_universitario.services;

import java.util.List;
// import java.util.ArrayList;
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
}
