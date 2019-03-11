package complet.model.agents.animaux;

import java.awt.Point;

import complet.model.agents.Sexe;
import complet.model.decor.Ruche;

public class AbeilleDomestique extends Abeille {

	public AbeilleDomestique(Sexe s, Point p, Ruche r) {
		super(s, p);
		sInstaller(r);
	}

	@Override
	public Object clone() {
		return new AbeilleDomestique(getSexe(), new Point(getCoord().getX(),getCoord().getY()), (Ruche)hebergeur);
	}

}
