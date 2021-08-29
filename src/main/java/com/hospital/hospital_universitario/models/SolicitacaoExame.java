
package com.hospital.hospital_universitario.models;

//Depois por favor, revisem os tipos das variáveis!

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table
public class SolicitacaoExame {
	
	@Id
    @SequenceGenerator(
        name = "solicitacaoExame_sequence",
        sequenceName = "solicitacaoExame_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "solicitacaoExame_sequence"
    )

	private int id;

	private int registroMedico;
	
	private int pacienteId;
	
	//Um possível enum
	private String statusExame;

	private String dataPedido;
	private String dataExame;

	//Não tenho certeza desse tipo
	private String horaExame;
	private String hipoteseDiagnostica;
	
	public SolicitacaoExame(){

	}
	
	public int getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRegistroMedico() {
		return registroMedico;
	}
	public void setRegistroMedico(int registroMedico) {
		this.registroMedico = registroMedico;
	}

	
	public String getStatusExame() {
		return statusExame;
	}
	public void setStatusExame(String statusExame) {
		this.statusExame = statusExame;
	}
	public String getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	public String getDataExame() {
		return dataExame;
	}
	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}
	public String getHoraExame() {
		return horaExame;
	}
	public void setHoraExame(String horaExame) {
		this.horaExame = horaExame;
	}
	public String getHipoteseDiagnostica() {
		return hipoteseDiagnostica;
	}
	public void setHipoteseDiagnostica(String hipoteseDiagnostica) {
		this.hipoteseDiagnostica = hipoteseDiagnostica;
	}
}
