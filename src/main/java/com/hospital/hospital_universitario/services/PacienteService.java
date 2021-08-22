package com.hospital.hospital_universitario.services;

import java.util.List;
// import java.util.ArrayList;
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

    public List<Paciente> getPacientes(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes;
    }

    public Paciente getPacienteById(int pacienteId){
        Paciente paciente = pacienteRepository.findById(pacienteId);
        return paciente;
    }

    public Paciente newPaciente(Paciente newPaciente) {
        Paciente paciente = this.pacienteRepository.save(newPaciente);
        return paciente;
    }

    public Paciente update(Paciente updatedPaciente) {
        Paciente paciente = this.pacienteRepository.save(updatedPaciente);
        return paciente;
    }

    public void delete(Paciente paciente) {
        this.pacienteRepository.delete(paciente);
    }
}
