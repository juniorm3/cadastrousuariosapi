package com.jrm3.cadastrousuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrm3.cadastrousuarios.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
