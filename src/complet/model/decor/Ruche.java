package complet.model.decor;

import java.awt.Point;
import java.util.HashSet;

import complet.model.agents.Animal;
import complet.model.agents.Sexe;
import complet.model.agents.animaux.AbeilleDomestique;
import complet.model.comportements.Hebergeur;

public class Ruche extends Decor implements Hebergeur{
	
	/**
	 * Liste des abeilles de la ruche 
	 */
	private HashSet<AbeilleDomestique>population;
	/**
	 * constante taille maximale de la ruche
	 */
	private static int populationMax = 1000;
	
	public Ruche(Point p) {
		super(p);
		population = new HashSet<AbeilleDomestique>();
	}

	@Override
	public boolean peutAccueillir(Animal a) {
		return a instanceof AbeilleDomestique && 
				population.size()<Ruche.populationMax && //population ok
				!population.contains(a);//l'abeille n'appartient pas déjà à la ruche
	}

	@Override
	public boolean accueillir(Animal a) {
		boolean ret = false;
		if(peutAccueillir(a)) {
			population.add((AbeilleDomestique)a);
			ret=true;
		}
		return ret;
	}
	
	public String toString() {
		String ret = "Ruche "+getCoord()+" : population "+population.size()+" abeilles\n";
		for(AbeilleDomestique ad:population) {
			ret +="\t*"+ad+"\n";
		}
		return ret;
	}
	
	public static void main(String[] a) {
		Ruche r = new Ruche(new Point(0,0));
		new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r);
		System.out.println(r);
		new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r);
		System.out.println(r);
		new AbeilleDomestique(Sexe.Femelle, new Point(5,10),r);
		System.out.println(r);
	}
}
