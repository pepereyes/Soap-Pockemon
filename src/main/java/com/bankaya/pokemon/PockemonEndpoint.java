package com.bankaya.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bankaya.pokemon.service.PockemonRestTemplate;
import com.bankaya.pokemon.soap.GetAbilitiesRequest;
import com.bankaya.pokemon.soap.GetAbilitiesResponse;
import com.bankaya.pokemon.soap.GetBaseExperienceRequest;
import com.bankaya.pokemon.soap.GetBaseExperienceResponse;
import com.bankaya.pokemon.soap.GetHeldItemsRequest;
import com.bankaya.pokemon.soap.GetHeldItemsResponse;
import com.bankaya.pokemon.soap.GetIdRequest;
import com.bankaya.pokemon.soap.GetIdResponse;
import com.bankaya.pokemon.soap.GetLocationAreaEncountersRequest;
import com.bankaya.pokemon.soap.GetLocationAreaEncountersResponse;
import com.bankaya.pokemon.soap.GetNameRequest;
import com.bankaya.pokemon.soap.GetNameResponse;

@Endpoint
public class PockemonEndpoint {
	@Autowired private PockemonRestTemplate service;
	private static final String NAMESPACE_URI = "http://soap.pokemon.bankaya.com";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
    @ResponsePayload
	public GetAbilitiesResponse getAbilities(@RequestPayload GetAbilitiesRequest request) {
		return service.getAbilities(request.getPockemon());
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
    @ResponsePayload
	public GetBaseExperienceResponse getBaseExperience(@RequestPayload GetBaseExperienceRequest request) {
		return service.getBaseExperience(request.getPockemon());
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
    @ResponsePayload
	public GetHeldItemsResponse getHeldItems(@RequestPayload GetHeldItemsRequest request) {
		return service.getHeldItem(request.getPockemon());
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
    @ResponsePayload
	public GetIdResponse getId(@RequestPayload GetIdRequest request) {
		return service.getId(request.getPockemon());
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
    @ResponsePayload
	public GetLocationAreaEncountersResponse getLocationAreaEncounters(@RequestPayload GetLocationAreaEncountersRequest request) {
		return service.getLocationAreaEncounters(request.getPockemon());
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
    @ResponsePayload
	public GetNameResponse getName(@RequestPayload GetNameRequest request) {
		return service.getName(request.getPockemon());
	}

}
