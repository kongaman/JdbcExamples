package best.practice;

import java.util.List;

import best.practice.model.Artist;
import best.practice.model.Datasource;
import best.practice.model.SongArtist;

public class MainMusic {

	public static void main(String[] args) {
		Datasource datasource = new Datasource();
		if (!datasource.open()) {
			System.err.println("Can't open datasource.");
			return;
		}
		
		List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_ASC);
		if (artists == null) {
			System.out.println("No artists!");
			return;
		}
		for (Artist artist : artists) {
			System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
		}
		
		
		List<String> albumsForArtist = datasource.queryAlbumsForArtist("Iron Maiden", Datasource.ORDER_BY_ASC);
		if (albumsForArtist == null) {
			System.out.println("Error!");
			return;
		}
		for (String albumName : albumsForArtist) {
			System.out.println(albumName);
		}
		
		List<SongArtist> songArtists = datasource.queryArtistForSong("Go Your Own Way", Datasource.ORDER_BY_DESC);
		if (songArtists == null) {
			System.out.println("Error!");
			return;
		}
		for (SongArtist songArtist : songArtists) {
			System.out.println(songArtist.getArtistName() + ", " + songArtist.getAlbumName() + ", Track: " + songArtist.getTrack());
		}
		
		datasource.close();

	}

}
