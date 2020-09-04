package com.spring.nblFantasy.views.resources;


import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.spring.nblFantasy.Model.Classic;
import com.spring.nblFantasy.Service.FPLApi;

@Controller
public class IndexController {
	@Autowired
	private ClassicResource classicRest ;
	@Autowired
	RestTemplate restTemplate ;
	@Autowired
	private FPLApi fplApi ;
@GetMapping("/index")
	public String Index (Model model) {
     List<Classic> listaClassic = classicRest.findAllClassic();
     List<Integer>listPtos = new LinkedList<>();
	
	for (int i = 0; i < listaClassic.size(); i++) {
		listPtos.add(listaClassic.get(i).getTotal_points());
	}
	
	
	
	
	model.addAttribute("listClassic", listaClassic);
	model.addAttribute("listPJornada", listPtos);
	
		return "index" ;
	}

@PostMapping("/index")
public String createIndex (@RequestParam(value = "idplayer", required = true) String idplayer , Model model){
	
	
	
	model.addAttribute("myjson", idplayer);
	return "classic" ;

}





@GetMapping("/rest")
public String getForObjectOperation(Model model) throws Exception{
      
	
model.addAttribute("myjson", fplApi.listOfPlayerbyGW(1, 54078));
return "classic" ;
	


}

}
