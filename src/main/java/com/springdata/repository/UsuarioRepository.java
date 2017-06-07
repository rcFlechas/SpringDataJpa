package com.springdata.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springdata.domain.Empleado;
import com.springdata.domain.Perfil;
import com.springdata.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("from Usuario u where u.userName = ?1 AND u.password = ?2")
	public Usuario entrar(@Param("userName") String userName, @Param("password") String password);
	
	@Modifying
	@Query("UPDATE Usuario u set u.userName = ?1, u.password = ?2, u.perfil = ?3, u.empleado = ?4, u.fechaIngreso = ?5, u.activo = ?6 WHERE u.idUsuario = ?7")
	public int actualizar(@Param("userName") String userName, 
						@Param("password") String password,
						@Param("perfil") Perfil perfil,
						@Param("empleado") Empleado empleado,
						@Param("fechaIngreso") Timestamp fechaIngreso,
						@Param("activo") Integer activo,
						@Param("idUsuario") Integer idUsuario);
}
