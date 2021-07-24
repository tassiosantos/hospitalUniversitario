package com.hospital.hospital_universitario.services;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospital_universitario.models.Laudo;
import com.hospital.hospital_universitario.repositories.LaudoRepository;


@Service
public class LaudoService {
    
    private final LaudoRepository laudoRepository;

    @Autowired
    public LaudoService(LaudoRepository laudoRepository){
        this.laudoRepository = laudoRepository;
    }

    public List<Laudo> getLaudos(){
        List<Laudo> laudos = laudoRepository.findAll();
        return laudos;
    }
}
