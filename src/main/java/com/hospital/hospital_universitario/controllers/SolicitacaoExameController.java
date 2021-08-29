package com.hospital.hospital_universitario.controllers;

import com.hospital.hospital_universitario.services.SolicitacaoExameService;
import com.hospital.hospital_universitario.models.SolicitacaoExame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping(path = "/exame")
@CrossOrigin
public class SolicitacaoExameController{

    private final SolicitacaoExameService solicitacaoExameService;

    @Autowired
    public SolicitacaoExameController(SolicitacaoExameService solicitacaoExameService){
        this.solicitacaoExameService = solicitacaoExameService;
    }

    @GetMapping("")
    public ModelAndView getMedico() {
        ModelAndView mv = new ModelAndView("./exame/Listar_Exame");
        Iterable<SolicitacaoExame> exame = this.solicitacaoExameService.getSolicitacaoExames();
        mv.addObject("exames", exame);
        return mv;
    }
    
    @GetMapping(path = "/cadastrar")
    public ModelAndView viewCadastar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("./exame/Cadastrar_Exame");
        return mv;
    }

    @GetMapping(path = "/{solicitacaoId}")
	public ModelAndView getExameById(@PathVariable("solicitacaoId") int solicitacaoId){        
        ModelAndView mv = new ModelAndView();
        SolicitacaoExame solicitacao = solicitacaoExameService.getSolicitacaoExameByNumber(solicitacaoId);
        mv.setViewName("./exame/Detalhar_Exame");
        mv.addObject("exame", solicitacao);
        return mv;
	}
		

    @PutMapping(path = "/{solicitacaoNumber}")
	public SolicitacaoExame updateSolicitacaoExame(
        @RequestBody SolicitacaoExame changedSolicitacaoExame){
		SolicitacaoExame solicitacao = this.solicitacaoExameService.update(changedSolicitacaoExame);
		return solicitacao;
	}

    @PostMapping("")
    public ModelAndView saveExame(SolicitacaoExame newSolicitacaoExame){
        ModelAndView mv = new ModelAndView("./exame/Cadastrar_Exame");
        SolicitacaoExame solicitacao = this.solicitacaoExameService.newSolicitacaoExame(newSolicitacaoExame);
        mv.addObject("solicitacao", solicitacao);
        return mv;
    }

    @GetMapping(path = "/delete/{solicitacaoId}")
	public ModelAndView deleteSolicitacao(@PathVariable("solicitacaoId") int solicitacaoId, RedirectAttributes attributes){
        SolicitacaoExame solicitacao = this.solicitacaoExameService.getSolicitacaoExameByNumber(solicitacaoId);
		this.solicitacaoExameService.delete(solicitacao);           
        attributes.addFlashAttribute("mensagem", "Removido com sucesso!");     
        ModelAndView mv = new ModelAndView("./exame/Listar_Exame");
        Iterable<SolicitacaoExame> exame = this.solicitacaoExameService.getSolicitacaoExames();
        mv.addObject("exames", exame);
        return mv;
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
