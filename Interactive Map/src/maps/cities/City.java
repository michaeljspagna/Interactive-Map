package maps.cities;


public class City {
	private int population;
	private String name;
	private String region;
	private String country;
	private double latitude;
	private double longitude;

	
	public City(int population, String name, String region, String country, double latitude, double longitude) {
		this.population = population;
		this.name = name;
		this.region = region;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getPopulation() {
		return this.population;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRegion() {
		return this.region;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	
	@Override
	public String toString() {
		return Integer.toString(getPopulation()) + " " + "-" + " "  + getName() + "," +
				" " + getRegion() + "," + " " + getCountry();
	}
}
