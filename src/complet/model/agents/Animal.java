package complet.model.agents;

import java.awt.Point;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import complet.model.comportements.Deplacable;
import complet.model.comportements.Hebergeur;

public abstract class Animal extends Agent implements Deplacable {
	
	/** état de santé de l'animal */
	private Etat etat=Etat.Normal;
	/** sexe de l'animal */
	private Sexe sexe;
	/** hebergeur de l'animal */
	//protected Hebergeur hebergeur;
	protected Hebergeur hebergeur;
	
	/* 
	 * constructeurs 
	 */
	public Animal(Sexe sexe, Point p) {
		super(p);
		this.sexe=sexe;
	}
	
	public Animal(Sexe sexe) {
		this(sexe,new Point(0,0));
		//TODO
	}
	
	public Animal() {
		this(Sexe.Femelle);
	}
	
	/*
	 *  Accesseurs et mutateurs
	 */
	public Sexe getSexe() {
		return sexe;
	}
	
	public Etat getNiveauSante() {return etat;}
	/**
	 * protected, car seul l'animal doit pouvoir changer son niveau de santé
	 * @return
	 */
	protected void setNiveauSante(Etat e) {etat = e;}
	
	public String toString() {
		return super.toString()+", "+sexe;
	}
	
	/* 
	 * comportements d'instance
	 */
	/**
	 * déplacement aléatoire avec -1<=dx<=1 et  -1<=dy<=1
	 * @see complet.model.comportements.Deplacable#seDeplacer()
	 */
	public void seDeplacer() {
		int aleaX = (int)(Math.random()*3)-1;
		int aleaY = (int)(Math.random()*3)-1;
		this.setCoord((int)(coord.getX()+aleaX),(int)(coord.getY()+aleaY));
	}
	/**
	 * condition d'installation d'un animal dans un hébergeur
	 * @param h
	 * @return
	 */

	protected final boolean sInstaller(Hebergeur hebergeur) {
		boolean ret=false;
		if(hebergeur!= null && hebergeur.accueillir(this)) {
			this.hebergeur = hebergeur;
			ret=true;
		}
		return ret;
	}
	
	protected final void aggraverEtat() {
		LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values()));
		Iterator<Etat> it = liste.listIterator(liste.indexOf(etat));
		if(it.hasNext()) {
			it.next();
			if(it.hasNext()) {
				etat=it.next();
			}
		}
	}
	
	protected final void ameliorerEtat() {
		LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values()));
		ListIterator<Etat> it = liste.listIterator(liste.indexOf(etat));
		if(it.hasPrevious()) {etat = it.previous();}
		
	}


}
