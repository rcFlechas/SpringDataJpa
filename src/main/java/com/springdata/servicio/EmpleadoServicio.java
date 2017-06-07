package com.springdata.servicio;

import java.util.List;

import com.springdata.domain.Empleado;

public interface EmpleadoServicio {
	public abstract Empleado buscarPorClave(Integer idEmpleado);
    public abstract List<Empleado> buscarTodos();    
    public abstract Empleado salvar(Empleado empleado);
    public abstract int actualizar(Empleado empleado);
    public abstract void borrar(Empleado empleado);   
}
