package com.jrm3.cadastrousuarios.services.exceptions;

public class PerfilNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PerfilNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public PerfilNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
