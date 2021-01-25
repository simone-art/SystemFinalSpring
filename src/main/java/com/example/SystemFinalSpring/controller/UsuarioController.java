package com.example.SystemFinalSpring.controller;

import com.example.SystemFinalSpring.entity.Usuario;
import com.example.SystemFinalSpring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository ur;

    @RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.GET)
    public String form() {
        return "usuario/formUsuario";
    }

    @RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
    public String form(@Valid Usuario usuario) {
        ur.save(usuario);
        return "redirect:/cadastrarUsuario";
    }


    @RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
    public String form(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
      if (result.hasErrors()) {
    attributes.addFlashAttribute("mensagem", "Verifique os campos!");
    return "redirect:/cadastrarUsuario";
     } else{
      ur.save(usuario);
      attributes.addFlashAttribute("mensagem", "Cadastro feito com sucesso!");
      return "redirect:/cadastrarUsuario";
     }
    }


    @RequestMapping("/usuarios")
    public ModelAndView ListaUsuarios(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Usuario>Usuarios = ur.findAll();
        mv.addObject("usuarios", Usuarios);
        return mv;
    }
}
