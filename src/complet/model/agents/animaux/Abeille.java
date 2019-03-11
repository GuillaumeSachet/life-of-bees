package complet.model.agents.animaux;

import java.awt.Point;

import complet.model.agents.Agent;
import complet.model.agents.Animal;
import complet.model.agents.Etat;
import complet.model.agents.Sexe;
import complet.model.agents.vegetaux.Vegetal;
import complet.model.comportements.Hebergeur;

public abstract class Abeille extends Animal implements Hebergeur{
	/**
	 * parasite éventuel de l'abeille
	 * si l'abeille est parasitée, passe à true
	 */
	private boolean parasite=false;
	/**
	 * quantité de miel transporté par l'abeille
	 */
	private int qteMiel = 0;
	/**
	 * constante donnant la quantité maximal de miel que l'abeille peut transporter
	 */
	private static final int qteMax = 10;
	
	public Abeille(Sexe s, Point p) {
		super(s,p);
	}

	@Override
	public void rencontrer(Agent a) {
		/* rencontres */
		if(a instanceof Vegetal && qteMiel<Abeille.qteMax) {
			Vegetal v = (Vegetal)a;
			qteMiel = qteMiel + v.getPortionNectar();
		}
		/* rencontre avec un prédateur */
		else if(a instanceof Frelon && getNiveauSante()!=Etat.Mourant) {
			setNiveauSante(Etat.EnDetresse);
			if (a.aFaim()) {setNiveauSante(Etat.Mourant);}
		}
	}

	
	@Override
	public boolean peutAccueillir(Animal a) {
		//
		// l'abeille n'a pas de parasite et l'animal est un Varroa
		//
		return a instanceof Varroa && !parasite;
	}
	

	
	@Override
	public boolean accueillir(Animal a) {
		boolean ret = false;
		if(peutAccueillir(a)) {
			parasite = true;
			aggraverEtat();
			ret = true;
		}
		return ret;
	}

	
	@Override
	protected void maj() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void seNourrir() {
		// TODO Auto-generated method stub
		
	}

}
