package com.hospital.hospital_universitario.controllers;

import com.hospital.hospital_universitario.services.MedicoService;
import com.hospital.hospital_universitario.services.PacienteService;
import com.hospital.hospital_universitario.services.SolicitacaoExameService;
import com.hospital.hospital_universitario.models.ExameDTO;
import com.hospital.hospital_universitario.models.Medico;
import com.hospital.hospital_universitario.models.Paciente;
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

    private final PacienteService pacienteService;
    private final SolicitacaoExameService solicitacaoExameService;
    private final MedicoService medicoService;

    @Autowired
    public SolicitacaoExameController(PacienteService pacienteService, SolicitacaoExameService exameService, MedicoService medicoService){
        this.pacienteService = pacienteService;
        this.solicitacaoExameService = exameService;
        this.medicoService = medicoService;
    }

    // @GetMapping("")
    // public ModelAndView getMedico() {
    //     ModelAndView mv = new ModelAndView("./exame/Listar_Exame");
    //     Iterable<SolicitacaoExame> exame = this.solicitacaoExameService.getSolicitacaoExames();
    //     mv.addObject("exames", exame);
    //     return mv;
    // }
    
    @GetMapping(path = "/{medicoId}")
    public ModelAndView getExames(@PathVariable("medicoId") int medicoId) {
        ModelAndView mv = new ModelAndView("./exame/Listar_Exame");
        Medico medico = this.medicoService.getMedicoById(medicoId);
        Iterable<SolicitacaoExame> exames = this.solicitacaoExameService.getSolicitacaoExames();
        mv.addObject("exames", exames);
        mv.addObject("medico", medico);
        return mv;
    }

    @GetMapping(path = "/cadastrar/{medicoId}/{pacienteId}")
    public ModelAndView viewCadastar(@PathVariable("medicoId") int medicoId, @PathVariable("pacienteId") int pacienteId) {
        Medico medico = this.medicoService.getMedicoById(medicoId);
        Paciente paciente = this.pacienteService.getPacienteById(pacienteId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("./exame/Cadastrar_Exame");
        mv.addObject("medico", medico);
        mv.addObject("paciente", paciente);
        return mv;
    }

    @GetMapping(path = "/cadastrar/{medicoId}")
    public ModelAndView viewCadastar(@PathVariable("medicoId") int medicoId) {
        Medico medico = this.medicoService.getMedicoById(medicoId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("./exame/Cadastrar_Exame");
        mv.addObject("medico", medico);
        return mv;
    }

    @GetMapping(path = "/{medicoId}/{pacienteId}/{solicitacaoId}")
	public ModelAndView getExameById(@PathVariable("solicitacaoId") int solicitacaoId, @PathVariable("medicoId") int medicoId, @PathVariable("pacienteId") int pacienteId){        
        ModelAndView mv = new ModelAndView();
        Paciente paciente = pacienteService.getPacienteById(pacienteId);
        Medico medico = this.medicoService.getMedicoById(medicoId);
        SolicitacaoExame solicitacao = solicitacaoExameService.getSolicitacaoExameByNumber(solicitacaoId);
        mv.setViewName("./exame/Detalhar_Exame");
        mv.addObject("paciente", paciente);
        mv.addObject("medico", medico);
        mv.addObject("exame", solicitacao);
        return mv;
	}

    @GetMapping(path = "/{medicoId}/{solicitacaoId}")
	public ModelAndView getExameById(@PathVariable("solicitacaoId") int solicitacaoId, @PathVariable("medicoId") int medicoId){        
        ModelAndView mv = new ModelAndView();
        Medico medico = this.medicoService.getMedicoById(medicoId);
        SolicitacaoExame solicitacao = solicitacaoExameService.getSolicitacaoExameByNumber(solicitacaoId);
        mv.setViewName("./exame/Detalhar_Exame");
        mv.addObject("medico", medico);
        mv.addObject("exame", solicitacao);
        return mv;
	}
		

    @PostMapping(path = "/{id}/{solicitacaoId}")
    public ModelAndView updateSolicitacaoExame(@PathVariable("id") int id, @PathVariable("solicitacaoId") int solicitacaoId, SolicitacaoExame newSolicitacaoExame){
        ModelAndView mv = new ModelAndView("./exame/Detalhar_Exame");
        SolicitacaoExame solicitacao = new SolicitacaoExame();
        Medico usuario = this.medicoService.getMedicoById(id);
        newSolicitacaoExame.setId(solicitacaoId);
        solicitacao = this.solicitacaoExameService.update(newSolicitacaoExame);
        mv.addObject("exame", solicitacao);
        mv.addObject("medico", usuario);
        return mv;
    }

    @PostMapping("/{usuario}")
    public ModelAndView saveMedico(SolicitacaoExame newSolicitacaoExame, @PathVariable("usuario") int usuario){
        ModelAndView mv = new ModelAndView("./exame/Detalhar_Exame");
        SolicitacaoExame solicitacao = this.solicitacaoExameService.newSolicitacaoExame(newSolicitacaoExame);
        Medico medicoUsuario = this.medicoService.getMedicoById(usuario);
        mv.addObject("exame", solicitacao);
        mv.addObject("medico", medicoUsuario);
        return mv;
    }

    @PostMapping("")
    public ModelAndView saveExame(SolicitacaoExame newSolicitacaoExame){
        ModelAndView mv = new ModelAndView();
        SolicitacaoExame solicitacao = this.solicitacaoExameService.newSolicitacaoExame(newSolicitacaoExame);
        Paciente paciente = pacienteService.getPacienteById(solicitacao.getPacienteId());
        Medico medico = this.medicoService.getMedicoByCrm(Integer.toString(solicitacao.getRegistroMedico()));
        Iterable<ExameDTO> examesDto = solicitacaoExameService.getSolicitacaoExameByPacienteId(solicitacao.getPacienteId());
        
        
        mv.setViewName("./exame/Detalhar_Exame");
        mv.addObject("paciente", paciente);
        mv.addObject("medico", medico);
        mv.addObject("exames", examesDto);
        mv.addObject("solicitacao", solicitacao);
        
        return mv;
    }

    @GetMapping(path = "/delete/{medicoId}/{id}")
	public ModelAndView deleteSolicitacao(@PathVariable("medicoId") int medicoId, @PathVariable("id") int id){
        SolicitacaoExame solicitacao = this.solicitacaoExameService.getSolicitacaoExameByNumber(id);
        Medico usuario = this.medicoService.getMedicoById(medicoId);
		this.solicitacaoExameService.delete(solicitacao);           
        ModelAndView mv = new ModelAndView("./exame/Listar_Exame");
        Iterable<SolicitacaoExame> exame = this.solicitacaoExameService.getSolicitacaoExames();
        mv.addObject("exames", exame);
        mv.addObject("medico", usuario);
        return mv;
	}
    
    // @GetMapping(path = "/delete/{medicoId}/{solicitacaoId}")
	// public ModelAndView deleteSolicitacao(@PathVariable("medicoId") int medicoId, @PathVariable("solicitacaoId") int solicitacaoId, RedirectAttributes attributes){
    //     SolicitacaoExame solicitacao = this.solicitacaoExameService.getSolicitacaoExameByNumber(solicitacaoId);
    //     Medico medico = this.medicoService.getMedicoById(medicoId);
	// 	this.solicitacaoExameService.delete(solicitacao);           
    //     attributes.addFlashAttribute("mensagem", "Removido com sucesso!");     
    //     ModelAndView mv = new ModelAndView("./exame/Listar_Exame");
    //     Iterable<SolicitacaoExame> exame = this.solicitacaoExameService.getSolicitacaoExames();
    //     mv.addObject("exames", exame);
    //     mv.addObject("medico", medico);
    //     return mv;
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
