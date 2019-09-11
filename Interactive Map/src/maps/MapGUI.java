package maps;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import maps.cities.Cities;
import maps.cities.City;
import maps.control.CitySelectListener;
import maps.control.SearchListener;
import maps.control.TranslateListener;
import maps.tiles.Tile;

public class MapGUI {
	private Cities cities;
	private JPanel searchPanel;
	private JPanel mapPanel;
	private JComboBox<City> cityBox;
	private JTextField searchField;
	private JLabel mapLabel0;
	private JLabel mapLabel1;
	private JLabel mapLabel2;
	private JLabel mapLabel3;
	private JLabel mapLabel4;
	private JLabel mapLabel5;
	private JLabel mapLabel6;
	private JLabel mapLabel7;
	private JLabel mapLabel8;
	private JButton searchButton;
	private ArrayList<Tile> tileList;
	private Tile centerTile;
	
	public MapGUI(Cities cities) {
		this.cities = cities;
		this.searchPanel = new JPanel();
		this.mapPanel = new JPanel();
		cityBox = new JComboBox<>();
		searchField = new JTextField(10);
		mapLabel0 = new JLabel();
		mapLabel1 = new JLabel();
		mapLabel2 = new JLabel();
		mapLabel3 = new JLabel();
		mapLabel4 = new JLabel();
		mapLabel5 = new JLabel();
		mapLabel6 = new JLabel();
		mapLabel7 = new JLabel();
		mapLabel8 = new JLabel();
		searchButton = new JButton("Go!");
		tileList = new ArrayList<>();
		
		setDefaultMap();
		
	}
	
	public JPanel getSearchPanel() {
		
		SearchListener searchListener = new SearchListener(this, cities);
		this.searchField.addKeyListener(searchListener);
		
		CitySelectListener cityListener = new CitySelectListener(this);
		this.searchButton.addActionListener(cityListener);
		
		this.searchPanel.add(searchField);;
		this.searchPanel.add(cityBox);
		this.searchPanel.add(searchButton);
		return this.searchPanel;
	}
	
	public JComboBox<City> getCityBox(){
		return this.cityBox;
	}
	
	public void setComboBox(JComboBox<City> cityBox) {
		this.cityBox = cityBox;
	}
	
	public String getSearch() {
		return searchField.getText();
	}
	
	public JPanel getMapPanel() {
		GridLayout mapLayout = new GridLayout(3,3);
		mapPanel.setLayout(mapLayout);
		mapPanel.add(mapLabel0);
		TranslateListener click0 = new TranslateListener(this, -1, -1);
		mapLabel0.addMouseListener(click0);
		mapPanel.add(mapLabel1);
		TranslateListener click1 = new TranslateListener(this, 0, -1);
		mapLabel1.addMouseListener(click1);
		mapPanel.add(mapLabel2);
		TranslateListener click2 = new TranslateListener(this, 1, -1);
		mapLabel2.addMouseListener(click2);
		mapPanel.add(mapLabel3);
		TranslateListener click3 = new TranslateListener(this, -1, 0);
		mapLabel3.addMouseListener(click3);
		mapPanel.add(mapLabel4);
		TranslateListener click4 = new TranslateListener(this, 0, 0);
		mapLabel4.addMouseListener(click4);
		mapPanel.add(mapLabel5);
		TranslateListener click5 = new TranslateListener(this, 1, 0);
		mapLabel5.addMouseListener(click5);
		mapPanel.add(mapLabel6);
		TranslateListener click6 = new TranslateListener(this, -1, 1);
		mapLabel6.addMouseListener(click6);
		mapPanel.add(mapLabel7);
		TranslateListener click7 = new TranslateListener(this, 0, 1);
		mapLabel7.addMouseListener(click7);
		mapPanel.add(mapLabel8);
		TranslateListener click8 = new TranslateListener(this, 1, 1);
		mapLabel8.addMouseListener(click8);
		return this.mapPanel;
	}
	
	public void setReferenceTile(Tile tile) {
		this.tileList = maps.tiles.TileUtils.getTileMap(tile);
		centerTile = tileList.get(4);
		mapLabel0.setIcon(tileList.get(0).getImageIcon());
		mapLabel1.setIcon(tileList.get(1).getImageIcon());
		mapLabel2.setIcon(tileList.get(2).getImageIcon());
		mapLabel3.setIcon(tileList.get(3).getImageIcon());
		mapLabel4.setIcon(tileList.get(4).getImageIcon());	
		mapLabel5.setIcon(tileList.get(5).getImageIcon());
		mapLabel6.setIcon(tileList.get(6).getImageIcon());
		mapLabel7.setIcon(tileList.get(7).getImageIcon());
		mapLabel8.setIcon(tileList.get(8).getImageIcon());
		
	}

	public ArrayList<Tile> getTileList(){
		return this.tileList;
	}
	
	public Tile getCenterTile() {
		return this.centerTile;
	}
	
	public void setDefaultMap() {
		setReferenceTile(maps.tiles.TileUtils.getTile(cities.getDefaultCity()));
	}
	
	
}
