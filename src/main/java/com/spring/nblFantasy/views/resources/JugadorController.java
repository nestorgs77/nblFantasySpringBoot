package com.spring.nblFantasy.views.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.nblFantasy.Model.Jugador;
import com.spring.nblFantasy.Repository.JugadorRepository;
import com.spring.nblFantasy.Service.JugadorService;
import com.spring.nblFantasy.views.resources.vo.consumingRestFPL.PlayerVO;

@Controller
public class JugadorController {
	@Autowired
     private JugadorService jugador ;
	
	@PostMapping("/addplayer")
    public String addPlayerPost(@ModelAttribute(value ="p") PlayerVO p, Model model) {
              Jugador j = new Jugador();                 
           j.setNombre(p.getNombre());
           j.setApellidos(p.getApellidos());
           j.setApodo(p.getApodo());
           j.setIdfpl(p.getIdfpl());;
		
          int resp =  jugador.saveJugador(j);
           
           if (resp == 0 ) {
        	   
        	 model.addAttribute("myjson", "Player no added ") ; 
        	  return "test" ; 
		}
          
           model.addAttribute("myjson", "Player added ") ;         
           return "redirect:/index" ; 
    }
	
	@GetMapping("/addplayer")
    public String addPlayer(Model model) {
        PlayerVO p = new PlayerVO();    
		
		
        model.addAttribute("p", p);
        return "addplayer" ; 
    }
	
	
	
}
