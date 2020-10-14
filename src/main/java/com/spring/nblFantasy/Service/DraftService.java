/**
 * 
 */
package com.spring.nblFantasy.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.nblFantasy.Model.Draft;
import com.spring.nblFantasy.Model.DraftSquad;
import com.spring.nblFantasy.Model.Jugador;
import com.spring.nblFantasy.Repository.DraftRepository;
import com.spring.nblFantasy.Repository.DraftSquadRepository;
import com.spring.nblFantasy.views.resources.vo.consumingRestFPL.ClassicRestApiStats;
import com.spring.nblFantasy.views.resources.vo.consumingRestFPL.DraftRestApiStats;
import com.spring.nblFantasy.views.resources.vo.consumingRestFPL.DraftSquadListVO;

/**
 * @author Owner
 * This is the the class DraftService where we going to develop the main functionalities
 */
@Service
@Transactional
public class DraftService {
    
	public final DraftRepository draftrepository ;
	
	public final DraftSquadRepository  draftsquadrepository ;
	@Autowired
	JugadorService jugadorservice ;
	
	@Autowired
	DraftSquadServices draftsquadervices;
	
	
	
	@Autowired
	RestTemplate restTemplate;
	public DraftService(DraftRepository draftrepository, DraftSquadRepository draftsquadrepository) {
		super();
		this.draftrepository = draftrepository;
		this.draftsquadrepository=draftsquadrepository;
	} 
	
	public Draft create (Draft draft) {
		
		return this.draftrepository.save(draft);
	}
	
public Draft update (Draft draft) {
		
		return this.draftrepository.save(draft);
	}
public void delete (Draft draft) {
	
 this.draftrepository.delete(draft);;
}



public List<ClassicRestApiStats> listStats (List<DraftSquad> draftsquad){
	List<ClassicRestApiStats> listStats = new LinkedList<ClassicRestApiStats>();
	
	return listStats;
}


public HashMap< String , String> listofTeams (){
	HashMap<String, String> teammap = new HashMap<>();
	String url = "https://fantasy.premierleague.com/api/bootstrap-static/";
	HttpHeaders headers = new HttpHeaders();
	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
	
	HttpEntity<String> entity = new HttpEntity<>(headers);
	
	HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
			String.class);
	
	if(response != null ) {
		JSONObject result = new JSONObject(response.getBody());
		JSONArray tokenList = result.getJSONArray("teams");
	
		for (int i = 0; i < tokenList.length(); i++) {
			JSONObject oj = tokenList.getJSONObject(i);
			teammap.put(oj.getString("name"), String.valueOf(oj.getInt("id")));
			
		}
		return teammap ;
	}
	
	return teammap ; 
}


public HashMap< String , String> listofPlayersByTeams (String id){
	HashMap<String, String>playermap = new HashMap<>();
	String url = "https://fantasy.premierleague.com/api/bootstrap-static/";
	HttpHeaders headers = new HttpHeaders();
	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
	
	HttpEntity<String> entity = new HttpEntity<>(headers);
	
	HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
			String.class);
	
	if(response != null ) {
		JSONObject result = new JSONObject(response.getBody());
		JSONArray tokenList = result.getJSONArray("elements");
	
		for (int i = 0; i < tokenList.length(); i++) {
			JSONObject oj = tokenList.getJSONObject(i);
			if (oj.getInt("team")==Integer.parseInt(id)) {
				
				playermap.put(oj.getString("web_name"),String.valueOf(oj.getInt("id")));
				
			}
			
		}
		return playermap ;
	}
	
	return playermap ; 
}

public List<DraftSquad> listbyId(int id){
	List<DraftSquad> list = new LinkedList<DraftSquad>();
	List<DraftSquad> listSquad = new LinkedList<DraftSquad>();
	
	list = draftsquadervices.listAllDraftSquad();
	
	for (int i = 0; i < list.size(); i++) {
		if (list.get(i).getJugadordraftsquad().getIdfpl()==id) {
			
			listSquad.add(list.get(i));
		}
		
	}
	return listSquad;
}


