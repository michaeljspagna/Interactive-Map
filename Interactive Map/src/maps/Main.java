package maps;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import maps.cities.Cities;
import maps.cities.City;
import maps.tiles.Tile;
import maps.tiles.TileUtils;


public class Main {

	public static void runGUI() {
		JFrame frame = new JFrame("Interactive Map");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        String filename = "src/cities.csv";
        Cities cities = new Cities(filename);
        MapGUI gui = new MapGUI(cities);
       
        
        frame.add(gui.getSearchPanel(),BorderLayout.NORTH);
        frame.add(gui.getMapPanel(), BorderLayout.CENTER);
        frame.pack();

	}
	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                runGUI();
            }
        });	
		
		
		
	}
	
}
