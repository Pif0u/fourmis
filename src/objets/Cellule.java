package objets;

import gui.LancementProg;

/**
 * Classe Cellule
 * @author Pifou
 *
 */
public class Cellule {
	private int x;
	private int y;
	private double nbPheromones;
	private int nbNourriture;
	private double nbPheromonesMax;
	private double tauxEvaporationPheromones;
	private boolean obstacle;

	/**
	 * 
	 * Constructeur qui décrit les caractéristiques d'une cellule
	 * 
	 * @param x Position en x de la cellule
	 * @param y Position en y de la cellule
	 * @param nbNourriture Nombre de nourriture présent dans la cellule
	 * @param nbPheromones Nombre de phéromones présent dans la cellule
	 * @param obstacle si la cellule contient un obstacle
	 */

	public Cellule(int x, int y, int nbNourriture, double nbPheromones,boolean obstacle) {
		this.nbPheromonesMax = LancementProg.config.nbPheromonesMax;
		this.tauxEvaporationPheromones = LancementProg.config.tauxEvaporationPheromones;
		this.x = x;
		this.y = y;
		this.nbNourriture = nbNourriture;
		this.nbPheromones = nbPheromones;
		this.obstacle = obstacle;
	}


	/**
	 * Méthode qui permet de modifier le nombre de nourriture
	 * @param nourriture Nombre de nourriture dans une cellule
	 */
	public void setNourriture(int nourriture) {
		this.nbNourriture = nourriture;
	}

	/**
	 * 
	 * @return Le nombre de nourriture
	 */
	public int getNourriture() {
		return nbNourriture;
	}

	/**
	 * Méthode qui permet de modifier le nombre de nourriture
	 * @param nbPheromones Nombre de ph�romone dans une cellule
	 */
	public void setNbPheromones(double nbPheromones) {
		this.nbPheromones = nbPheromonesMax < this.nbPheromones + nbPheromones ? this.nbPheromonesMax : nbPheromones;
	}

	/**
	 * Recupère le taux d'évaporation dans la classe "Parametres" pour d�terminer le nombre de Ph�romones
	 */
	public void evaporationPheromones() {
		this.tauxEvaporationPheromones = LancementProg.config.tauxEvaporationPheromones;
		this.nbPheromones *= tauxEvaporationPheromones;
	}

	/**
	 * 
	 * @return Le nombre de Phéromones
	 */
	public double getNbPheromones() {
		return nbPheromones;
	}

	/**
	 * 
	 * @return La valeur de obstacle.
	 */
	public boolean getObstacle() {
		return obstacle;
	}

	/**
	 * 
	 * @return La coordonnéee x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Pour indiquer la coordonnéee x
	 * @param y La coordonnéee x 
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return La coordonnéee y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Pour indiquer la coordonnéee y
	 * @param y La coordonnéee y 
	 */
	public void setY(int y) {
		this.y = y;
	}
}

