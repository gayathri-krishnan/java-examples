package com.gayathri.generics;

import java.util.ArrayList;
import java.util.List;

public class RestrictionsWithTypesSolution {
	public static void main(String args) {
		List<FootBallPlayer> footBallPlayers = new ArrayList<>();
		footBallPlayers.add(new FootBallPlayer("a"));
		footBallPlayers.add(new FootBallPlayer("b"));

		List<CricketPlayer> cricketPlayers = new ArrayList<>();
		cricketPlayers.add(new CricketPlayer("c"));
		cricketPlayers.add(new CricketPlayer("d"));

		TypedTeam<FootBallPlayer> footBallTeam = new TypedTeam<>(footBallPlayers);
		// TypedTeam<FootBallPlayer> footBallTeam2 = new TypedTeam<>(cricketPlayers);
	}

}

class TypedTeam<T> {
	private List<T> players;

	public TypedTeam(final List<T> players) {
		this.players = players;
	}
}
