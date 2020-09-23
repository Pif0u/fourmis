package objets;



import gui.LancementProg;
import org.apache.log4j.Logger;


public class Fourmiliere {
 
	private int stockNourriture;
    private Cellule position;
    
    private static Logger logger = Logger.getLogger(Fourmiliere.class);


    public Fourmiliere(int stockNourriture, Cellule position) {
        this.stockNourriture = stockNourriture;
        this.position = position;
    }

    public void setStockNourriture(int nouveauStockNourriture, Fourmi fourmi) {
        if (stockNourriture - nouveauStockNourriture > 0) {
            if (nouveauStockNourriture < 0) {
                logger.error("PLUS DE STOCK");
                LancementProg.config.resetTerrain();
                LancementProg.config.pause = true;
                LancementProg.config.pause = false;
                
            } else {
                this.stockNourriture = nouveauStockNourriture;
                fourmi.setNbNourriturePerso(fourmi.getNourriturePersoMax());
            }
        }
    }

    public void setStockNourriture(int stockNourriture) {
        this.stockNourriture = stockNourriture;
    }

    public int getStockNourriture() {
        return stockNourriture;
    }


    public void setPosition(Cellule position) {
        this.position = position;
    }

    public Cellule getPosition() {
        return position;
    }
}

