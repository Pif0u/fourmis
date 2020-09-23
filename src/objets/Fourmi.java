package objets;

public abstract class Fourmi {
 
	protected String nom;
    protected int nbNourriturePerso;
    protected int nbNourriturePersoMax;
    protected Cellule position;
    protected Fourmiliere fourmiliere;
	protected Terrain terrain;
    protected boolean rencontreObstacle;


    public void seNourrir() {
        fourmiliere.setStockNourriture(fourmiliere.getStockNourriture() - 1, this);
    }

    
    abstract void supression_nourriture();

    
    public int getNbNourriturePerso() {
        return nbNourriturePerso;
    }	

    public void setNbNourriturePerso(int nourriturePerso) {
        this.nbNourriturePerso = nourriturePerso;
    }

    public int getNourriturePersoMax() {
        return nbNourriturePersoMax;
    }

    public void setNourriturePersoMax(int nourriturePersoMax) {
        this.nbNourriturePersoMax = nourriturePersoMax;
    }

    public Cellule getPosition() {
        return position;
    }

    public void setPosition(Cellule position) {
        this.position = position;
    }

    public void avancer() {
    }

    public void recupererNourriture() {
    }

    public String getNom() {
        return nom;
    }


	public boolean isRencontreObstacle() {
		return rencontreObstacle;
	}


	public void setRencontreObstacle(boolean rencontreObstacle) {
		this.rencontreObstacle = rencontreObstacle;
	}

    


}

