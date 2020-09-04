package com.spring.nblFantasy.Service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.nblFantasy.views.resources.vo.consumingRestFPL.ClassicRestApiStats;
import com.spring.nblFantasy.views.resources.vo.consumingRestFPL.PlayerPickVO;

@Service
public class FPLApi {
	@Autowired
	RestTemplate restTemplate;

	public ClassicRestApiStats listStatbyUser(int idapi) throws Exception {

		try {

			
			
			int minutes = 0;
			int goals_scored = 0;
			int assists =0;
			int clean_sheets = 0;
			int goals_conceded = 0;
			int own_goals = 0;
			int penalties_saved =0;
			int penalties_missed = 0;
			int yellow_cards = 0;
			int red_cards = 0;
			int saves =0;
			int bonus = 0;
			int bps = 0;
			float influence = 0;
			float creativity = 0;
			float threat = 0;
			float ict_index = 0;
			int total_points = 0;
			
			
			
			
			for (int i = 1; i <= gwPlayed(idapi); i++) {
				for (int j = 0; j < this.listOfPlayerbyGW(i, idapi).size(); j++) {
					for (int k = 0; k < this.listStatsByPlayerinGW(idapi, i).size(); k++) {
                       
						if (this.listOfPlayerbyGW(i, idapi).get(j).getId() == this.listStatsByPlayerinGW(idapi, i).get(k).getId() || this.listOfPlayerbyGW(i, idapi).get(j).getRegular()==1     ) {
						
							minutes += this.listStatsByPlayerinGW(idapi, i).get(k).getMinutes();
							goals_scored += this.listStatsByPlayerinGW(idapi, i).get(k).getGoals_scored();
							assists +=this.listStatsByPlayerinGW(idapi, i).get(k).getAssists();
							clean_sheets += this.listStatsByPlayerinGW(idapi, i).get(k).getClean_sheets();
							goals_conceded +=this.listStatsByPlayerinGW(idapi, i).get(k).getGoal_conceded();
							own_goals +=this.listStatsByPlayerinGW(idapi, i).get(k).getOwn_goals();
							penalties_saved +=this.listStatsByPlayerinGW(idapi, i).get(k).getPenalties_saved();
							penalties_missed+=this.listStatsByPlayerinGW(idapi, i).get(k).getPenalties_missed();
							yellow_cards+=this.listStatsByPlayerinGW(idapi, i).get(k).getYellow_cards();
							red_cards +=this.listStatsByPlayerinGW(idapi, i).get(k).getRed_cards();
							saves +=this.listStatsByPlayerinGW(idapi, i).get(k).getSaves();
							bonus +=this.listStatsByPlayerinGW(idapi, i).get(k).getSaves();
							bps +=this.listStatsByPlayerinGW(idapi, i).get(k).getBps();
							influence+=this.listStatsByPlayerinGW(idapi, i).get(k).getInfluence();
							creativity +=this.listStatsByPlayerinGW(idapi, i).get(k).getCreativity();
							threat +=this.listStatsByPlayerinGW(idapi, i).get(k).getThreat();
							ict_index +=this.listStatsByPlayerinGW(idapi, i).get(k).getIct_index();
							total_points +=this.listStatsByPlayerinGW(idapi, i).get(k).getTotal_points();
							
							
							
						}
						
					}

				}

			}
			
			ClassicRestApiStats classic = new ClassicRestApiStats();
			classic.setMinutes(minutes);
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
			
			
			
			return classic ;

		} catch (Exception e) {
			e.getMessage();
		}
       return null ;
	}

