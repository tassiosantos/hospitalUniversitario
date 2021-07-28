package com.hospital.hospital_universitario.models;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table
public class MedicosLaudo {
    
    @Id
    private int medicoResidenteId;
    private int medicoDocenteId;
    private int laudoId;

    public MedicosLaudo(int medicoResidenteId, int medicoDocenteId, int laudoId){
        this.medicoResidenteId = medicoResidenteId;
        this.medicoDocenteId = medicoDocenteId;
        this.laudoId = laudoId;
    }

    public int getLaudoId(){
        return this.laudoId;
    }


    public void setLaudoId(int laudoId){
        this.laudoId = laudoId;
    }

    public int getMedicoResidente(){
        return this.medicoResidenteId;
    }

    public void setMedicoResidente(int medicoResidenteId){
        this.medicoResidenteId = medicoResidenteId;
    }

    public int getMedicoDocente(){
        return this.medicoDocenteId;
    }

    public void setMedicoDocente(int medicoDocenteId){
        this.medicoDocenteId = medicoDocenteId;
    }


}
