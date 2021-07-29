package com.hospital.hospital_universitario.controllers;

import java.util.List;
import com.hospital.hospital_universitario.services.SolicitacaoExameService;
import com.hospital.hospital_universitario.models.SolicitacaoExame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/exames" )
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

    @GetMapping(path = "/solicitacaoExame/{solicitacaoNumber}")
	public SolicitacaoExame getSolicitacaoExameByNumber(@PathVariable("solicitacaoNumber") String solicitacaoNumber){
        return this.solicitacaoExameService.getSolicitacaoExameByNumber(solicitacaoNumber);
    }

    @PutMapping(path = "/{solicitacaoNumber}")
	public SolicitacaoExame updateSolicitacaoExame(
        @RequestBody SolicitacaoExame changedSolicitacaoExame){
		SolicitacaoExame solicitacao = this.solicitacaoExameService.update(changedSolicitacaoExame);
		return solicitacao;
	}

    @PostMapping(path = "/")
	public void addSolicitacaoExame(@RequestBody SolicitacaoExame newSolicitacaoExame){
		this.solicitacaoExameService.newMedico(newSolicitacaoExame);
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
