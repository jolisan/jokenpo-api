package com.zenvia.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zenvia.api.model.Players;
import com.zenvia.api.model.Jokenpo;
import com.zenvia.api.model.Jokenpo.Play;

@RestController
@RequestMapping("/api")
public class JokenpoController {
	
	@RequestMapping(path = "/jokenpo/play", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity letsPlay(@RequestParam(value="player1") Play firstPlay,
			@RequestParam(value="player2") Play secondPlay) throws Exception {
		Players Players = new Players();
		Jokenpo Jokenpo = new Jokenpo();

		Players.clearMapPlayers();
		Players.setMapPlayers(firstPlay, "Player 1");
		Players.setMapPlayers(secondPlay, "Player 2");
		Jokenpo.makePlay(Players);

		return new ResponseEntity(Players.getMapPlayers(), HttpStatus.OK);
	}

}
