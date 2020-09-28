package com.bankaya.pokemon.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankaya.pokemon.soap.GetAbilitiesResponse;
import com.bankaya.pokemon.soap.GetBaseExperienceResponse;
import com.bankaya.pokemon.soap.GetHeldItemsResponse;
import com.bankaya.pokemon.soap.GetIdResponse;
import com.bankaya.pokemon.soap.GetLocationAreaEncountersResponse;
import com.bankaya.pokemon.soap.GetNameResponse;

@Service
public class PockemonRestTemplate {
	@Autowired RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	private HttpHeaders headers = new HttpHeaders();
	
	public PockemonRestTemplate() {
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	}    
	
	public GetAbilitiesResponse getAbilities(String pockemon) {
	    HttpEntity<String> entity = new HttpEntity<String>(pockemon, headers);
		ResponseEntity<GetAbilitiesResponse> respAbilities = restTemplate.exchange(env.getProperty("pockemon.url") + pockemon, HttpMethod.GET, entity, GetAbilitiesResponse.class);
		return respAbilities.getBody();
	}
	
	public GetBaseExperienceResponse getBaseExperience(String pockemon) {
	    HttpEntity<String> entity = new HttpEntity<String>(pockemon, headers);
		ResponseEntity<GetBaseExperienceResponse> respAbilities = restTemplate.exchange(env.getProperty("pockemon.url") + pockemon, HttpMethod.GET, entity, GetBaseExperienceResponse.class);
		return respAbilities.getBody();
	}
	
	public GetHeldItemsResponse getHeldItem(String pockemon) {
	    HttpEntity<String> entity = new HttpEntity<String>(pockemon, headers);
		ResponseEntity<GetHeldItemsResponse> respAbilities = restTemplate.exchange(env.getProperty("pockemon.url") + pockemon, HttpMethod.GET, entity, GetHeldItemsResponse.class);
		return respAbilities.getBody();
	}
	
	public GetIdResponse getId(String pockemon) {
	    HttpEntity<String> entity = new HttpEntity<String>(pockemon, headers);
		ResponseEntity<GetIdResponse> respAbilities = restTemplate.exchange(env.getProperty("pockemon.url") + pockemon, HttpMethod.GET, entity, GetIdResponse.class);
		return respAbilities.getBody();
	}
	
	public GetLocationAreaEncountersResponse getLocationAreaEncounters(String pockemon) {
	    HttpEntity<String> entity = new HttpEntity<String>(pockemon, headers);
		ResponseEntity<GetLocationAreaEncountersResponse> respAbilities = restTemplate.exchange(env.getProperty("pockemon.url") + pockemon, HttpMethod.GET, entity, GetLocationAreaEncountersResponse.class);
		return respAbilities.getBody();
	}
	
	public GetNameResponse getName(String pockemon) {
	    HttpEntity<String> entity = new HttpEntity<String>(pockemon, headers);
		ResponseEntity<GetNameResponse> respAbilities = restTemplate.exchange(env.getProperty("pockemon.url") + pockemon, HttpMethod.GET, entity, GetNameResponse.class);
		return respAbilities.getBody();
	}
}
