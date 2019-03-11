package complet.model.comportements;
import complet.model.agents.Animal;
import complet.model.agents.PointPositif;

/**
 * un hébergeur peut accueillir un animal
 * @author guillaume
 *
 */

public interface Hebergeur {
	/**
	 * Renvoie vrai si a peut être acceuilli
	 * Il s'agit d'un test de faisabilité
	 * (l'animal doit répondre aux conditions)
	 * @param t Animal candidat à l'accueil
	 * @return
	 */
	public boolean peutAccueillir(Animal a);
	/**
	 * Animal a demande à être hébergé par l'herbergeur
	 * Si l'hébergeur accepte, renvoie true
	 * @param t
	 * @return
	 */
	public boolean accueillir(Animal a);
	/**
	 * renvoie les coordonnées de l'hébergeur
	 * @return
	 */
	public PointPositif getCoord();
	
	
}
