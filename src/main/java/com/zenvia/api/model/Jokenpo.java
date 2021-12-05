package com.zenvia.api.model;

public class Jokenpo{
	
	public enum Play {
		PEDRA("PEDRA"), PAPEL("PAPEL"), TESOURA("TESOURA"), WINNER("WINNER"), DRAW("DRAW");

		private String description;

		Play(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}
	
	public String makePlay(Players Players) {

		if (Players.getMapPlayers().containsKey(Play.PEDRA) && Players.getMapPlayers().containsKey(Play.TESOURA)) {
			Players.setMapPlayers(Play.WINNER, Players.getMapPlayers().get(Play.PEDRA));
		}

		else if (Players.getMapPlayers().containsKey(Play.TESOURA) && Players.getMapPlayers().containsKey(Play.PAPEL)) {
			Players.setMapPlayers(Play.WINNER, Players.getMapPlayers().get(Play.TESOURA));
		}

		else if (Players.getMapPlayers().containsKey(Play.PAPEL) && Players.getMapPlayers().containsKey(Play.PEDRA)) {
			Players.setMapPlayers(Play.WINNER, Players.getMapPlayers().get(Play.PAPEL));
		}

		else {
			Players.clearMapPlayers();
			Players.setMapPlayers(Play.WINNER, String.valueOf(Play.DRAW));
		}

		return "";
	}
	
}
