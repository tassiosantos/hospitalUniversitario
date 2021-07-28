package com.hospital.hospital_universitario.controllers;

import java.util.List;
import com.hospital.hospital_universitario.services.MedicoService;
import com.hospital.hospital_universitario.models.Medico;

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
@RequestMapping(path = "/medico" )
@CrossOrigin
public class MedicoController{

    private final MedicoService medicoService;

    @Autowired
    public MedicoController(MedicoService medicoService){
        this.medicoService = medicoService;
    }

    @GetMapping(path = "")
    public List<Medico> getMedicos(){
        return this.medicoService.getMedicos();
    }


	@PutMapping(path = "/{medicoNumber}")
	public Medico updateMedico(@RequestBody Medico medico, 
                               @PathVariable("medicoNumber") String medicoNumber){
        medico.setId(Integer.parseInt(medicoNumber));                                   
		medico = this.medicoService.update(medico);
        return  medico;
	}

	// @PostMapping(path = "/laudo")
	// public void addAccount(@RequestBody Account newAccount){
	// 	this.accountService.addAccount(newAccount);
    //  }

    //  @DeleteMapping(path = "/laudo")
    //  public void addAccount(@RequestBody Account newAccount){
    //      this.accountService.addAccount(newAccount);
    //   }

}
