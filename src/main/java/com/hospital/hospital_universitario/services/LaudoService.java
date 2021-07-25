package com.hospital.hospital_universitario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospital_universitario.models.Laudo;
import com.hospital.hospital_universitario.repositories.LaudoRepository;


@Service
public class LaudoService {
    
    private final LaudoRepository laudoRepository;
    //private final MedicoService medicoService;

    @Autowired
    public LaudoService(LaudoRepository laudoRepository){
        this.laudoRepository = laudoRepository;
    }

    public List<Laudo> getLaudos(){
        List<Laudo> laudos = laudoRepository.findAll();
        return laudos;
    }

    public Laudo getLaudoByNumber(String laudoNumber){
        Laudo laudo = laudoRepository.findById(Integer.parseInt(laudoNumber));
        return laudo;
    }

    public void newLaudo(Laudo newLaudo) {
        this.laudoRepository.save(newLaudo);
    }

    public Laudo update(Laudo updatedLaudo) {
        Laudo laudo = this.laudoRepository.save(updatedLaudo);
        return laudo;
    }

    // public List<Laudo> getLaudoByMedicoNumber(String medicoNumber){
    //     List<Laudo> laudos = laudoRepository.findByPacienteConectado(Integer.parseInt(medicoNumber));
     //    List<Srting> nomeMedicos = new List<String>();
    //      for(laudo: laudos){
        //     int medico = medicoService.getByMedicoNumber(Integer.parseInt(laudo.residenteConectado));
        //     nomeMedicos.add(medico.nome);    
        // }
    //     return nomeMedicos;
    // }
        

}
