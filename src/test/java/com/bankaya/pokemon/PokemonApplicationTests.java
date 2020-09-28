package com.bankaya.pokemon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bankaya.pokemon.service.PockemonRestTemplate;
import com.bankaya.pokemon.soap.GetAbilitiesResponse;
/*import com.bankaya.pokemon.soap.Abilities;
import com.bankaya.pokemon.soap.GetAbilitiesResponse;*/
import com.bankaya.pokemon.soap.GetBaseExperienceResponse;
import com.bankaya.pokemon.soap.GetHeldItemsResponse;
import com.bankaya.pokemon.soap.GetIdResponse;
import com.bankaya.pokemon.soap.GetLocationAreaEncountersResponse;
import com.bankaya.pokemon.soap.GetNameResponse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PokemonApplicationTests {

	@Autowired PockemonRestTemplate prt;
	@Test
	void contextLoads() {
		String pockemon = "pikachu";
		GetAbilitiesResponse a = prt.getAbilities(pockemon);
		assertNotNull(a);
		GetBaseExperienceResponse b = prt.getBaseExperience(pockemon);
		assertNotNull(b);
		GetHeldItemsResponse h =prt.getHeldItem(pockemon);
		assertNotNull(h);
		GetIdResponse i = prt.getId(pockemon);
		assertNotNull(i);
		GetLocationAreaEncountersResponse l = prt.getLocationAreaEncounters(pockemon);
		assertNotNull(l);
		GetNameResponse n = prt.getName(pockemon);
		assertNotNull(n);
	}

}
