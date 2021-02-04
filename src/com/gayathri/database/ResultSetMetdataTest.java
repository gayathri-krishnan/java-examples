package com.gayathri.database;

import java.util.List;

import com.gayathri.database.model.Artist;
import com.gayathri.database.model.Datasource;
import com.gayathri.database.model.SongArtist;

public class ResultSetMetdataTest {

	public static void main(String[] args) {
		Datasource datasource = new Datasource();
		if (!datasource.open()) {
			System.out.println("Can't open datasource");
			return;
		}

		List<Artist> artists = datasource.queryArtists(5);
		if (artists == null) {
			System.out.println("No artists!");
			return;
		}

		for (Artist artist : artists) {
			System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
		}

		List<String> albumsForArtist = datasource.queryAlbumsForArtist("Carole King", Datasource.ORDER_BY_ASC);

		for (String album : albumsForArtist) {
			System.out.println(album);
		}

		List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", Datasource.ORDER_BY_ASC);
		if (songArtists == null) {
			System.out.println("Couldn't find the artist for the song");
			return;
		}

		for (SongArtist artist : songArtists) {
			System.out.println("Artist name = " + artist.getArtistName() + " Album name = " + artist.getAlbumName()
					+ " Track = " + artist.getTrack());
		}

		datasource.querySongsMetadata();

		datasource.close();
	}
}
