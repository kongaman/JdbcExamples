package best.practice;

import best.practice.model.Datasource;

public class MainMusic {

	public static void main(String[] args) {
		Datasource datasource = new Datasource();
		if (!datasource.open()) {
			System.err.println("Can't open datasource.");
			return;
		}
		
		datasource.close();

	}

}
