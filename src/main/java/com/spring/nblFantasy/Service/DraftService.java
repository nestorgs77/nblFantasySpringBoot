/**
 * 
 */
package com.spring.nblFantasy.Service;

import java.util.HashMap;
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
import com.spring.nblFantasy.Repository.DraftRepository;

/**
 * @author Owner
 * This is the the class DraftService where we going to develop the main functionalities
 */
@Service
@Transactional
public class DraftService {

	public final DraftRepository draftrepository ;
	@Autowired
	RestTemplate restTemplate;
	public DraftService(DraftRepository draftrepository) {
		super();
		this.draftrepository = draftrepository;
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


public HashMap< String , Integer> listofTeams (){
	HashMap<String, Integer> teammap = new HashMap<>();
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
			teammap.put(oj.getString("name"),oj.getInt("id"));
			
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





}