public List<ClassicRestApiStats> listStatsByPlayerinGW( int idplayer ,int gw) {
	ClassicRestApiStats draft = new ClassicRestApiStats();
	List<ClassicRestApiStats> lista = new ArrayList<>();

	String url = "https://fantasy.premierleague.com/api/event/" + gw + "/live/";
	HttpHeaders headers = new HttpHeaders();
	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

	HttpEntity<String> entity = new HttpEntity<>(headers);

	HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
			String.class);

	if (response != null) {

		// parsing JSON
		JSONObject result = new JSONObject(response.getBody()); // Convert String to JSON Object

		JSONArray tokenList = result.getJSONArray("elements");

		// Creating an adding to the list the Virtual Object with the data from JSON

		for (int i = 0; i < tokenList.length(); i++) {
			if (tokenList.getJSONObject(i).getInt("id") == idplayer) {
				JSONObject oj = tokenList.getJSONObject(i);
				JSONObject stats = oj.getJSONObject("stats");

				int id = oj.getInt("id");
				int minutes = stats.getInt("minutes");
				int goals_scored = stats.getInt("goals_scored");
				int assists = stats.getInt("assists");
				int clean_sheets = stats.getInt("clean_sheets");
				int goals_conceded = stats.getInt("goals_conceded");
				int own_goals = stats.getInt("own_goals");
				int penalties_saved = stats.getInt("penalties_saved");
				int penalties_missed = stats.getInt("penalties_missed");
				int yellow_cards = stats.getInt("yellow_cards");
				int red_cards = stats.getInt("red_cards");
				int saves = stats.getInt("saves");
				int bonus = stats.getInt("bonus");
				int bps = stats.getInt("bps");
				float influence = stats.getFloat("influence");
				float creativity = stats.getFloat("creativity");
				float threat = stats.getFloat("threat");
				float ict_index = stats.getFloat("ict_index");
				int total_points = stats.getInt("total_points");
				

				draft.setId(id);
				draft.setMinutes(minutes);
				draft.setGoals_scored(goals_scored);
				draft.setAssists(assists);
				draft.setClean_sheets(clean_sheets);
				draft.setGoal_conceded(goals_conceded);
				draft.setOwn_goals(own_goals);
				draft.setPenalties_saved(penalties_saved);
				draft.setPenalties_missed(penalties_missed);
				draft.setYellow_cards(yellow_cards);
				draft.setRed_cards(red_cards);
				draft.setSaves(saves);
				draft.setBonus(bonus);
				draft.setBps(bps);
				draft.setInfluence(influence);
				draft.setCreativity(creativity);
				draft.setThreat(threat);
				draft.setIct_index(ict_index);
				draft.setTotal_points(total_points);
				

				lista.add(draft);

				return lista;
			}

		}

	}

	return lista;

}

public List<DraftSquadListVO> listSquadbyID(int id ){
	
	List<DraftSquad> listDraftSquad = new LinkedList<DraftSquad>();
	List<DraftSquadListVO> listDraftSquadVO = new LinkedList<DraftSquadListVO>();
	DraftSquadListVO VO = new DraftSquadListVO();
	
	listDraftSquad=	this.listbyId(id);
	
	for (int i = 0; i < listDraftSquad.size(); i++) {
		VO.setPlayer1(String.valueOf(listDraftSquad.get(i).getIdplayer1()));
		VO.setPlayer2(String.valueOf(listDraftSquad.get(i).getIdplayer2()));
		VO.setPlayer3(String.valueOf(listDraftSquad.get(i).getIdplayer3()));
		VO.setPlayer4(String.valueOf(listDraftSquad.get(i).getIdplayer4()));
		VO.setPlayer5(String.valueOf(listDraftSquad.get(i).getIdplayer5()));
		VO.setPlayer6(String.valueOf(listDraftSquad.get(i).getIdplayer6()));
		VO.setPlayer7(String.valueOf(listDraftSquad.get(i).getIdplayer7()));
		VO.setPlayer8(String.valueOf(listDraftSquad.get(i).getIdplayer8()));
		VO.setPlayer9(String.valueOf(listDraftSquad.get(i).getIdplayer9()));
		VO.setPlayer10(String.valueOf(listDraftSquad.get(i).getIdplayer10()));
		VO.setPlayer11(String.valueOf(listDraftSquad.get(i).getIdplayer11()));
		VO.setPlayer12(String.valueOf(listDraftSquad.get(i).getIdplayer12()));
		VO.setPlayer13(String.valueOf(listDraftSquad.get(i).getIdplayer13()));
		VO.setPlayer14(String.valueOf(listDraftSquad.get(i).getIdplayer14()));
		VO.setPlayer15(String.valueOf(listDraftSquad.get(i).getIdplayer15()));
		VO.setIdFPL(listDraftSquad.get(i).getJugadordraftsquad().getIdfpl());
		VO.setGw(listDraftSquad.get(i).getGameweek());
		
		listDraftSquadVO.add(VO);
	}
	
	
	return listDraftSquadVO;
}


