package com.hospital.hospital_universitario.controllers;

import java.util.List;
import com.hospital.hospital_universitario.services.SolicitacaoExameService;
import com.hospital.hospital_universitario.models.SolicitacaoExame;

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
@RequestMapping(path = "/paciente" )
@CrossOrigin
public class SolicitacaoExameController{

    private final SolicitacaoExameService solicitacaoExameService;

    @Autowired
    public SolicitacaoExameController(SolicitacaoExameService solicitacaoExameService){
        this.solicitacaoExameService = solicitacaoExameService;
    }

    @GetMapping(path = "/all")
    public List<SolicitacaoExame> getSolicitacaoExames(){
        return this.solicitacaoExameService.getSolicitacaoExames();
    }


	// @PutMapping(path = "/paciente/{pacienteNumber}")
	// public Paciente updateLaudo(@PathVariable("pacienteNumber") String pacienteNumber){
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
