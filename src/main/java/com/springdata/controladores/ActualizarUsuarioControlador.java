package com.springdata.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping(value="/actualizar_usuario.oc")
@Service
public class ActualizarUsuarioControlador {	
	
	@Autowired
	private UsuarioServicioImpl usuarioServicio;
	
	@Autowired
	private PerfilServicio perfilServicio;
	
	@Autowired
	private EmpleadoServicio empleadoServicio;
	
	@RequestMapping(method=RequestMethod.GET)
	public String insertarUsuario(){		
		return "actualizar_usuario";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@Transactional
	public String insertarUsuario(
			@RequestParam("txtId") String txtId,
			@RequestParam("userName") String userName,
			@RequestParam("pass") String password, 
			@RequestParam("perfil") String perfil, 
			@RequestParam("empleado") String empleado,
			@RequestParam("activo") String activo, HttpServletRequest request){
	
		Usuario u = new Usuario();
        if(userName.isEmpty()){
            u = usuarioServicio.buscarPorClave(Integer.parseInt(txtId));
            List<Perfil> listaPerfil = perfilServicio.buscarTodos();
            List<Empleado> listaEmpleado = empleadoServicio.buscarTodos();     

            request.setAttribute("perfil", listaPerfil); 
            request.setAttribute("empleado", listaEmpleado);
            request.setAttribute("usuario", u);
            return "actualizar_usuario";
        }else{
//GENERA UN REGISTRO NUEVO, MAS NO LO MODIFICA            
//            Categoria c = new Categoria();
//            c.setNombreCategoria(idCategoria);
//            Editorial e = new Editorial(); 
//            e.setNombreEditorial(idEditorial);

        	Perfil p = perfilServicio.buscarPorClave(Integer.parseInt(perfil));
    		Empleado e = empleadoServicio.buscarPorClave(Integer.parseInt(empleado));
            
    		u.setIdUsuario(Integer.parseInt(txtId));
    		u.setUserName(userName);
    		u.setPassword(password);
    		u.setPerfil(p);
    		u.setEmpleado(e);
    		u.setActivo(Integer.parseInt(activo));
           
           
            if (usuarioServicio.actualizar(u) > 0) {
                return "exito";
            } else {
                return "login";
            }
		
	}
	}
}
