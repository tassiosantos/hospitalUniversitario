package com.hospital.hospital_universitario.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospital_universitario.models.PacienteLaudo;
import com.hospital.hospital_universitario.repositories.PacienteLaudoRepository;

@Service
public class PacienteLaudoService {
    private final PacienteLaudoRepository pacienteLaudoRepository;

    @Autowired
    public PacienteLaudoService(PacienteLaudoRepository pacienteLaudoRepository){
        this.pacienteLaudoRepository = pacienteLaudoRepository;
    }
    

    public List<PacienteLaudo> getPacienteLaudos(){
        List<PacienteLaudo> pacienteLaudos = this.pacienteLaudoRepository.findAll();
        return pacienteLaudos;
    }

    public void savePacienteLaudo(PacienteLaudo pacienteLaudo){
        this.pacienteLaudoRepository.save(pacienteLaudo);
    }

    public void deletePacienteLaudo(PacienteLaudo pacienteLaudo){
        this.pacienteLaudoRepository.delete(pacienteLaudo);
    }


}


