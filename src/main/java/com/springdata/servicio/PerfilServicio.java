package com.springdata.servicio;

import java.util.List;

import com.springdata.domain.Perfil;

public interface PerfilServicio {
	public abstract Perfil buscarPorClave(Integer idPerfil);
    public abstract List<Perfil> buscarTodos();
    public abstract Perfil salvar(Perfil perfil);
    public abstract int actualizar(Perfil perfil);   
    public abstract void borrar(Perfil perfil);
}
