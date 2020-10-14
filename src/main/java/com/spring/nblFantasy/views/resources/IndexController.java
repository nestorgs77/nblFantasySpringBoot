package com.spring.nblFantasy.views.resources;


import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.spring.nblFantasy.Model.Classic;
import com.spring.nblFantasy.Model.DraftSquad;
import com.spring.nblFantasy.Model.Jugador;
import com.spring.nblFantasy.Service.DraftService;
import com.spring.nblFantasy.Service.DraftSquadServices;
import com.spring.nblFantasy.Service.FPLApi;
import com.spring.nblFantasy.Service.JugadorService;
import com.spring.nblFantasy.views.resources.vo.consumingRestFPL.ClassicRestApiStats;
import com.spring.nblFantasy.views.resources.vo.consumingRestFPL.DraftRestApiStats;
import com.spring.nblFantasy.views.resources.vo.consumingRestFPL.DraftSquadListVO;

@Controller
public class IndexController {
	
	@Autowired
	FPLApi fplapi ;
	@Autowired
	private ClassicResource classicRest ;
	@Autowired
	RestTemplate restTemplate ;
	@Autowired
	JugadorService jugadorservice ; 
	
	@Autowired
	private FPLApi fplApi ;
	
	@Autowired
	private DraftSquadServices  draftSquadservice;
	
	@Autowired
	private DraftService draftService ;
	
@GetMapping("/index")
	public String Index (Model model) throws Exception {
    
	
	
	try {
		DraftRestApiStats statsdraft = new DraftRestApiStats();
		 List<DraftSquadListVO> listSquadVO = new LinkedList<DraftSquadListVO>();
        List<DraftSquad> listSquad = new LinkedList<DraftSquad>();
		List<Jugador> players = new LinkedList<>();
		List<Classic> listaClassic = classicRest.findAllClassic();
	     List<Integer>listPtos = new LinkedList<>();
		 List<ClassicRestApiStats> listStatsbyUser = new LinkedList<ClassicRestApiStats>();
		 List<ClassicRestApiStats> listStatsbyDraftSquad = new LinkedList<ClassicRestApiStats>();
		 List<DraftRestApiStats> listRestApiDraft = new LinkedList<DraftRestApiStats>();
		 
		 players = jugadorservice.listAllJugador();
	     
	     
	     listSquad = draftSquadservice.listAllDraftSquad();
	     
	     
	     
	     
	     
	     
		 for (int i = 0; i < players.size(); i++) {
			listRestApiDraft.add(draftService.finalListDraftStats(players.get(i).getIdfpl()));
			
			
			listRestApiDraft.get(i).setApodo(players.get(i).getApodo());
			// System.out.println(players.get(i).getApodo());
			 listStatsbyUser.add(fplapi.listStatbyUser(players.get(i).getIdfpl()));
		     listStatsbyUser.get(i).setApodo(players.get(i).getApodo());
		 }
		 
	     
		
		
		
		
		
		model.addAttribute("liststats", listStatsbyUser);
		model.addAttribute("listPJornada", listPtos);
		model.addAttribute("liststatsdraft", listRestApiDraft);
			return "index" ;	
		
		
	} catch (HttpRequestMethodNotSupportedException e) {
		// TODO: handle exception
	}
	
	return "error";
	
	}

@PostMapping("/index")
public String createIndex (@RequestParam(value = "idplayer", required = true) String idplayer , Model model) throws Exception{
	
try {
		

		List<Jugador> players = new LinkedList<>();
		List<Classic> listaClassic = classicRest.findAllClassic();
	     List<Integer>listPtos = new LinkedList<>();
		 List<ClassicRestApiStats> listStatsbyUser = new LinkedList<ClassicRestApiStats>();
	     players = jugadorservice.listAllJugador();
		 for (int i = 0; i < players.size(); i++) {
			 
			 listStatsbyUser.add(fplapi.listStatbyUser(players.get(i).getIdfpl()));
		     listStatsbyUser.get(i).setApodo(players.get(i).getApodo());
		 }
		 
	     
		
		
		
		
		
		model.addAttribute("liststats", listStatsbyUser);
		model.addAttribute("listPJornada", listPtos);
		
		
		
			return "index" ;	
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return "error";
	
	
	

}





@GetMapping("/rest")
public String getForObjectOperation(Model model) throws Exception{
      
	
model.addAttribute("myjson", fplApi.listOfPlayerbyGW(1, 54078));
return "classic" ;
	


}

}
