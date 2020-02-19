package com.jrm3.cadastrousuarios.services.exceptions;

public class CargoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CargoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public CargoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
