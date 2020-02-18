package com.jrm3.cadastrousuarios.domain;

public enum Sexo {
	MASCULINO("Masculino"), FEMININO("Feminino");

	private String descricao;

	private Sexo(String descricao) {
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
