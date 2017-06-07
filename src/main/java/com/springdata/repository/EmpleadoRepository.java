package com.springdata.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.springdata.domain.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
	@Modifying
	@Query("UPDATE Empleado e set e.documentoEmpleado = ?1, e.nombreEmpleado = ?2, e.apellidoEmpleado = ?3, e.telefonoEmpleado = ?4, e.direccionEmpleado = ?5, e.fechaIngreso = ?6, e.activo = ?7 WHERE e.idEmpleado = ?8")
	public int actualizar(@Param("documentoEmpleado") String documentoEmpleado, 
						@Param("nombreEmpleado") String nombreEmpleado,
						@Param("apellidoEmpleado") String apellidoEmpleado,
						@Param("telefonoEmpleado") String telefonoEmpleado,
						@Param("direccionEmpleado") String direccionEmpleado,						
						@Param("fechaIngreso") Timestamp fechaIngreso,
						@Param("activo") Integer activo,
						@Param("idEmpleado") Integer idEmpleado);
}