public DraftRestApiStats finalListDraftStats (int id)throws Exception{
	try {
		  String apodo ="";
		     int minutes=0 ;
		 	 int goals_scored =0;
		 	 int assists =0;
		 	 int clean_sheets=0;
		 	 int goals_conceded=0 ;
		 	 int own_goals=0 ;
		 	 int penalties_saved=0;
		 	 int penalties_missed=0;
		 	 int yellow_cards=0 ;
		 	 int red_cards =0; 
		 	 int saves =0;
		 	 int bonus=0 ;
		 	 int bps =0;
		 	 float influence=0;
		 	 float creativity=0;
		 	 float threat=0 ;
		 	 float ict_index=0;
		 	 int total_points=0;
		 	 int benchpoints =0;
		 	 int benchgoals =0; 
		 	 int benchassists=0 ;
		 	 int benchcleansheets=0 ;
		 	
		 
		 	
		 	 DraftRestApiStats draft = new DraftRestApiStats();
		List<DraftSquadListVO>list = this.listSquadbyID(id);
		
	
		List<DraftRestApiStats> listStat =new LinkedList<DraftRestApiStats>() ;

		
	     
			for (int j = 0; j < list.size(); j++) {
				listStat.add(this.listStatsDraftByplayer(list.get(j), list.get(j).getGw()));
			
			}
			
			for (int i = 0; i < listStat.size(); i++) {
				
				 minutes += listStat.get(i).getMinutes();
				 goals_scored += listStat.get(i).getGoals_scored();
				 assists += listStat.get(i).getAssists();
				 clean_sheets += listStat.get(i).getClean_sheets();
				 goals_conceded += listStat.get(i).getGoal_conceded();
				 own_goals += listStat.get(i).getOwn_goals();
				 penalties_saved += listStat.get(i).getPenalties_saved();
				 penalties_missed += listStat.get(i).getPenalties_missed();
				 yellow_cards += listStat.get(i).getYellow_cards();
				 red_cards += listStat.get(i).getRed_cards();
				 saves += listStat.get(i).getSaves();
				 bonus += listStat.get(i).getBonus();
				 bps += listStat.get(i).getBps();
				 influence += listStat.get(i).getInfluence();
				 creativity += listStat.get(i).getCreativity();
				 threat += listStat.get(i).getThreat();
				 ict_index += listStat.get(i).getIct_index();
				 total_points += listStat.get(i).getTotal_points();
				benchassists+=listStat.get(i).getBenchassists();
				benchpoints+=listStat.get(i).getBenchpoints();
				benchcleansheets+=listStat.get(i).getBenchcleansheets();
				benchgoals+=listStat.get(i).getBenchgoals();
				
			}
			draft.setApodo("");
			draft.setMinutes(minutes);
			draft.setGoals_scored(goals_scored);
			draft.setAssists(assists);
			draft.setClean_sheets(clean_sheets);
			draft.setGoal_conceded(goals_conceded);
			draft.setOwn_goals(own_goals);
			draft.setPenalties_saved(penalties_saved);
			draft.setPenalties_missed(penalties_missed);
			draft.setYellow_cards(yellow_cards);
			draft.setRed_cards(red_cards);
			draft.setSaves(saves);
			draft.setBonus(bonus);
			draft.setBps(bps);
			draft.setInfluence(influence);
			draft.setCreativity(creativity);
			draft.setThreat(threat);
			draft.setIct_index(ict_index);
			draft.setTotal_points(total_points);
			draft.setBenchassists(benchassists);
			draft.setBenchcleansheets(benchcleansheets);
			draft.setBenchgoals(benchgoals);
			draft.setBenchpoints(benchpoints);
			
			return draft; 
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		 
    	return null; 
    	 
		
	
	
	
	
}






  public DraftRestApiStats listStatsDraftByplayer (DraftSquadListVO squad , int gw) throws Exception{
	  DraftRestApiStats draft = new DraftRestApiStats();
	  List<Integer> ids = new LinkedList<Integer>();
	     ids.add(Integer.parseInt(squad.getPlayer1()));
	     ids.add(Integer.parseInt(squad.getPlayer2()));
	     ids.add(Integer.parseInt(squad.getPlayer3()));
	     ids.add(Integer.parseInt(squad.getPlayer4()));
	     ids.add(Integer.parseInt(squad.getPlayer5()));
	     ids.add(Integer.parseInt(squad.getPlayer6()));
	     ids.add(Integer.parseInt(squad.getPlayer7()));
	     ids.add(Integer.parseInt(squad.getPlayer8()));
	     ids.add(Integer.parseInt(squad.getPlayer9()));
	     ids.add(Integer.parseInt(squad.getPlayer10()));
	     ids.add(Integer.parseInt(squad.getPlayer11()));
	     ids.add(Integer.parseInt(squad.getPlayer12()));
	     ids.add(Integer.parseInt(squad.getPlayer13()));
	     ids.add(Integer.parseInt(squad.getPlayer14()));
	     ids.add(Integer.parseInt(squad.getPlayer15()));
	     
	     
	    
	     
	 	
	      int minutes=0 ;
	 	 int goals_scored =0;
	 	 int assists =0;
	 	 int clean_sheets=0;
	 	 int goals_conceded=0 ;
	 	 int own_goals=0 ;
	 	 int penalties_saved=0;
	 	 int penalties_missed=0;
	 	 int yellow_cards=0 ;
	 	 int red_cards =0; 
	 	 int saves =0;
	 	 int bonus=0 ;
	 	 int bps =0;
	 	 float influence=0;
	 	 float creativity=0;
	 	 float threat=0 ;
	 	 float ict_index=0;
	 	 int total_points=0;
	 	 int benchpoints =0;
	 	 int benchgoals =0; 
	 	 int benchassists=0 ;
	 	 int benchcleansheets=0 ;
	  
	  try {
		  

			String url = "https://fantasy.premierleague.com/api/event/"+ gw +"/live/";
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

			HttpEntity<String> entity = new HttpEntity<>(headers);

			HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
					String.class);
		  
			if (response != null) {
				// parsing JSON
				JSONObject result = new JSONObject(response.getBody()); // Convert String to JSON Object
				
				JSONArray tokenList = result.getJSONArray("elements");
				
				// Creating an adding to the list the Virtual Object with the data from JSON
				
				
				for (int i = 0; i < ids.size(); i++) {
					for (int j = 0; j < tokenList.length(); j++) {
						
						if (tokenList.getJSONObject(j).getInt("id") == ids.get(i)) {
							
							
							int type =this.PlayerType(ids.get(i));
							JSONObject oj = tokenList.getJSONObject(j);
							JSONObject stats = oj.getJSONObject("stats");
							
							
							 minutes += stats.getInt("minutes");
							 goals_scored += stats.getInt("goals_scored");
							 assists += stats.getInt("assists");
							
							 if( (type==1 || type ==2) && i < 11 ) {
								 clean_sheets += stats.getInt("clean_sheets"); 
								 goals_conceded += stats.getInt("goals_conceded");
							 }
							 
							 own_goals += stats.getInt("own_goals");
							 penalties_saved += stats.getInt("penalties_saved");
							 penalties_missed += stats.getInt("penalties_missed");
							 yellow_cards += stats.getInt("yellow_cards");
							 red_cards += stats.getInt("red_cards");
							 saves += stats.getInt("saves");
							 bonus += stats.getInt("bonus");
							 bps += stats.getInt("bps");
							 influence += stats.getFloat("influence");
							 creativity += stats.getFloat("creativity");
							 threat += stats.getFloat("threat");
							 ict_index += stats.getFloat("ict_index");
							 total_points += stats.getInt("total_points");
							 
						if (i>10) {
							
							if(type==1 || type ==2 ) {
								 benchcleansheets+= stats.getInt("clean_sheets");
							 }
							 benchpoints += stats.getInt("total_points");
						 	  benchgoals += stats.getInt("goals_scored"); 
						 	  benchassists+= stats.getInt("assists") ;
						 	 
							
					
						
						}
						
						}
						
						
						
						
					}
				}
				
				draft.setMinutes(minutes);
				draft.setGoals_scored(goals_scored);
				draft.setAssists(assists);
				draft.setClean_sheets(clean_sheets);
				draft.setGoal_conceded(goals_conceded);
				draft.setOwn_goals(own_goals);
				draft.setPenalties_saved(penalties_saved);
				draft.setPenalties_missed(penalties_missed);
				draft.setYellow_cards(yellow_cards);
				draft.setRed_cards(red_cards);
				draft.setSaves(saves);
				draft.setBonus(bonus);
				draft.setBps(bps);
				draft.setInfluence(influence);
				draft.setCreativity(creativity);
				draft.setThreat(threat);
				draft.setIct_index(ict_index);
				draft.setTotal_points(total_points);
				draft.setBenchassists(benchassists);
				draft.setBenchcleansheets(benchcleansheets);
				draft.setBenchgoals(benchgoals);
				draft.setBenchpoints(benchpoints);
				
				return draft; 
			}
		  
		
	} catch (Exception e) {
		e.getMessage();
	}
	  return null ; 
	  
	  
	  
  }


public int PlayerType (int id) {
	
	String url = "https://fantasy.premierleague.com/api/bootstrap-static/";
	HttpHeaders headers = new HttpHeaders();
	headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

	HttpEntity<String> entity = new HttpEntity<>(headers);

	HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
			String.class);
	
	if (response != null) {
		// parsing JSON
		JSONObject result = new JSONObject(response.getBody()); // Convert String to JSON Object
		
		JSONArray tokenList = result.getJSONArray("elements");
		
		for (int i = 0; i < tokenList.length(); i++) {
			if(tokenList.getJSONObject(i).getInt("id")==id) {
				return tokenList.getJSONObject(i).getInt("element_type");
				
			}
			
			
		}
		
	}
	
	return 0 ;
}





}
