package objets;


import java.util.LinkedList;

import gui.LancementProg;
public class Ouvriere
extends Fourmi {
    /**
	 * 
	 */
	private LinkedList<Cellule> cheminSuivi = new LinkedList<Cellule>();
    private int directionMarche;
    private Cellule[] cellulesalentours = new Cellule[8];
    private double[] probabiliteSuivantDirection = new double[8];
    private double nbPheromonesDeposee;
    protected int nbNourritureTransportee;
    protected int nbNourritureTransporteeMax;
    protected Cellule dernierePosition;
    private int etat;

    public Ouvriere(String nom) {
        this.rencontreObstacle = false;
        this.nbNourriturePerso = nbNourriturePersoMax = LancementProg.config.nbNourriturePersoMax + (int)(Math.random() * (double)LancementProg.config.nbNourriturePersoMax);
        this.nbNourritureTransporteeMax = LancementProg.config.nbNourritureTransporteeMax;
        this.nbNourritureTransportee = LancementProg.config.nbNourritureTransportee;
        this.fourmiliere = LancementProg.config.fourmiliere;
        this.terrain = LancementProg.config.terrain;
        this.nbPheromonesDeposee = LancementProg.config.nbPheromoneDeposee;
        LancementProg.config.ensembleFourmi.ajouterFourmi(this);
        this.nom = nom;
        this.position = LancementProg.config.fourmiliere.getPosition();
        fixerAlentours();
        cheminSuivi.add(this.position);
        double[] choixDirection = new double[8];
        int k = 0;
        while (k < 8) {
            choixDirection[k] = cellulesalentours[k].getNbPheromones() + Math.random() * 2.0 * nbPheromonesDeposee;
            ++k;
        }
        this.directionMarche = Ouvriere.getIndMax(choixDirection);
       this.etat = 0;
    }

    /*
     * Sert à avoir les informations sur les 8 cases autour de la fourmi.
     */
    public void fixerAlentours() {
    	
	        if (position.getX() + 1 < terrain.getTaille()[0] && position.getX() > 0 && position.getY() + 1 < terrain.getTaille()[1] && position.getY() > 0) {
	            cellulesalentours[0] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY() - 1];
	            cellulesalentours[1] = terrain.getCellulesTerrain()[position.getX()][position.getY() - 1];
	            cellulesalentours[2] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY() - 1];
	            cellulesalentours[3] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY()];
	            cellulesalentours[4] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY() + 1];
	            cellulesalentours[5] = terrain.getCellulesTerrain()[position.getX()][position.getY() + 1];
	            cellulesalentours[6] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY() + 1];
	            cellulesalentours[7] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY()];
	            
	        } else {
	            if (position.getX() + 1 > terrain.getTaille()[0]) {
	                cellulesalentours[0] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY() - 1];
	                cellulesalentours[1] = terrain.getCellulesTerrain()[position.getX()][position.getY() - 1];
	                cellulesalentours[2] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY() - 1];
	                cellulesalentours[3] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY()];
	                cellulesalentours[4] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY() + 1];
	                cellulesalentours[5] = terrain.getCellulesTerrain()[position.getX()][position.getY() + 1];
	                cellulesalentours[6] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY() + 1];
	                cellulesalentours[7] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY()];
	            }
	            if (position.getX() < 0) {
	                cellulesalentours[0] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY() - 1];
	                cellulesalentours[1] = terrain.getCellulesTerrain()[position.getX()][position.getY() - 1];
	                cellulesalentours[2] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY() - 1];
	                cellulesalentours[3] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY()];
	                cellulesalentours[4] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY() + 1];
	                cellulesalentours[5] = terrain.getCellulesTerrain()[position.getX()][position.getY() + 1];
	                cellulesalentours[6] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY() + 1];
	                cellulesalentours[7] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY()];
	            }
	            if (position.getY() + 1 > terrain.getTaille()[1]) {
	                cellulesalentours[0] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY() - 1];
	                cellulesalentours[1] = terrain.getCellulesTerrain()[position.getX()][position.getY() - 1];
	                cellulesalentours[2] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY() - 1];
	                cellulesalentours[3] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY()];
	                cellulesalentours[4] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY() - 1];
	                cellulesalentours[5] = terrain.getCellulesTerrain()[position.getX()][position.getY() - 1];
	                cellulesalentours[6] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY() - 1];
	                cellulesalentours[7] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY()];
	            }
	            if (position.getY() < 0) {
	                cellulesalentours[0] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY() + 1];
	                cellulesalentours[1] = terrain.getCellulesTerrain()[position.getX()][position.getY() + 1];
	                cellulesalentours[2] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY() + 1];
	                cellulesalentours[3] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY()];
	                cellulesalentours[4] = terrain.getCellulesTerrain()[position.getX() + 1][position.getY() + 1];
	                cellulesalentours[5] = terrain.getCellulesTerrain()[position.getX()][position.getY() + 1];
	                cellulesalentours[6] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY() + 1];
	                cellulesalentours[7] = terrain.getCellulesTerrain()[position.getX() - 1][position.getY()];
	            }
	        }
	        probabiliteSuivantDirection[(directionMarche - 3 + 8) % 8] = 1.0;
	        probabiliteSuivantDirection[(directionMarche - 2 + 8) % 8] = 2.0;
	        probabiliteSuivantDirection[(directionMarche - 1 + 8) % 8] = 6.0;
	        probabiliteSuivantDirection[directionMarche] = 12.0;
	        probabiliteSuivantDirection[(directionMarche + 1 + 8) % 8] = 6.0;
	        probabiliteSuivantDirection[(directionMarche + 2 + 8) % 8] = 2.0;
	        probabiliteSuivantDirection[(directionMarche + 3 + 8) % 8] = 1.0;
	        probabiliteSuivantDirection[(directionMarche + 4 + 8) % 8] = 0.0;
    	
    }

    /*
     * Algorithme déplacement fourmis
     * @see objets.Fourmi#avancer()
     */
    public void avancer() {
        int k;
        double[] choixDirection;
        supression_nourriture();
        fixerAlentours();
        recupererNourriture(position);
        if (etat == 0) {
            if (nbNourritureTransportee != 0 || (double)nbNourriturePerso < (double)nbNourriturePersoMax / (1.5 + 2.0 * Math.random())) {
                etat = 1;
                if (nbNourritureTransportee > 0) {
                    deposerPheromone();
                }
                cheminSuivi.removeLast();
                dernierePosition = position;
                position = cheminSuivi.getLast();
            } else {
                choixDirection = new double[8];
                k = 0;
                while (k < 8) {
                	if (cellulesalentours[k].getObstacle()) {
                		k++;
                		rencontreObstacle = true;
                	} else {
                    choixDirection[k] = Math.random() * probabiliteSuivantDirection[k] * (1.0 + 1.0 * cellulesalentours[k].getNbPheromones());
            		rencontreObstacle = false;
                    ++k;
                	}
                }
                directionMarche = Ouvriere.getIndMax(choixDirection);
                dernierePosition = position;
                position = cellulesalentours[directionMarche];
                cheminSuivi.add(position);
            }
        } else if (etat == 1) {
            cheminSuivi.removeLast();
            if (cheminSuivi.isEmpty()) {
                etat = 2;
            } else {
                if (nbNourritureTransportee > 0) {
                    deposerPheromone();
                }
                dernierePosition = position;
                position = cheminSuivi.getLast();
            }
        }
        if (etat == 2) {
            if (nbNourritureTransportee > 0) {
                directionMarche = (trouverDirectionMarche(position, dernierePosition) + 4) % 8;
            } else {
                choixDirection = new double[8];
                k = 0;
                while (k < 8) {
                	if (cellulesalentours[k].getObstacle()) {
                		k++;
                		rencontreObstacle = true;
                	} else {
                		choixDirection[k] = cellulesalentours[k].getNbPheromones() + Math.random() * 2.0 * LancementProg.config.nbPheromoneDeposee;
                		rencontreObstacle = false;
                    ++k;
                	}
                }
                directionMarche = Ouvriere.getIndMax(choixDirection);
            }
 
            deposerNourritureDansFourmiliere(nbNourritureTransportee);
            seNourrir();
            if (nbNourriturePerso == nbNourriturePersoMax) {
                dernierePosition = position;
                position = cellulesalentours[directionMarche];
                cheminSuivi.add(fourmiliere.getPosition());
                cheminSuivi.add(position);
                etat = 0;
            }
        }
    }

    public int trouverDirectionMarche(Cellule celluleActuelle, Cellule cellulePassee) {
        int diffX = celluleActuelle.getX() - cellulePassee.getX();
        int diffY = celluleActuelle.getY() - cellulePassee.getY();
        int bonneDirection = 8;
        if (diffX == -1 && diffY == -1) {
            bonneDirection = 0;
        }
        if (diffX == -1 && diffY == 0) {
            bonneDirection = 7;
        }
        if (diffX == -1 && diffY == 1) {
            bonneDirection = 6;
        }
        if (diffX == 0 && diffY == -1) {
            bonneDirection = 1;
        }
        if (diffX == 0 && diffY == 1) {
            bonneDirection = 5;
        }
        if (diffX == 1 && diffY == -1) {
            bonneDirection = 2;
        }
        if (diffX == 1 && diffY == 0) {
            bonneDirection = 3;
        }
        if (diffX == 1 && diffY == 1) {
            bonneDirection = 4;
        }
        return bonneDirection;
    }

    public void recupererNourriture(Cellule cellule) {
        if (position.getNourriture() > 0 && nbNourritureTransportee == 0) {
            if (position.getNourriture() > nbNourritureTransporteeMax) {
                cellule.setNourriture(cellule.getNourriture() - nbNourritureTransporteeMax);
                setNourritureTransportee(nbNourritureTransporteeMax);
            } else {
                setNourritureTransportee(position.getNourriture());
                cellule.setNourriture(0);			
            }
        }
    }

    public void deposerPheromone() {
        position.setNbPheromones(position.getNbPheromones() + nbPheromonesDeposee);
    }

    public void supression_nourriture() {
        --nbNourriturePerso;
    }

    public void deposerNourritureDansFourmiliere(int quantite) {
        fourmiliere.setStockNourriture(fourmiliere.getStockNourriture() + quantite);
        setNourritureTransportee(0);
    }

    public static int getIndMax(double[] tableau) {
        double max = tableau[0];
        int ind = 0;
        int i = 1;
        while (i < tableau.length) {
            if (tableau[i] > max) {
                max = tableau[i];
                ind = i;
            }
            ++i;
        }
        return ind;
    }

    public int getNourritureTransportee() {
        return nbNourritureTransportee;
    }

    public void setNourritureTransportee(int nourritureTransportee) {
        this.nbNourritureTransportee = nourritureTransportee;
    }

	public boolean isRencontreObstacle() {
		return rencontreObstacle;
	}

	public void setRencontreObstacle(boolean rencontreObstacle) {
		this.rencontreObstacle = rencontreObstacle;
	}
    
}

