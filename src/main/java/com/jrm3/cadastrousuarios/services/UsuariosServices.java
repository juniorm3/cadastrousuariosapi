package com.jrm3.cadastrousuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrm3.cadastrousuarios.domain.Usuario;
import com.jrm3.cadastrousuarios.repository.UsuarioRepository;
import com.jrm3.cadastrousuarios.services.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsuariosServices {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	public Usuario buscar(Long id) {
		Usuario usuario = usuarioRepository.findOne(id);

		if (usuario == null) {
			throw new UsuarioNaoEncontradoException("O usuario não pode ser encontrado!");
		}

		return usuario;
	}

	public Usuario salvar(Usuario usuario) {
		usuario.setId(null);
		return usuarioRepository.save(usuario);
	}

	public void deletar(Long id) {
		try {
			usuarioRepository.delete(id);
		} catch (UsuarioNaoEncontradoException e) {
			throw new UsuarioNaoEncontradoException("Usuario não pode ser encontrado!");
		}
	}

	public void atualizar(Usuario usuario) {
		verifiarExistencaia(usuario);
		usuarioRepository.save(usuario);
	}

	private void verifiarExistencaia(Usuario usuario) {
		buscar(usuario.getId());
	}
}
