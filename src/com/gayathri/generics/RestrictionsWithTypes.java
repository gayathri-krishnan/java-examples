package com.gayathri.generics;

import java.util.ArrayList;
import java.util.List;

public class RestrictionsWithTypes {
	public static void main(String args) {
		List<Player> players = new ArrayList<>();
		players.add(new FootBallPlayer("a"));
		players.add(new CricketPlayer("b"));
		Team newTeam = new Team(players);
		// Can we have a team of players playing different Sports?
	}

}

class Team {
	private List<Player> players;

	public Team(final List<Player> players) {
		this.players = players;
	}
}

class Player {
	protected String name;

	public Player(final String name) {
		this.name = name;
	}
}

class FootBallPlayer extends Player {

	public FootBallPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

}

class CricketPlayer extends Player {

	public CricketPlayer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

}