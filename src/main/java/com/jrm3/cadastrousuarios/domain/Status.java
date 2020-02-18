package com.jrm3.cadastrousuarios.domain;

public enum Status {

	ATIVO("Ativo"), INATIVO("Inativo");

	private String descricao;

	private Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
