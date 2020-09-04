package com.spring.nblFantasy.views.resources;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.nblFantasy.Service.DraftService;

@Controller
public class DraftController {
 @Autowired
	DraftService draftservice ; 
	
 
 @GetMapping("/draft/adddraft")
	public String  addDraft (Model modelo) {
	 HashMap<String , Integer> player1 =new HashMap<>();
	 modelo.addAttribute("teams", draftservice.listofTeams());
	 modelo.addAttribute("player1", player1);
	 return "addDraft";
 }
 @RequestMapping(value= "/players")
public @ResponseBody HashMap<String, String> listPlayerByTeam (@RequestParam("teams") String teams){
	 
	return draftservice.listofPlayersByTeams(teams);
	 
	
	
 }
 
 
 @GetMapping("/test")
	public String  listteam (Model modelo) {
	 
	modelo.addAttribute("myjson", draftservice.listofTeams());
	 return "test";
}	
 
}
