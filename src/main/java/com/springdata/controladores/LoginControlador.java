package com.springdata.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdata.domain.Usuario;
import com.springdata.servicio.UsuarioServicio;

@Controller
@RequestMapping(value="/login.oc")
public class LoginControlador {
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@RequestMapping(method=RequestMethod.GET)
	public String mostrarForm(){		
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String mostrarForm(@RequestParam("userName") String userName, @RequestParam("pass") String password, HttpServletRequest request){
		Usuario usuario = new Usuario();
		usuario.setUserName(userName);
		usuario.setPassword(password);
		
		Usuario u = usuarioServicio.entrar(usuario);
		if(u != null){
			request.setAttribute("usuario", u);
			System.out.println(u);
			return "prueba";
		}else return "login";
	}

}
