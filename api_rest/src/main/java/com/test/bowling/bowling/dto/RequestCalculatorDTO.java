package com.test.bowling.bowling.dto;

import java.util.Arrays;

public class RequestCalculatorDTO {
	
	private String[] game;

	public String[] getGame() {
		return game;
	}

	public void setGame(String[] game) {
		this.game = game;
	}

	@Override
	public String toString() {
		return "RequestCalculatorDTO [game=" + Arrays.toString(game) + "]";
	}
}
