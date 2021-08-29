package com.hospital.hospital_universitario.controllers;

import com.hospital.hospital_universitario.services.MedicoService;
import com.hospital.hospital_universitario.services.PacienteService;
import com.hospital.hospital_universitario.services.SolicitacaoExameService;

import javax.websocket.server.PathParam;

import com.hospital.hospital_universitario.models.ExameDTO;
import com.hospital.hospital_universitario.models.Medico;
import com.hospital.hospital_universitario.models.Paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping(path = "/paciente" )
@CrossOrigin
public class PacienteController{

    private final PacienteService pacienteService;
    private final SolicitacaoExameService exameService;
    private final MedicoService medicoService;

    @Autowired
    public PacienteController(PacienteService pacienteService, SolicitacaoExameService exameService, MedicoService medicoService){
        this.pacienteService = pacienteService;
        this.exameService = exameService;
        this.medicoService = medicoService;
    }


    // @GetMapping("")
    // public ModelAndView getPacientes() {
    //     ModelAndView mv = new ModelAndView("./paciente/Listar_Paciente");
    //     Iterable<Paciente> pacientes = this.pacienteService.getPacientes();
    //     mv.addObject("pacientes", pacientes);
    //     return mv;
    // }

    @GetMapping(path = "/{medicoId}")
    public ModelAndView getPacientes(@PathVariable int medicoId) {
        ModelAndView mv = new ModelAndView("./paciente/Listar_Paciente");
        Medico medico = this.medicoService.getMedicoById(medicoId);
        System.out.println(medico.getCpf());
        Iterable<Paciente> pacientes = this.pacienteService.getPacientes();
        mv.addObject("pacientes", pacientes);
        mv.addObject("medico", medico);
        return mv;
    }

    @GetMapping(path = "/cadastrar")
    public ModelAndView viewCadastar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("./paciente/Cadastrar_Paciente");
        return mv;        
    }


	// @GetMapping(path = "/{pacienteId}")
	// public ModelAndView getPacienteById(@PathVariable("pacienteId") int pacienteId){
    //     ModelAndView mv = new ModelAndView();
    //     Paciente paciente = pacienteService.getPacienteById(pacienteId);
    //     Iterable<ExameDTO> examesDto = exameService.getSolicitacaoExameByPacienteId(pacienteId);
    //     mv.setViewName("./paciente/Detalhar_Paciente");
    //     mv.addObject("paciente", paciente);
    //     mv.addObject("exames", examesDto);
    //     return mv;
	// }

    @GetMapping(path = "/{medicoId}/{pacienteId}")
	public ModelAndView getPacienteById(@PathVariable("pacienteId") int pacienteId, @PathVariable("medicoId") int medicoId){
        ModelAndView mv = new ModelAndView();
        Paciente paciente = pacienteService.getPacienteById(pacienteId);
        Medico medico = this.medicoService.getMedicoById(medicoId);
        Iterable<ExameDTO> examesDto = exameService.getSolicitacaoExameByPacienteId(pacienteId);
        mv.setViewName("./paciente/Detalhar_Paciente");
        mv.addObject("paciente", paciente);
        mv.addObject("exames", examesDto);
        mv.addObject("medico", medico);
        return mv;
	}


	

    @PostMapping("")
    public ModelAndView savePaciente(Paciente newPaciente){
        ModelAndView mv = new ModelAndView("./paciente/Detalhar_Paciente");
        Paciente paciente = this.pacienteService.newPaciente(newPaciente);
        mv.addObject("paciente", paciente);          
        return mv;
    }

    @PostMapping(path = "/{medicoId}/{pacienteId}")
    public ModelAndView updatePaciente(@PathVariable("pacienteId") int pacienteId, @PathVariable("medicoId") int medicoId, @RequestBody Paciente newPaciente){
        ModelAndView mv = new ModelAndView();
        Paciente paciente = new Paciente();
        Iterable<ExameDTO> examesDto = exameService.getSolicitacaoExameByPacienteId(pacienteId);
        newPaciente.setId(pacienteId);
        paciente = this.pacienteService.update(newPaciente);
        mv.setViewName("./paciente/Detalhar_Paciente");
        mv.addObject("paciente", paciente);
        mv.addObject("exames", examesDto);
        return mv;

    }
 
    @GetMapping(path = "/delete/{pacienteId}")
	public String deletePaciente(
        @PathVariable("pacienteId") int pacienteId, RedirectAttributes attributes){
        Paciente paciente = this.pacienteService.getPacienteById(pacienteId);
		this.pacienteService.delete(paciente);
        attributes.addFlashAttribute("mensagem", "Removido com sucesso!");      
        return "redirect:/paciente";
	}

}
