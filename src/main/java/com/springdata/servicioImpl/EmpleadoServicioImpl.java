package com.springdata.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdata.domain.Empleado;
import com.springdata.repository.EmpleadoRepository;
import com.springdata.servicio.EmpleadoServicio;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio{

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Transactional(readOnly = true)
	public Empleado buscarPorClave(Integer idEmpleado) {		
		return empleadoRepository.findOne(idEmpleado);
	}

	@Transactional(readOnly = true)
	public List<Empleado> buscarTodos() {
		return empleadoRepository.findAll();
	}

	@Transactional
	public Empleado salvar(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	
	@Transactional
	public int actualizar(Empleado empleado) {
		return empleadoRepository.actualizar(empleado.getDocumentoEmpleado(), empleado.getNombreEmpleado(), empleado.getApellidoEmpleado(), empleado.getTelefonoEmpleado(), empleado.getDireccionEmpleado(), empleado.getFechaIngreso(), empleado.getActivo(), empleado.getIdEmpleado());
	}

	

	@Transactional
	public void borrar(Empleado empleado) {
		empleadoRepository.delete(empleado);
	}
}
