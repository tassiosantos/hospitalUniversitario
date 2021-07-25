package com.hospital.hospital_universitario.controllers;

import java.util.List;
import com.hospital.hospital_universitario.services.MedicoService;
import com.hospital.hospital_universitario.models.Medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
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


	// @PutMapping(path = "/medico/{medicoNumber}")
	// public Laudo updateMedico(@PathVariable("medicoNumber") String medicoNumber){
	// 	//Laudo laudo = this.laudoService.update(laudoNumber);
	// 	//return laudo;
    //     return null;
	// }

	// @PostMapping(path = "/laudo")
	// public void addAccount(@RequestBody Account newAccount){
	// 	this.accountService.addAccount(newAccount);
    //  }

    //  @DeleteMapping(path = "/laudo")
    //  public void addAccount(@RequestBody Account newAccount){
    //      this.accountService.addAccount(newAccount);
    //   }

}
