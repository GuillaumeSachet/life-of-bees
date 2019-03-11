package complet.model.world;

import complet.model.agents.PointPositif;

public interface Dessinable {
	/**
	 * adresse de l'image
	 * @return
	 */
	public String getImage();
	/**
	 * coordonnée de l'élément dessinable
	 * @return
	 */
	public PointPositif getCoord();
	/**
	 * hauteur de l'image
	 * @return
	 */
	public int getHeight();
	/**
	 * longueur de l'image
	 * @return
	 */
	public int getWidth();

}
