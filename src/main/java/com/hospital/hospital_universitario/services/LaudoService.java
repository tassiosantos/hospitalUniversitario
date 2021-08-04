package com.hospital.hospital_universitario.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospital_universitario.models.Laudo;
import com.hospital.hospital_universitario.models.Medico;
import com.hospital.hospital_universitario.repositories.LaudoRepository;
import com.hospital.hospital_universitario.repositories.MedicoRepository;

import com.hospital.hospital_universitario.services.MedicoService;

@Service
public class LaudoService {
    
    private final LaudoRepository laudoRepository;
    private final MedicoService medicoService;

    @Autowired
    public LaudoService(LaudoRepository laudoRepository, MedicoService medicoService){
        this.laudoRepository = laudoRepository;
        this.medicoService = medicoService;
    }

    public List<Laudo> getLaudos(){
        List<Laudo> laudos = laudoRepository.findAll();
        return laudos;
    }

    public Laudo getLaudoById(int laudoId){
        Laudo laudo = laudoRepository.findById(laudoId);
        return laudo;
    }

    public List<Laudo> getLaudoByPacienteId(int pacienteId){
        List <Laudo> laudos = laudoRepository.findByPacienteId(pacienteId);
        return laudos;
    }

    public List<Laudo> getLaudoByMedicoId(int medicoId){
        List<Laudo> laudos = new ArrayList<Laudo>();
        Medico medico = this.medicoService.getMedicoById(medicoId);
        if(medico.getTitulacao().equalsIgnoreCase("DOCENTE")){
            laudos = laudoRepository.findByDocenteId(medicoId);
        }
        else{
            laudos = laudoRepository.findByResidenteId(medicoId);
        }

        return laudos;
    }

    
    public void newLaudo(Laudo newLaudo) {
        this.laudoRepository.save(newLaudo);
    }

    public Laudo update(Laudo updateLaudo) {
        Laudo laudo = this.laudoRepository.save(updateLaudo);
        return laudo;
    }

    public void delete(Laudo deleteLaudo) {
        this.laudoRepository.delete(deleteLaudo);
    }
        

}
