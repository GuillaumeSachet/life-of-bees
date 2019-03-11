package complet.model.agents.animaux;

import java.awt.Point;

import complet.model.agents.Agent;
import complet.model.agents.Animal;
import complet.model.agents.Sexe;
import complet.model.comportements.Hebergeur;

public class Varroa extends Animal {
		
	public Varroa(Sexe s, Point p) {
		super(s,p);
	}
	
	@Override
	public void rencontrer(Agent a) {
		if(a instanceof Abeille) {
			Hebergeur candidateAuParasitage = (Hebergeur) a;
			this.sInstaller(candidateAuParasitage);
		}

	}

	@Override
	protected void maj() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void seNourrir() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * si le Varroa a un hébergeur, il se déplace avec l'abeille
	 */
	public void seDeplacer() {
		if(hebergeur!=null) {
			coord=hebergeur.getCoord();
		}
		else {super.seDeplacer();}
	}
	
	@Override
	public Object clone() {
		return new Varroa(getSexe(), new Point(getCoord().getX(),getCoord().getY()));
	}
}
