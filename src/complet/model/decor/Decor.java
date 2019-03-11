package complet.model.decor;

import java.awt.Point;
import complet.model.agents.PointPositif;
import complet.model.world.Dessinable;

public abstract class Decor implements Dessinable{
	/**
	 * coordonnées de l'élément de décor
	 */
	private PointPositif coord;

	public Decor(Point p) {
		coord = new PointPositif(p);
	}
	
	public PointPositif getCoord() {
		return (PointPositif)coord.clone();
	}
	
	public String getImage() {
		return "images/"+getClass().getSimpleName()+".gif";
	}
	
	public int getWidth() {return 50;}
	public int getHeight() {return 50;}

}
