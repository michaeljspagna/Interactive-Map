package maps.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import maps.MapGUI;
import maps.cities.Cities;
import maps.cities.City;

public class SearchListener implements KeyListener {

	private MapGUI gui;
	private Cities cities;
	public SearchListener(MapGUI gui, Cities cities) {
		this.gui = gui;
		this.cities = cities;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		JComboBox<City> cityBox = gui.getCityBox();
		cityBox.removeAllItems();
		String search = gui.getSearch();
		ArrayList<City> cityList = cities.searchByName(search);
		
		for(int i =0; i<cityList.size(); i++) {
			cityBox.addItem(cityList.get(i));
			
		}
		gui.setComboBox(cityBox);
	}

	
}
