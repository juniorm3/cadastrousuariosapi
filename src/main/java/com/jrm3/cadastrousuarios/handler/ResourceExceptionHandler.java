package com.jrm3.cadastrousuarios.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jrm3.cadastrousuarios.domain.DetalhesErro;
import com.jrm3.cadastrousuarios.services.exceptions.CargoNaoEncontradoException;
import com.jrm3.cadastrousuarios.services.exceptions.PerfilNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(CargoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlerCargoNaoEncontradoException
		(CargoNaoEncontradoException e, HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404L);
		erro.setDescricao("O Cargo não pode ser encontrado!");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(PerfilNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlerPerfilNaoEncontradoException
	(PerfilNaoEncontradoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404L);
		erro.setDescricao("O Perfil não pode ser encontrado!");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
