package com.springdata.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdata.domain.Perfil;
import com.springdata.repository.PerfilRepository;
import com.springdata.servicio.PerfilServicio;

@Service
public class PerfilServicioImpl implements PerfilServicio{
	
	@Autowired
	private PerfilRepository perfilRepository;

	@Transactional(readOnly = true)
	public Perfil buscarPorClave(Integer idPerfil) {
		return perfilRepository.findOne(idPerfil);
	}

	@Transactional(readOnly = true)
	public List<Perfil> buscarTodos() {
		return perfilRepository.findAll();
	}

	@Transactional
	public Perfil salvar(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	@Transactional
	public int actualizar(Perfil perfil) {
		return perfilRepository.actualizar(perfil.getNombrePerfil(), perfil.getFechaIngreso(), perfil.getActivo(), perfil.getIdPerfil());
	}

	@Transactional
	public void borrar(Perfil perfil) {
		perfilRepository.delete(perfil);
	}
}
