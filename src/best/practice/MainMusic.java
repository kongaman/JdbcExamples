package best.practice;

import java.util.List;

import best.practice.model.Artist;
import best.practice.model.Datasource;

public class MainMusic {

	public static void main(String[] args) {
		Datasource datasource = new Datasource();
		if (!datasource.open()) {
			System.err.println("Can't open datasource.");
			return;
		}
		
		List<Artist> artists = datasource.queryArtists();
		if (artists == null) {
			System.out.println("No artists!");
			return;
		}
		for (Artist artist : artists) {
			System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
		}
		
		datasource.close();

	}

}
