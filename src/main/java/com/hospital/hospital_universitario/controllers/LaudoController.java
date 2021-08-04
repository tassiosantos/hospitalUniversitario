package com.hospital.hospital_universitario.controllers;

import java.util.List;
import com.hospital.hospital_universitario.services.LaudoService;
import com.hospital.hospital_universitario.models.Laudo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/laudo" )
@CrossOrigin
public class LaudoController{

    private final LaudoService laudoService;

    @Autowired
    public LaudoController(LaudoService laudoService){
        this.laudoService = laudoService;
    }

    @GetMapping(path = "")
    public List<Laudo> getLaudos(){
        return this.laudoService.getLaudos();
    }

    @GetMapping(path = "/{laudoId}")
    public Laudo getLaudoById(@PathVariable("laudoId") int laudoId){
        return this.laudoService.getLaudoById(laudoId); 
    }

    @GetMapping(path = "/{medicoId}")
    public List<Laudo> getLaudoByMedicoId(@PathVariable("medicoId") int medicoId){
        List<Laudo> laudos = this.laudoService.getLaudoByMedicoId(medicoId);
        return laudos;
    }

	@PutMapping(path = "/{laudoId}")
	public Laudo updateLaudo(
        @RequestBody Laudo changedLaudo){
		Laudo laudo = this.laudoService.update(changedLaudo);
		return laudo;
	}

	@PostMapping(path = "/")
	public void addLaudo(@RequestBody Laudo newLaudo){
		this.laudoService.newLaudo(newLaudo);
     }

     @DeleteMapping(path = "/{laudoId}")
         public void addAccount(@RequestBody Laudo deleteLaudo){
         this.laudoService.delete(deleteLaudo);
      }

}
