package com.jrm3.cadastrousuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrm3.cadastrousuarios.domain.Perfil;
import com.jrm3.cadastrousuarios.repository.PerfilRepository;
import com.jrm3.cadastrousuarios.services.exceptions.PerfilNaoEncontradoException;

@Service
public class PerfilServices {

	@Autowired
	private PerfilRepository perfilRepository;
	
	public List<Perfil> listar() {
		return perfilRepository.findAll();
	}

	public Perfil buscar(Long id) {
		Perfil perfil = perfilRepository.findOne(id);
		
		if(perfil == null) {
			throw new PerfilNaoEncontradoException("O perfil não pose der encontrado!");
		}
		
		return perfil;
	}
	
	public Perfil salvar(Perfil perfil) {	
		perfil.setId(null);
		return perfilRepository.save(perfil);
	}

	public void atualizar(Perfil perfil) {
		verificarExistencia(perfil);
		perfilRepository.save(perfil);		
	}

	public void deletar(Long id) {
		try {
			buscar(id);
			perfilRepository.delete(id);
		} catch (PerfilNaoEncontradoException e) {
			throw new PerfilNaoEncontradoException("Pefil não pode ser encontrado!");
		}
		
	}
	
	private void verificarExistencia(Perfil perfil) {
		buscar(perfil.getId());		
	}



}
