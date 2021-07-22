
package com.hospital.hospital_universitario.models;

import java.util.Date;
import java.util.TimeZone;
//Depois por favor, revisem os tipos das variáveis!
public class SolicitacaoExame {
	
	private int Id;
	private String nomeMedico;
	private String registroMedico;
	//Um possível enum
	private String statusExame;
	private Date dataPedido;
	private Date dataExame;
	//Não tenho certeza desse tipo
	private TimeZone horaExame;
	private String hipoteseDiagnostica;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNomeMedico() {
		return nomeMedico;
	}
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	public String getRegistroMedico() {
		return registroMedico;
	}
	public void setRegistroMedico(String registroMedico) {
		this.registroMedico = registroMedico;
	}
	public String getStatusExame() {
		return statusExame;
	}
	public void setStatusExame(String statusExame) {
		this.statusExame = statusExame;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Date getDataExame() {
		return dataExame;
	}
	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}
	public TimeZone getHoraExame() {
		return horaExame;
	}
	public void setHoraExame(TimeZone horaExame) {
		this.horaExame = horaExame;
	}
	public String getHipoteseDiagnostica() {
		return hipoteseDiagnostica;
	}
	public void setHipoteseDiagnostica(String hipoteseDiagnostica) {
		this.hipoteseDiagnostica = hipoteseDiagnostica;
	}
}
