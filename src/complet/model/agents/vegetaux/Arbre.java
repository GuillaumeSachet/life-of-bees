package complet.model.agents.vegetaux;

import java.awt.Point;

import complet.model.agents.Animal;
import complet.model.agents.animaux.AbeilleSolitaire;
import complet.model.agents.animaux.Frelon;
import complet.model.comportements.Hebergeur;

public class Arbre extends Vegetal implements Hebergeur{

	private double taille = 1.0;
	private int nbHeberges = 0;
	
	public Arbre(Point point, double taille) {
		super(point);
		this.taille=taille;
	}

	@Override
	public boolean peutAccueillir(Animal a) {
		return (a instanceof AbeilleSolitaire || a instanceof Frelon)&&nbHeberges<getMaxHeberges();
	}

	private int getMaxHeberges() {
		return (int)(Math.pow(taille,2));
	}

	@Override
	public boolean accueillir(Animal a) {
		boolean ret = false;
		if(peutAccueillir(a)) {
			nbHeberges++;
			ret=true;
		}
		return ret;
	}

	public int getWidth() {return (int)(50*taille);}
	public int getHeight() {return (int)(50*taille);}
	
	@Override
	public void produire() {
		qteNectar += Math.pow(2, taille);		
	}

	@Override
	public Object clone() {
		return new Arbre(new Point(getCoord().getX(),getCoord().getY()),taille);
	}
}
