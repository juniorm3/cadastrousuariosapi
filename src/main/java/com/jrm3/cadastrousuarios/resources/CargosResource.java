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

import com.jrm3.cadastrousuarios.domain.Cargo;
import com.jrm3.cadastrousuarios.services.CargosServices;

@RestController
@RequestMapping("/cargos")
public class CargosResource {

	@Autowired
	private CargosServices cargosServices;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cargo>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(cargosServices.listar());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Cargo cargo) {
		cargo = cargosServices.salvar(cargo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cargo.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Cargo cargo = cargosServices.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(cargo);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Cargo cargo, @PathVariable("id") Long id) {
		cargo.setId(id);
		cargosServices.atualizar(cargo);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		cargosServices.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
