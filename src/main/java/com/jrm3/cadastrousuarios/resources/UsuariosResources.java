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

import com.jrm3.cadastrousuarios.domain.Usuario;
import com.jrm3.cadastrousuarios.services.UsuariosServices;

@RestController
@RequestMapping("/usuarios")
public class UsuariosResources {

	@Autowired
	private UsuariosServices usuariosServices;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(usuariosServices.listar());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Usuario usuario){
		usuario = usuariosServices.salvar(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id){
		Usuario usuario = usuariosServices.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
		usuariosServices.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Usuario usuario, @PathVariable("id") Long id){
		usuario.setId(id);
		usuariosServices.atualizar(usuario);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}/cargo/{cargo_id}", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarCargo(@PathVariable("id") Long usuarioId,
			@PathVariable("cargo_id") Long cargoId){
		
		usuariosServices.salvarCargo(usuarioId, cargoId);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}/perfil/{perfil_id}", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarPerfil(@PathVariable("id") Long usuarioId,
			@PathVariable("perfil_id") Long perfilId){
		
		usuariosServices.salvarPerfil(usuarioId, perfilId);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}


}
