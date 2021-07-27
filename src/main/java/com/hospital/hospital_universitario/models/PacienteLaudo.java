package com.hospital.hospital_universitario.models;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table
public class PacienteLaudo {
	
	@Id

	private int pacienteId;
	private int laudoId;
	
	
	public PacienteLaudo(){

	}


	public int getLaudoId() {
        return this.laudoId;
    }

    public void setLaudoId(int laudoId) {
        this.laudoId = laudoId;
    }

    public int getPacienteId() {
		return this.pacienteId;
	}
	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;

	}

	
	
}