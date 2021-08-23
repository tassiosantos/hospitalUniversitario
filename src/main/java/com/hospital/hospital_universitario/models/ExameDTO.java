package com.hospital.hospital_universitario.models;

public class ExameDTO extends SolicitacaoExame{
    private Medico medico;
    private Paciente paciente;
    
    public ExameDTO(Medico medico, Paciente paciente){
        this.setMedico(medico);
        this.setPaciente(paciente);
    }

    public ExameDTO() {
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }



}

