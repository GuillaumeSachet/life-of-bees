package complet.model.agents.animaux;

import java.awt.Point;

import complet.model.agents.Sexe;

public class AbeilleSolitaire extends Abeille{

	public AbeilleSolitaire(Sexe s, Point p) {
		super(s, p);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Object clone() {
		return new AbeilleSolitaire(getSexe(), new Point(getCoord().getX(),getCoord().getY()));
	}

}
