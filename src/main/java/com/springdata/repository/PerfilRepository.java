package com.springdata.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.springdata.domain.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer>{
	@Modifying
	@Query("UPDATE Perfil p set p.nombrePerfil = ?1, p.fechaIngreso = ?2, p.activo = ?3 WHERE p.idPerfil = ?4")
	public int actualizar(@Param("nombrePerfil") String nombrePerfil,
						@Param("fechaIngreso") Timestamp fechaIngreso,
						@Param("activo") Integer activo,
						@Param("idPerfil") Integer idPerfil);

}
