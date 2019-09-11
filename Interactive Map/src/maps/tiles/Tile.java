package maps.tiles;

import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;

public class Tile {
	private int xTile;
	private int yTile;
	private int zoomLevel;
	private String url;
	
	public Tile( int zoomLevel, int xTile, int yTile) {
		this.url = "http://a.tile.openstreetmap.org/";
		this.zoomLevel = zoomLevel;
		this.xTile = xTile;
		this.yTile = yTile;
	}

	public String getTileURL() {
		return this.url + zoomLevel + "/" + xTile + "/" + yTile + ".png";
	}
	
	public int getXTile() {
		return this.xTile;
	}
	
	public void setXTile(int x) {
		this.xTile = x;
	}
	
	public int getYTile() {
		return this.yTile;
	}
	
	public void setYTile(int y) {
		this.yTile = y;
	}
	
	public int getZoomLevel() {
		return this.zoomLevel;
	}
	
	public ImageIcon getImageIcon() {
		ImageIcon image = null;
		try {
			URL mapURL = new URL(getTileURL());
			image = new ImageIcon(mapURL);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	
	@Override
	public String toString() {
		return getTileURL();
	}
	
}
