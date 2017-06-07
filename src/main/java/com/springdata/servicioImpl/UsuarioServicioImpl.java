package com.springdata.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdata.domain.Usuario;
import com.springdata.repository.UsuarioRepository;
import com.springdata.servicio.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional(readOnly = true)
	public Usuario buscarPorClave(Integer idUsuario) {
		return usuarioRepository.findOne(idUsuario);
	}

	@Transactional(readOnly = true)
	public List<Usuario> buscarTodos() {		
		return usuarioRepository.findAll();
	}

	@Transactional
	public Usuario salvar(Usuario usuario) {		
		return usuarioRepository.save(usuario);
	}

	@Transactional
	public int actualizar(Usuario usuario) {
		return usuarioRepository.actualizar(usuario.getUserName(), usuario.getPassword(), usuario.getPerfil(), usuario.getEmpleado(), usuario.getFechaIngreso(), usuario.getActivo(), usuario.getIdUsuario());
	}

	@Transactional
	public void borrar(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	@Transactional(readOnly = true)
	public Usuario entrar(Usuario usuario) {		
		return usuarioRepository.entrar(usuario.getUserName(), usuario.getPassword());
	}
}
