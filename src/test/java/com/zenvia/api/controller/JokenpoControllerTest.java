package com.zenvia.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class JokenpoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void mustReturnSuccess_WhenPlay_Pedra_Tesoura() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/jokenpo/play").param("player1", "PEDRA").param("player2", "TESOURA"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("{\"PEDRA\":\"Player 1\",\"TESOURA\":\"Player 2\",\"WINNER\":\"Player 1\"}"));
	}
	
	@Test
	public void mustReturnSuccess_WhenPlay_Tesoura_Papel() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/jokenpo/play").param("player1", "TESOURA").param("player2", "PAPEL"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("{\"PAPEL\":\"Player 2\",\"TESOURA\":\"Player 1\",\"WINNER\":\"Player 1\"}"));
	}
	
	@Test
	public void mustReturnSuccess_WhenPlay_Papel_Pedra() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/jokenpo/play").param("player1", "PAPEL").param("player2", "PEDRA"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("{\"PEDRA\":\"Player 2\",\"PAPEL\":\"Player 1\",\"WINNER\":\"Player 1\"}"));
	}
	
	@Test
	public void mustReturnSuccess_WhenPlay_WithSameParameters_Draw() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/jokenpo/play").param("player1", "PEDRA").param("player2", "PEDRA"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("{\"WINNER\":\"DRAW\"}"));
	}
	
	@Test
	public void mustReturnWinner_ToPlayer1_WhenPlay_Pedra_Tesoura() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/jokenpo/play").param("player1", "PEDRA").param("player2", "TESOURA"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().json("{\"WINNER\":\"Player 1\"}"));
	}
	
	@Test
	public void mustReturnBadRequest_WhenPlay_WithInvalidParameters() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/jokenpo/play").param("player1", "BATATA").param("player2", "TOMATE"))
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andExpect(MockMvcResultMatchers.content().string("BAD_REQUEST"));
	}
}
