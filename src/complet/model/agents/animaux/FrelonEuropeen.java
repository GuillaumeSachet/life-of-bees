package complet.model.agents.animaux;

import java.awt.Point;
/*
import complet.model.agents.Agent;
import complet.model.agents.Animal;
import complet.model.agents.Etat;
*/
import complet.model.agents.Sexe;

public class FrelonEuropeen extends Frelon {
	
	public FrelonEuropeen(Sexe s, Point p) {
		super(s,p);
		proies.add(FrelonAsiatique.class);
	}
	
	@Override
	public Object clone() {
		return new FrelonEuropeen(getSexe(), new Point(getCoord().getX(),getCoord().getY()));
	}

}
