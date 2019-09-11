package maps.cities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cities {
	private String filename;
	private ArrayList<City> storedCities;
	
	
	public Cities(String filename) {
		this.filename = filename;
		storedCities = new ArrayList<>();
		try {
			for(String lines: Files.readAllLines(Paths.get(this.filename))) {
				String[] cityData = lines.split(",");
				City newCity = new City(Integer.parseInt(cityData[3]), cityData[1], 
						cityData[2], cityData[0], Double.parseDouble(cityData[4]), Double.parseDouble(cityData[5]));
				storedCities.add(newCity);
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public City getDefaultCity() {
		int index = -1;
	
		for(int i=0; i<storedCities.size(); i++) {
			City city = storedCities.get(i);
			if(city.getName().equals("buffalo") && city.getRegion().equals("NY")) {
				index = i;
			}
		}
		return storedCities.get(index);
	}
	
	public ArrayList<City> searchByName(String searchCriteria){
		ArrayList<City> searchedCitiesList = new ArrayList<>();
		for(int i=0; i<this.storedCities.size(); i++) {
			if(storedCities.get(i).getName().contains(searchCriteria)) {
				searchedCitiesList.add(this.storedCities.get(i));
			}
		}
		
		Collections.sort(searchedCitiesList, new Comparator<City>() {

			@Override
			public int compare(City o1, City o2) {
				Integer population1 = o1.getPopulation();
				Integer population2 = o2.getPopulation();
				return population2.compareTo(population1);
			}
			
		});
		return searchedCitiesList;
	}
	
	
	
	public ArrayList<City> getStoredCities() {
		return this.storedCities;
	}
}
