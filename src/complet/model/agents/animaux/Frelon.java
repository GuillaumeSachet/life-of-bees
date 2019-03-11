package complet.model.agents.animaux;

import java.awt.Point;
import java.util.ArrayList;

import complet.model.agents.Agent;
import complet.model.agents.Animal;
import complet.model.agents.Sexe;

public abstract class Frelon extends Animal {
	/**
	 * list de Class telles que la classe hérite de Animal
	 */
	protected ArrayList<Class<? extends Animal>> proies;
	
	public Frelon(Sexe s,Point p) {
		super(s,p);
		proies = new ArrayList<Class<? extends Animal>>();
		proies.add(AbeilleDomestique.class);
		proies.add(AbeilleSolitaire.class);
	}
	
	@Override
	public void rencontrer(Agent a) {
		try {
			gestionProie((Animal)a);
		}
		catch (ClassCastException cce) {
			System.err.println(a+" n'est pas un Animal");
		}
		
	}
	
	protected void gestionProie(Animal a) {
		//si le frelon a faim et qu'il a bien affaire à une proie
		if(faim && proies.contains(a.getClass())) {
			faim=false;
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
	
	public int getWidth() {return 30;}
	public int getHeight() {return 30;}
	
	public static void main(String[]a)
	{
		new FrelonAsiatique(Sexe.Assexue,new Point(0,0));
	}
}
