package maps.tiles;

import java.util.ArrayList;

import maps.cities.City;

public class TileUtils {

	public static Tile getTile(City city) {
		int z = Zoom.zoom;
		double x = ((city.getLongitude()+180)/360) * Math.pow(2, z);
		double inLog1  = Math.tan(city.getLatitude()*(Math.PI/180));
		double inLog2 = 1/(Math.cos(city.getLatitude()*(Math.PI/180)));
		double log = Math.log(inLog1+inLog2);
		double y = ((1-(log/Math.PI))*Math.pow(2, z-1));
		if(x<0) {
			x=0;
		}
		if(x>=Math.pow(2, z)) {
			x=Math.pow(2, z)-1;
		}
		if(y<0) {
			y=0;
		}
		if(y>=Math.pow(2, z)) {
			y=Math.pow(2, z)-1;
		}

		int xTile = (int) x;
		int yTile = (int) y;
		Tile newTile = new Tile(z, xTile, yTile);
		return newTile;
	}
	
	public static ArrayList<Tile> getTileMap(Tile tile){
		ArrayList<Tile> tileList = new ArrayList<>();
		int xTile = tile.getXTile();
		int yTile = tile.getYTile();
		int z = tile.getZoomLevel();
		
		for(int y = yTile-1; y<yTile+2; y++) {
			
			if(y<0) {
				y=(int) Math.pow(2, z)-1;
			}
			if(y>=Math.pow(2, z)) {
				y=0;
			}
			for(int x = xTile-1; x<xTile+2; x++) {
				if(x<0) {
					x=(int) Math.pow(2, z)-1;
				}
				if(x>=Math.pow(2, z)) {
					x=0;
				}
				Tile newTile = new Tile(z,x,y);
				tileList.add(newTile);
			}
		}
		return tileList;
	}
	
	
	
}
