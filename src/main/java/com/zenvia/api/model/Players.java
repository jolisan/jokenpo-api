package com.zenvia.api.model;

import java.util.TreeMap;

import com.zenvia.api.model.Jokenpo.Play;

public class Players {

	private TreeMap<Play, String> mapPlayers = new TreeMap<Play, String>();

	public TreeMap<Play, String> getMapPlayers() {
		return mapPlayers;
	}

	public void setMapPlayers(Play play, String name) {
		mapPlayers.put(play, name);
	}

	public void clearMapPlayers() {
		mapPlayers.clear();
	}
}
