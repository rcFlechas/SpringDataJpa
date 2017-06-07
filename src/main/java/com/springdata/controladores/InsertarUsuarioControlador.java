package com.springdata.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdata.domain.Empleado;
import com.springdata.domain.Perfil;
import com.springdata.domain.Usuario;
import com.springdata.servicio.EmpleadoServicio;
import com.springdata.servicio.PerfilServicio;
import com.springdata.servicioImpl.UsuarioServicioImpl;

@Controller
@RequestMapping(value="/insertar_usuario.oc")
@Service
public class InsertarUsuarioControlador {

	@Autowired
	private UsuarioServicioImpl usuarioServicio;
	
	@Autowired
	private PerfilServicio perfilServicio;
	
	@Autowired
	private EmpleadoServicio empleadoServicio;
	
	@RequestMapping(method=RequestMethod.GET)
	public String insertarUsuario(){		
		return "insertar_usuario";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@Transactional
	public String insertarUsuario(@RequestParam("userName") String userName,
			@RequestParam("pass") String password, 
			@RequestParam("perfil") String perfil, 
			@RequestParam("empleado") String empleado, ModelMap model){
		
		Perfil p = perfilServicio.buscarPorClave(Integer.parseInt(perfil));
		Empleado e = empleadoServicio.buscarPorClave(Integer.parseInt(empleado));
		
		System.out.println(p.getNombrePerfil());
        System.out.println(e.getNombreEmpleado()); 
		
		Usuario usuario = new Usuario();
		usuario.setUserName(userName);
		usuario.setPassword(password);
		usuario.setPerfil(p);
		usuario.setEmpleado(e);
		
		if(usuarioServicio.salvar(usuario) != null){			
			return "exito";
		}else return "login";
	}
}
