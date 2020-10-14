package com.spring.nblFantasy.views.resources;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.nblFantasy.Model.Draft;
import com.spring.nblFantasy.Model.DraftSquad;
import com.spring.nblFantasy.Model.Jugador;
import com.spring.nblFantasy.Service.DraftService;
import com.spring.nblFantasy.Service.DraftSquadServices;
import com.spring.nblFantasy.Service.JugadorService;
import com.spring.nblFantasy.views.resources.vo.consumingRestFPL.DraftSquadListVO;
import com.spring.nblFantasy.views.resources.vo.consumingRestFPL.PlayerVO;

import javassist.expr.NewArray;

@Controller
public class DraftController {
 @Autowired
	DraftService draftservice ; 
	@Autowired 
  DraftSquadServices draftsquadservice ;
	@Autowired
	JugadorService jugadorservices ; 
	
	
 @GetMapping("/draft/adddraft")
	public String  addDraft (Model modelo) {
	 List<Integer> list =new LinkedList<Integer>();
	 for (int i = 1; i < 39; i++) {
		list.add(i);
	}
	 
	 
	 HashMap<String , Integer> player1 =new HashMap<>();
	 DraftSquadListVO p = new DraftSquadListVO();
	List<Jugador> listPlayers = new LinkedList<Jugador>();
	
	listPlayers = jugadorservices.listAllJugador();
	 modelo.addAttribute("teams", draftservice.listofTeams());
	 modelo.addAttribute("player1", player1);
	 modelo.addAttribute("listplayers", listPlayers);
	 modelo.addAttribute("p", p);
	 modelo.addAttribute("gameweek", list);
	 return "addDraft";
 }
 @RequestMapping(value= "/players")
 @ResponseBody
public HashMap<String, String> listPlayerByTeam (@RequestParam("teams") String teams){
	 
	return draftservice.listofPlayersByTeams(teams);
	 
	
	
 }
 
 
 @GetMapping("/test")
	public String  listteam (Model modelo) {
	 
	modelo.addAttribute("myjson", draftservice.listofPlayersByTeams("11"));
	 return "test";
}
 
 @PostMapping("/addsquaddraft")
 public String addPlayerPost(@ModelAttribute(value ="p") DraftSquadListVO p, @ModelAttribute(value ="players") Integer idfpl,  @ModelAttribute(value ="gameweek") Integer gameweek ,Model model) {
	 DraftSquad j = new DraftSquad();   
	 DraftSquad draft= new DraftSquad(); 
       j.setIdplayer1(Integer.parseInt(p.getPlayer1()));
       j.setIdplayer2(Integer.parseInt(p.getPlayer2()));
       j.setIdplayer3(Integer.parseInt(p.getPlayer3()));
       j.setIdplayer4(Integer.parseInt(p.getPlayer4()));
       j.setIdplayer5(Integer.parseInt(p.getPlayer5()));
       j.setIdplayer6(Integer.parseInt(p.getPlayer6()));
       j.setIdplayer7(Integer.parseInt(p.getPlayer7()));
       j.setIdplayer8(Integer.parseInt(p.getPlayer8()));
       j.setIdplayer9(Integer.parseInt(p.getPlayer9()));
       j.setIdplayer10(Integer.parseInt(p.getPlayer10()));
       j.setIdplayer11(Integer.parseInt(p.getPlayer11()));
       j.setIdplayer12(Integer.parseInt(p.getPlayer12()));
       j.setIdplayer13(Integer.parseInt(p.getPlayer13()));
       j.setIdplayer14(Integer.parseInt(p.getPlayer14()));
       j.setIdplayer15(Integer.parseInt(p.getPlayer15()));
	  j.setGameweek(gameweek);
      j.setSeason(2019);
      j.setJugadordraftsquad(jugadorservices.jugadorByIdFpl(idfpl));
        draft =draftsquadservice.createDraftSquad(j);
     	   
     	
     	  return "redirect:/index" ; 
		
       
       
 }
 
 
}
