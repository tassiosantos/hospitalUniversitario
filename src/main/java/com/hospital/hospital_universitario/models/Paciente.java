package com.hospital.hospital_universitario.models;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table
public class Paciente {
	
	@Id
    @SequenceGenerator(
        name = "medico_sequence",
        sequenceName = "medico_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "medico_sequence"
    )

	private int id;

	//@NotEmpty(mesage = "Nome não pode estar vazio.")
	private String nome;

	//@NotEmpty(mesage = "Cpf não pode estar vazio")
	private String cpf;

	private String dataNascimento;

	private String sexo;
	
	public Paciente(){

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}