	public List<ClassicRestApiStats> listStatsByPlayerinGW(int idapi, int gw) {
		ClassicRestApiStats classic = new ClassicRestApiStats();
		List<ClassicRestApiStats> lista = new ArrayList<>();

		String url = "https://fantasy.premierleague.com/api/event/" + gw + "/live/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("id", idapi);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				String.class);

		if (response != null) {

			// parsing JSON
			JSONObject result = new JSONObject(response.getBody()); // Convert String to JSON Object

			JSONArray tokenList = result.getJSONArray("elements");

			// Creating an adding to the list the Virtual Object with the data from JSON

			for (int i = 0; i < tokenList.length(); i++) {
				if (tokenList.getJSONObject(i).getInt("id") == idapi) {
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
					boolean in_dreamteam = stats.getBoolean("in_dreamteam");

					classic.setId(id);
					classic.setMinutes(minutes);
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

	public List<PlayerPickVO> listOfPlayerbyGW(int gw, int idteam) throws Exception {
		PlayerPickVO playerpick = new PlayerPickVO();
		List<PlayerPickVO> lista = new ArrayList<>();

		try {

			String url = "https://fantasy.premierleague.com/api/entry/" + idteam + "/event/" + gw + "/picks/";
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

			HttpEntity<String> entity = new HttpEntity<>(headers);

			HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
					String.class);

			if (response != null) {

				// parsing JSON
				JSONObject result = new JSONObject(response.getBody()); // Convert String to JSON Object
				JSONArray tokenList = result.getJSONArray("picks");

				// Creating an adding to the list the Virtual Object with the data from JSON
				for (int i = 0; i < tokenList.length(); i++) {
					playerpick.setId(tokenList.getJSONObject(i).getInt("element"));
					playerpick.setRegular(tokenList.getJSONObject(i).getInt("multiplier"));
					playerpick.set_capt(tokenList.getJSONObject(i).getBoolean("is_captain"));
					playerpick.set_vicecapt(tokenList.getJSONObject(i).getBoolean("is_vice_captain"));
					lista.add(playerpick);

				}

				return lista;

			}

		} catch (Exception e) {
			e.getMessage();
		}
		return lista;

	}

	public int gwPlayed(int idplayer) {

		String url = "https://fantasy.premierleague.com/api/entry/" + idplayer + "/history/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				String.class);

		if (response != null) {
			JSONObject result = new JSONObject(response.getBody()); // Convert String to JSON Object
			JSONArray tokenList = result.getJSONArray("current");
			return tokenList.length();

		}
		return 0;

	}

	public int firstWildcard(int idplayer) {

		String url = "https://fantasy.premierleague.com/api/entry/" + idplayer + "/history/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				String.class);

		if (response != null) {
			JSONObject result = new JSONObject(response.getBody()); // Convert String to JSON Object
			JSONArray tokenList = result.getJSONArray("chips");
			int temp1 = 0;
			int temp2 = 0;
			for (int i = 0; i < tokenList.length(); i++) {
				if (tokenList.getJSONObject(i).getString("name").equalsIgnoreCase("wildcard")) {
					if (temp1 == 0) {
						temp1 = tokenList.getJSONObject(i).getInt("event");

					} else {
						temp2 = tokenList.getJSONObject(i).getInt("event");

					}

				}

			}
			if (temp1 > temp2) {
				return temp2;
			}
			return temp1;
		}
		return -1;

	}

	public int secondWildcard(int idplayer) {

		String url = "https://fantasy.premierleague.com/api/entry/" + idplayer + "/history/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

		HttpEntity<String> entity = new HttpEntity<>(headers);

		HttpEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				String.class);

		if (response != null) {
			JSONObject result = new JSONObject(response.getBody()); // Convert String to JSON Object
			JSONArray tokenList = result.getJSONArray("chips");
			int temp1 = 0;
			int temp2 = 0;
			for (int i = 0; i < tokenList.length(); i++) {
				if (tokenList.getJSONObject(i).getString("name").equalsIgnoreCase("wildcard")) {
					if (temp1 == 0) {
						temp1 = tokenList.getJSONObject(i).getInt("event");

					} else {
						temp2 = tokenList.getJSONObject(i).getInt("event");

					}

				}

			}
			if (temp1 > temp2) {
				return temp1;
			}
			return temp2;
		}
		return -1;

	}

	// public List<ClassicRestApiStats> statsByPlayer (){

//}

}
