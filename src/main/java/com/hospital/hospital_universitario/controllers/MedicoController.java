package com.hospital.hospital_universitario.controllers;

import java.util.List;
import com.hospital.hospital_universitario.services.MedicoService;
import com.hospital.hospital_universitario.models.Medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping(path = "/all")
    public List<Medico> getMedicos(){
        return this.medicoService.getMedicos();
    }


	@GetMapping(path = "/medico/{medicoId}")
	public Medico getMedicoById(@PathVariable("medicoId") int medicoId){
        return this.medicoService.getMedicoById(medicoId);
    }
		
    @PutMapping(path = "/{medicoId}")
	public Medico updateMedico(
        @RequestBody Medico changedMedico){
		Medico medico = this.medicoService.update(changedMedico);
		return medico;
	}

    @PostMapping(path = "/")
	public void addMedico(@RequestBody Medico newMedico){
		this.medicoService.newMedico(newMedico);
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
