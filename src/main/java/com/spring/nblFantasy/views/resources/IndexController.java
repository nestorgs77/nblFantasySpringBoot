package com.spring.nblFantasy.views.resources;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@Autowired
	private ClassicResource classicRest ;
	
	
	
@GetMapping("/")
	public String Index (Model model) {
   LinkedList listPtos = new LinkedList<>();
   LinkedList numJornada = new LinkedList<>();
	 for (int i = 0 ; i<classicRest.findAllClassic().size(); i++) {
		   listPtos.add(classicRest.findAllClassic().get(i).getPtosJornada());
		   numJornada.add(classicRest.findAllClassic().get(i).getNumJornada());
	 }
	
	model.addAttribute("listClassic", classicRest.findAllClassic());
	model.addAttribute("listPJornada", listPtos);
	model.addAttribute("numJornada", numJornada);
		return "index" ;
	}
	
}
