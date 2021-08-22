package com.hospital.hospital_universitario.controllers;

import java.util.List;
import com.hospital.hospital_universitario.services.PacienteService;
import com.hospital.hospital_universitario.models.Paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(path = "/paciente" )
@CrossOrigin
public class PacienteController{

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }


    @GetMapping("")
    public ModelAndView getPacientes() {
        ModelAndView mv = new ModelAndView("./paciente/Listar_Paciente");
        Iterable<Paciente> pacientes = this.pacienteService.getPacientes();
        mv.addObject("pacientes", pacientes);
        return mv;
    }

    @GetMapping("/cadastrar")
    public String viewCadastar(){
        return "paciente/Cadastrar_paciente";
    }


	@GetMapping(path = "/{pacienteId}")
	public Paciente getPacienteById(@PathVariable("pacienteId") int pacienteId){
		return this.pacienteService.getPacienteById(pacienteId);
	}

    @PutMapping(path = "/{pacienteId}")
	public Paciente updatePaciente(
        @RequestBody Paciente changedPaciente){
		Paciente paciente = this.pacienteService.update(changedPaciente);
		return paciente;
	}

    @PostMapping(path = "/")
	public String addPaciente(Paciente newPaciente){
		this.pacienteService.newPaciente(newPaciente);
        return "paciente/Cadastrar_Paciente";
     }

	// @PostMapping(path = "/laudo")
	// public void addAccount(@RequestBody Account newAccount){
	// 	this.accountService.addAccount(newAccount);
    //  }

    @DeleteMapping(path = "/{pacienteId}")
	public void deletePaciente(
        @PathVariable("pacienteId") int pacienteId){
        Paciente paciente = this.pacienteService.getPacienteById(pacienteId);
		this.pacienteService.delete(paciente);
	}

}
