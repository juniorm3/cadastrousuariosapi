package com.jrm3.cadastrousuarios.services.exceptions;

public class UsuarioExistenteException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UsuarioExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
