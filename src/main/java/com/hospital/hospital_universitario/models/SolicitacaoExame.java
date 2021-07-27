
package com.hospital.hospital_universitario.models;

import java.util.Date;
import java.util.TimeZone;
//Depois por favor, revisem os tipos das variáveis!
<<<<<<< HEAD

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
=======
public class SolicitacaoExame {
	
	private int Id;
>>>>>>> b1594b08c1be1a7549c22f88d02f758c922485bb
	private String nomeMedico;
	private String registroMedico;
	//Um possível enum
	private String statusExame;
	private Date dataPedido;
	private Date dataExame;
	//Não tenho certeza desse tipo
	private TimeZone horaExame;
	private String hipoteseDiagnostica;
	
<<<<<<< HEAD
	public SolicitacaoExame(){

	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
=======
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
>>>>>>> b1594b08c1be1a7549c22f88d02f758c922485bb
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
