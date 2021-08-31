package com.hospital.hospital_universitario.controllers;

import java.util.List;
import com.hospital.hospital_universitario.services.LaudoService;
import com.hospital.hospital_universitario.services.MedicoService;
import com.hospital.hospital_universitario.models.Laudo;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping(path = "/laudo" )
@CrossOrigin
public class LaudoController{

    private final LaudoService laudoService;
    private final MedicoService medicoService;

    @Autowired
    public LaudoController(LaudoService laudoService, MedicoService medicoService){
        this.laudoService = laudoService;
        this.medicoService = medicoService;
    }
   
    // @GetMapping("")
    // public ModelAndView getLaudo() {
    //     ModelAndView mv = new ModelAndView("./laudo/Listar_Laudo");
    //     Iterable<Laudo> laudos = this.laudoService.getLaudos();
    //     mv.addObject("laudos", laudos);
    //     return mv;
    // }

    @GetMapping(path = "/{medicoId}")
    public ModelAndView getLaudos(@PathVariable int medicoId) {
        ModelAndView mv = new ModelAndView("./laudo/Listar_Laudo");
        Medico medico = this.medicoService.getMedicoById(medicoId);
        Iterable<Laudo> laudos = this.laudoService.getLaudos();
        mv.addObject("laudos", laudos);
        mv.addObject("medico", medico);
        return mv;
    }

    @GetMapping(path = "/cadastrar/{medicoId}")
    public ModelAndView viewCadastar(@PathVariable("medicoId") int medicoId) {
        ModelAndView mv = new ModelAndView();
        Medico usuario = this.medicoService.getMedicoById(medicoId);
        mv.setViewName("./laudo/Cadastrar_Laudo");
        mv.addObject("medico", usuario);
        return mv;
    }

    @GetMapping(path = "/medico/{medicoId}")
    public List<Laudo> getLaudoByMedicoId(@PathVariable("medicoId") int medicoId){
        List<Laudo> laudos = this.laudoService.getLaudoByMedicoId(medicoId);
        return laudos;
    }

    @GetMapping(path = "/detalhar/{medicoId}/{laudoId}")
	public ModelAndView getLaudoById(@PathVariable("medicoId") int medicoId, @PathVariable("laudoId") int laudoId){        
        ModelAndView mv = new ModelAndView();
        Laudo laudo = laudoService.getLaudoById(laudoId);
        Medico usuario = this.medicoService.getMedicoById(medicoId);
        mv.setViewName("./laudo/Detalhar_Laudo");
        mv.addObject("laudo", laudo);
        mv.addObject("medico", usuario);
        return mv;
	}

	@PutMapping(path = "/{laudoId}")
	public Laudo updateLaudo(
        @RequestBody Laudo changedLaudo){
		Laudo laudo = this.laudoService.update(changedLaudo);
		return laudo;
	}

	@PostMapping("/cadastrar/{medicoId}")
    public ModelAndView saveLaudo(Laudo newLaudo, @PathVariable("medicoId") int medicoId){
        ModelAndView mv = new ModelAndView("./laudo/Detalhar_Laudo");
        Medico usuario = this.medicoService.getMedicoById(medicoId);
        Laudo laudo = this.laudoService.newLaudo(newLaudo);
        mv.addObject("medicos", laudo);
        mv.addObject("medico", usuario);
        return mv;
    }

    @GetMapping(path = "/delete/{laudoId}")
	public ModelAndView deleteMedico(
        @PathVariable("laudoId") int laudoId, RedirectAttributes attributes){
        Laudo laudo = this.laudoService.getLaudoById(laudoId);
		this.laudoService.delete(laudo);
        attributes.addFlashAttribute("mensagem", "Removido com sucesso!");     
        ModelAndView mv = new ModelAndView("./laudo/Listar_Laudo");
        Iterable<Laudo> laudos = this.laudoService.getLaudos();
        mv.addObject("laudos", laudos);
        return mv;
	}

}
