package maps.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maps.MapGUI;
import maps.cities.City;
import maps.tiles.Tile;

public class CitySelectListener implements ActionListener{

	private MapGUI gui;
	
	public CitySelectListener(MapGUI gui) {
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		City selectedCity = gui.getCityBox().getItemAt(gui.getCityBox().getSelectedIndex());
		Tile cityTile = maps.tiles.TileUtils.getTile(selectedCity);
		gui.setReferenceTile(cityTile);
	}

	
}
