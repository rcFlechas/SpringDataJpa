package com.springdata.servicio;

import java.util.List;

import com.springdata.domain.Usuario;

public interface UsuarioServicio {
	public abstract Usuario buscarPorClave(Integer idUsuario);
    public abstract List<Usuario> buscarTodos();
    public abstract Usuario salvar(Usuario usuario);
    public abstract int actualizar(Usuario usuario);    
    public abstract void borrar(Usuario usuario);
    public abstract Usuario entrar(Usuario usuario);
}
