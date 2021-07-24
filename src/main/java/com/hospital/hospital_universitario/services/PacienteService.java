package com.hospital.hospital_universitario.services;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospital_universitario.models.Paciente;
import com.hospital.hospital_universitario.repositories.PacienteRepository;


@Service
public class PacienteService {
    
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> getLaudos(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes;
    }
}
