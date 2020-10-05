package com.example.cursospringweb.controller;

import com.example.cursospringweb.models.Usuario;
import com.example.cursospringweb.models.services.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping; //Import del RequestMapping
import org.springframework.web.bind.annotation.RequestMethod; //Import del metodo Request

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app") //Tenemos una ruta de primer nivel. Podemos mapear el controlador.
public class IndexController {

    @Value("${texto.indexController.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexController.perfil.titulo}")
    private String textoPerfil;
    @Value("${texto.indexController.lista.titulo}")
    private String textoListar;

    @GetMapping({"/index","/home",""}) //RequestMappin permite utilizar un metodo HTTP: method=RequestMethod.GET. Existe otra opción llamada: @METODOMapping. value es un parametro por defecto, no es necesario si es el unico que pasa por el metodo.
    public String index(Model model){
        model.addAttribute("titulo",textoIndex);

        return "index";
    }


    @RequestMapping({"/perfil"})
    public String perfil(Model model){
        Usuario usuario = new Usuario();

        usuario.setNombre("Pedrito");
        usuario.setApellido("Jimenez");
        usuario.setEmail("pedritojimenez@hotmail.com");

        model.addAttribute("titulo" , textoPerfil);
        model.addAttribute("usuario",usuario);

        return "perfil";
    }

    @RequestMapping({"/lista"})
    public String listado(Model model){


        model.addAttribute("titulo",textoListar);


        return "lista";
    }

    @ModelAttribute("usuarios") //Con esto transmitimos datos a todas las tablas.
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("José","Teixeira","jose110299@hotmail.com"));
        usuarios.add(new Usuario("Rosa","Teixeira","rosa171273@hotmail.com"));
        usuarios.add(new Usuario("José","Do Nascimento","jath62@hotmail.com"));
    return usuarios;
    }

    //Interacción con MiServicio

    @Autowired
  //  @Qualifier("miServicioSimple") //Con esto escogemos la inyeccion que queramos con el identificador especifico.
    private IServicio servicio;

    @GetMapping({"/index2"})
    public String index2(Model model){
        model.addAttribute("objeto",servicio.operacion());
        return "index2";
    }


}
