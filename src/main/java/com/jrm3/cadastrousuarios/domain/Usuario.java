package com.jrm3.cadastrousuarios.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "O campo nome é de preenchimento obrigatório!")
	private String nome;

	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "O campo CPF é de preechimento obrigatório!")
	private String cpf;

	@Enumerated(EnumType.STRING)
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "O campo SEXO é de preenchimento obirgatório!")
	private Sexo sexo;

	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "O campo Data de Nascimento é de peencimento obrigatório!")
	private Date dataNascimento;

	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	@JoinColumn(name = "CARGO_ID")
	private Cargo cargo;

	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	@JoinColumn(name = "PERFIL_ID")
	private Perfil perfil;

	@Enumerated(EnumType.STRING)
	@JsonInclude(Include.NON_NULL)
	private StatusRegistro statusRegistro = StatusRegistro.ATIVO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public StatusRegistro getStatusRegistro() {
		return statusRegistro;
	}

	public void setStatusRegistro(StatusRegistro statusRegistro) {
		this.statusRegistro = statusRegistro;
	}


}
