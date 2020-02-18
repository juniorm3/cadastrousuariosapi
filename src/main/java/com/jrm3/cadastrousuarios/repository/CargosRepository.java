package com.jrm3.cadastrousuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrm3.cadastrousuarios.domain.Cargo;

public interface CargosRepository extends JpaRepository<Cargo, Long> {

}
