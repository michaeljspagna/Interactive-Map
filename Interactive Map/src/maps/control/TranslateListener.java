package maps.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



import maps.MapGUI;
import maps.tiles.Tile;


public class TranslateListener implements MouseListener{

	private MapGUI gui;
	private int x;
	private int y;
	
	public TranslateListener(MapGUI gui, int x, int y) {
		this.gui = gui;
		this.x = x;
		this.y = y;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		Tile referenceTile = gui.getCenterTile();
		referenceTile.setXTile(referenceTile.getXTile() + x);
		referenceTile.setYTile(referenceTile.getYTile() + y);
		gui.setReferenceTile(referenceTile);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
}
