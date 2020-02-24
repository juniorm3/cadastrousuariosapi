package com.jrm3.cadastrousuarios.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jrm3.cadastrousuarios.domain.Perfil;
import com.jrm3.cadastrousuarios.services.PerfilServices;

@RestController
@RequestMapping("/perfis")
public class PerfilResource {
	
	@Autowired
	private PerfilServices perfilServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Perfil>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(perfilServices.listar());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Perfil perfil) {
		perfil = perfilServices.salvar(perfil);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(perfil.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Perfil Perfil = perfilServices.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(Perfil);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Perfil perfil, @PathVariable("id") Long id) {
		perfil.setId(id);
		perfilServices.atualizar(perfil);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		perfilServices.deletar(id);
		return ResponseEntity.noContent().build();
	}


}
