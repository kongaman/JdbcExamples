package best.practice;

import java.util.List;
import java.util.Scanner;

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
		
		datasource.querySongsMetaData();
		
		int count = datasource.getcount(Datasource.TABLE_SONGS);
		System.out.println("Number of songs is: " + count);
		
		datasource.createViewForSongArtists();
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter a song title: ");
//		String title = scanner.nextLine();
//		
//		songArtists = datasource.queryArtistForSong(title, Datasource.ORDER_BY_DESC);
//		if (songArtists == null) {
//			System.out.println("Error!");
//			return;
//		} else if (songArtists.isEmpty()) {
//			System.out.println("Couldn't find the srtist for the song.");
//			return;
//		}
//		for (SongArtist songArtist : songArtists) {
//			System.out.println(songArtist.getArtistName() + ", " + songArtist.getAlbumName() + ", Track: " + songArtist.getTrack());
//		}
		
		datasource.insertSong("Like A Rolling Stone", "Bob Dylan", "Bob Dylan's Greatest Hits", 5);
		
		datasource.close();

	}

}
