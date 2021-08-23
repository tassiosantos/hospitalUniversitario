package com.hospital.hospital_universitario.controllers;

import com.hospital.hospital_universitario.services.PacienteService;
import com.hospital.hospital_universitario.services.SolicitacaoExameService;
import com.hospital.hospital_universitario.models.ExameDTO;
import com.hospital.hospital_universitario.models.Paciente;
import com.hospital.hospital_universitario.models.SolicitacaoExame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(path = "/paciente" )
@CrossOrigin
public class PacienteController{

    private final PacienteService pacienteService;
    private final SolicitacaoExameService exameService;

    @Autowired
    public PacienteController(PacienteService pacienteService, SolicitacaoExameService exameService){
        this.pacienteService = pacienteService;
        this.exameService = exameService;
    }


    @GetMapping("")
    public ModelAndView getPacientes() {
        ModelAndView mv = new ModelAndView("./paciente/Listar_Paciente");
        Iterable<Paciente> pacientes = this.pacienteService.getPacientes();
        mv.addObject("pacientes", pacientes);
        return mv;
    }

    @GetMapping(path = "/cadastrar")
    public ModelAndView viewCadastar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("./paciente/Cadastrar_Paciente");
        return mv;
        //return "paciente/Cadastrar_Paciente";
    }


	@GetMapping(path = "/{pacienteId}")
	public ModelAndView getPacienteById(@PathVariable("pacienteId") int pacienteId){
        ModelAndView mv = new ModelAndView();
        Paciente paciente = pacienteService.getPacienteById(pacienteId);
        Iterable<ExameDTO> examesDto = exameService.getSolicitacaoExameByPacienteId(pacienteId);
        mv.setViewName("./paciente/Detalhar_Paciente");
        mv.addObject("paciente", paciente);
        mv.addObject("exames", examesDto);
        return mv;
	}

    // @PutMapping(path = "/{pacienteId}")
	// public Paciente updatePaciente(
    //     @RequestBody Paciente changedPaciente){
	// 	Paciente paciente = this.pacienteService.update(changedPaciente);
	// 	return paciente;
	// }

    @PostMapping("")
    public ModelAndView savePaciente(Paciente newPaciente){
        ModelAndView mv = new ModelAndView("./paciente/Detalhar_Paciente");
        Paciente paciente = this.pacienteService.newPaciente(newPaciente);
        mv.addObject("paciente", paciente);
        return mv;

    }


    @PostMapping(path = "/{pacienteId}")
    public ModelAndView updatePaciente(@PathVariable("pacienteId") int pacienteId, @RequestBody Paciente newPaciente){
        ModelAndView mv = new ModelAndView("./paciente/Detalhar_Paciente");
        Paciente paciente = new Paciente();
        newPaciente.setId(pacienteId);
        paciente = this.pacienteService.update(newPaciente);

        mv.addObject("paciente", paciente);
        return mv;

    }
 
    @GetMapping(path = "/delete/{pacienteId}")
	public String deletePaciente(
        @PathVariable("pacienteId") int pacienteId){
        Paciente paciente = this.pacienteService.getPacienteById(pacienteId);
		this.pacienteService.delete(paciente);
        return "redirect:/paciente";

	}

}
