package com.spring.nblFantasy.Service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.nblFantasy.views.resources.vo.consumingRestFPL.ClassicRestApiStats;

@Service
public class FPLApi {

	
	public List<ClassicRestApiStats> statsById (int idapi , int gw){
		 ClassicRestApiStats classic = new ClassicRestApiStats() ;           
			List<ClassicRestApiStats> lista = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://fantasy.premierleague.com/api/event/"+gw+"/live/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("id", 14);
		      
		        	
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		
		
		HttpEntity<String> response = restTemplate.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        String.class);

	     
		   if (response != null) {
	        
	           // parsing JSON
	           JSONObject result = new JSONObject(response.getBody()); //Convert String to JSON Object

	             JSONArray tokenList = result.getJSONArray("elements");
	            
	            
	             
	            
	         
	             for (int i = 0; i < tokenList.length(); i++) {
					if (tokenList.getJSONObject(i).getInt("id")== idapi) {
						 JSONObject oj = tokenList.getJSONObject(i);
						 JSONObject stats = oj.getJSONObject("stats");
						
						    int id = oj.getInt("id"); 
				            int minutes = stats.getInt("minutes");
				            int goals_scored =stats.getInt("goals_scored");
				            int assists =stats.getInt("assists");
				            int clean_sheets = stats.getInt("clean_sheets");
				            int goals_conceded = stats.getInt("goals_conceded");
				        	int own_goals =stats.getInt("own_goals");
				        	int penalties_saved =stats.getInt("penalties_saved");
				        	 int penalties_missed= stats.getInt("penalties_missed");
				        	 int yellow_cards =stats.getInt("yellow_cards");
				        	 int red_cards=stats.getInt("red_cards") ; 
				        	 int saves =stats.getInt("saves");
				        	 int bonus =stats.getInt("bonus");
				        	 int bps =stats.getInt("bps");
				        	 float influence =stats.getFloat("influence");
				        	 float creativity = stats.getFloat("creativity");
				        	 float threat =stats.getFloat("threat");
				        	 float ict_index =stats.getFloat("ict_index");
				        	 int total_points = stats.getInt("total_points");
				        	 boolean in_dreamteam = stats.getBoolean("in_dreamteam");
				            
						
						classic.setId(id);;
						classic.setMinutes(minutes);;
						classic.setGoals_scored(goals_scored);
						classic.setAssists(assists);
						classic.setClean_sheets(clean_sheets);
						classic.setGoal_conceded(goals_conceded);
						classic.setOwn_goals(own_goals);
						classic.setPenalties_saved(penalties_saved);
						classic.setPenalties_missed(penalties_missed);
						classic.setYellow_cards(yellow_cards);
						classic.setRed_cards(red_cards);
						classic.setSaves(saves);
						classic.setBonus(bonus);
						classic.setBps(bps);
						classic.setInfluence(influence);
						classic.setCreativity(creativity);
						classic.setThreat(threat);
						classic.setIct_index(ict_index);
						classic.setTotal_points(total_points);
						classic.setIn_dreamteam(in_dreamteam);
						
						lista.add(classic);
						
						
				            return lista;
					}
	            	 
	            	 
				}
	             
	             
	             
	            
	            
	            
		   }
		  
	       return lista;
		
	}
		
		
		
	}
	
	
	

