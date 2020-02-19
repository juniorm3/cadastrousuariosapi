package com.jrm3.cadastrousuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrm3.cadastrousuarios.domain.Cargo;
import com.jrm3.cadastrousuarios.repository.CargosRepository;
import com.jrm3.cadastrousuarios.services.exceptions.CargoNaoEncontradoException;

@Service
public class CargosServices {

	@Autowired
	private CargosRepository cargosRepository;

	public List<Cargo> listar() {
		return cargosRepository.findAll();
	}

	public Cargo buscar(Long id) {
		Cargo cargo = cargosRepository.findOne(id);
		
		if(cargo == null) {
			throw new CargoNaoEncontradoException("O cargo não pode ser encontrado!");
		}
		
		return cargo;
	}

	public Cargo salvar(Cargo cargo) {
		cargo.setId(null);
		return cargosRepository.save(cargo);
	}
	
	public void atualizar(Cargo cargo) {
		verificarExistencia(cargo);
		cargosRepository.save(cargo);
	}
	
	public void deletar(Long id) {
		try {
			cargosRepository.delete(id);	
		} catch (CargoNaoEncontradoException e) {
			throw new CargoNaoEncontradoException("Cargo não pode ser encontrado!");
		}
	}

	private void verificarExistencia(Cargo cargo) {
		buscar(cargo.getId());		
	}

}
