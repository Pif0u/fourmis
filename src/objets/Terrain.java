package objets;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gui.LancementProg;

public class Terrain {
  
	private int[] tailleTerrainCellules;
    private Cellule[][] cellulesTerrain;
    double rapportX;
    double rapportY;
    Logger logger = LogManager.getLogger();


    public Terrain() {
        this.tailleTerrainCellules = LancementProg.config.tailleTerrainCellules;
        this.cellulesTerrain = new Cellule[this.tailleTerrainCellules[0]][this.tailleTerrainCellules[1]];
        int k = 0;
        while (k <= this.tailleTerrainCellules[0] - 1) {
            int i = 0;
            while (i <= this.tailleTerrainCellules[1] - 1) {
                this.cellulesTerrain[k][i] = new Cellule(k, i, 0, 0.0,false);
                ++i;
            }
            ++k;
        }
        
        logger.debug("Toutes les cellules ont été inialisées");
        
        this.cellulesTerrain[4][39] = new Cellule(4, 39, 0, 0.0,true);
        this.cellulesTerrain[5][39] = new Cellule(5, 39, 0, 0.0,true);
        this.cellulesTerrain[5][38] = new Cellule(5, 38, 0, 0.0,true);
        this.cellulesTerrain[5][37] = new Cellule(5, 37, 0, 0.0,true);
        this.cellulesTerrain[6][39] = new Cellule(6, 39, 0, 0.0,true);
        this.cellulesTerrain[6][38] = new Cellule(6, 38, 0, 0.0,true);
        this.cellulesTerrain[7][38] = new Cellule(7, 38, 0, 0.0,true);
        this.cellulesTerrain[7][39] = new Cellule(7, 39, 0, 0.0,true);
        this.cellulesTerrain[8][39] = new Cellule(8, 39, 0, 0.0,true);
        
        this.cellulesTerrain[8][17] = new Cellule(8, 17, 0, 0.0,true);
        this.cellulesTerrain[8][18] = new Cellule(8, 18, 0, 0.0,true);
        this.cellulesTerrain[8][16] = new Cellule(8, 16, 0, 0.0,true);
        this.cellulesTerrain[8][15] = new Cellule(8, 15, 0, 0.0,true);
        this.cellulesTerrain[8][14] = new Cellule(8, 14, 0, 0.0,true);
        
        this.cellulesTerrain[9][15] = new Cellule(9, 15, 0, 0.0,true);
        this.cellulesTerrain[9][16] = new Cellule(9, 16, 0, 0.0,true);
        this.cellulesTerrain[9][17] = new Cellule(9, 17, 0, 0.0,true);
        this.cellulesTerrain[9][14] = new Cellule(9, 14, 0, 0.0,true);
        this.cellulesTerrain[9][13] = new Cellule(9, 13, 0, 0.0,true);

        this.cellulesTerrain[10][10] = new Cellule(10, 10, 0, 0.0,true);
        this.cellulesTerrain[10][11] = new Cellule(10, 11, 0, 0.0,true);
        this.cellulesTerrain[10][12] = new Cellule(10, 12, 0, 0.0,true);
        this.cellulesTerrain[10][13] = new Cellule(10, 13, 0, 0.0,true);
        this.cellulesTerrain[10][14] = new Cellule(10, 14, 0, 0.0,true);
        this.cellulesTerrain[10][15] = new Cellule(10, 15, 0, 0.0,true);
        this.cellulesTerrain[10][16] = new Cellule(10, 16, 0, 0.0,true);
        
        this.cellulesTerrain[11][9] = new Cellule(11, 9, 0, 0.0,true);
        this.cellulesTerrain[11][10] = new Cellule(11, 10, 0, 0.0,true);
        this.cellulesTerrain[11][12] = new Cellule(11, 12, 0, 0.0,true);
        this.cellulesTerrain[11][13] = new Cellule(11, 13, 0, 0.0,true);
        this.cellulesTerrain[11][14] = new Cellule(11, 14, 0, 0.0,true);
        this.cellulesTerrain[11][15] = new Cellule(11, 15, 0, 0.0,true);  
        
        this.cellulesTerrain[12][8] = new Cellule(12, 8, 0, 0.0,true);
        this.cellulesTerrain[12][9] = new Cellule(12, 9, 0, 0.0,true);
        this.cellulesTerrain[12][10] = new Cellule(12, 10, 0, 0.0,true);
        this.cellulesTerrain[12][13] = new Cellule(12, 13, 0, 0.0,true);
        this.cellulesTerrain[12][14] = new Cellule(12, 14, 0, 0.0,true);
        this.cellulesTerrain[12][15] = new Cellule(12, 15, 0, 0.0,true);
        this.cellulesTerrain[12][16] = new Cellule(12, 16, 0, 0.0,true);
        
        this.cellulesTerrain[13][6] = new Cellule(13, 6, 0, 0.0,true);
        this.cellulesTerrain[13][7] = new Cellule(13, 7, 0, 0.0,true);
        this.cellulesTerrain[13][8] = new Cellule(13, 8, 0, 0.0,true);
        this.cellulesTerrain[13][9] = new Cellule(13, 9, 0, 0.0,true);
        this.cellulesTerrain[13][10] = new Cellule(13, 10, 0, 0.0,true);
        this.cellulesTerrain[13][11] = new Cellule(13, 11, 0, 0.0,true);
        this.cellulesTerrain[13][10] = new Cellule(13, 10, 0, 0.0,true);
        this.cellulesTerrain[13][14] = new Cellule(13, 14, 0, 0.0,true);
        this.cellulesTerrain[13][15] = new Cellule(13, 15, 0, 0.0,true);
        this.cellulesTerrain[13][16] = new Cellule(13, 16, 0, 0.0,true);
        
        this.cellulesTerrain[14][10] = new Cellule(14, 10, 0, 0.0,true);
        this.cellulesTerrain[14][9] = new Cellule(14, 9, 0, 0.0,true);
        this.cellulesTerrain[14][8] = new Cellule(14, 8, 0, 0.0,true);
        this.cellulesTerrain[14][7] = new Cellule(14, 7, 0, 0.0,true);
        this.cellulesTerrain[14][15] = new Cellule(14, 15, 0, 0.0,true);
        this.cellulesTerrain[14][14] = new Cellule(14, 14, 0, 0.0,true);
        this.cellulesTerrain[14][13] = new Cellule(14, 13, 0, 0.0,true);
        this.cellulesTerrain[14][12] = new Cellule(14, 12, 0, 0.0,true);
        this.cellulesTerrain[14][11] = new Cellule(14, 11, 0, 0.0,true);   
       
        this.cellulesTerrain[29][0] = new Cellule(29, 0, 0, 0.0,true);
        this.cellulesTerrain[30][0] = new Cellule(30, 0, 0, 0.0,true);
        this.cellulesTerrain[30][1] = new Cellule(30, 1, 0, 0.0,true);
        this.cellulesTerrain[31][0] = new Cellule(31, 0, 0, 0.0,true);
        this.cellulesTerrain[31][1] = new Cellule(31, 1, 0, 0.0,true);
        this.cellulesTerrain[32][0] = new Cellule(32, 0, 0, 0.0,true);
        this.cellulesTerrain[32][1] = new Cellule(32, 1, 0, 0.0,true);
        this.cellulesTerrain[32][2] = new Cellule(32, 2, 0, 0.0,true);
        this.cellulesTerrain[33][0] = new Cellule(33, 0, 0, 0.0,true);
        this.cellulesTerrain[33][1] = new Cellule(33, 1, 0, 0.0,true);
        this.cellulesTerrain[33][2] = new Cellule(33, 2, 0, 0.0,true);
        this.cellulesTerrain[34][0] = new Cellule(34, 0, 0, 0.0,true);
        this.cellulesTerrain[34][1] = new Cellule(34, 1, 0, 0.0,true);
        this.cellulesTerrain[35][0] = new Cellule(35, 0, 0, 0.0,true);
        this.cellulesTerrain[35][1] = new Cellule(35, 1, 0, 0.0,true);
        this.cellulesTerrain[36][0] = new Cellule(36, 0, 0, 0.0,true);
        this.cellulesTerrain[36][1] = new Cellule(36, 0, 0, 0.0,true);
        this.cellulesTerrain[37][0] = new Cellule(37, 0, 0, 0.0,true);
        this.cellulesTerrain[34][25] = new Cellule(34, 25, 0, 0.0,true);
        this.cellulesTerrain[34][26] = new Cellule(34, 26, 0, 0.0,true);
        this.cellulesTerrain[35][25] = new Cellule(35, 25, 0, 0.0,true);
        this.cellulesTerrain[35][26] = new Cellule(35, 26, 0, 0.0,true);
        this.cellulesTerrain[35][27] = new Cellule(35, 27, 0, 0.0,true);
        this.cellulesTerrain[36][27] = new Cellule(36, 27, 0, 0.0,true);
        this.cellulesTerrain[36][28] = new Cellule(36, 28, 0, 0.0,true);
        this.cellulesTerrain[36][29] = new Cellule(36, 29, 0, 0.0,true);
        this.cellulesTerrain[36][30] = new Cellule(36, 30, 0, 0.0,true);
        this.cellulesTerrain[36][31] = new Cellule(36, 31, 0, 0.0,true);        
        this.cellulesTerrain[37][27] = new Cellule(37, 27, 0, 0.0,true);
        this.cellulesTerrain[37][28] = new Cellule(37, 28, 0, 0.0,true);
        this.cellulesTerrain[37][29] = new Cellule(37, 29, 0, 0.0,true);
        this.cellulesTerrain[37][30] = new Cellule(37, 30, 0, 0.0,true);
        this.cellulesTerrain[37][31] = new Cellule(37, 31, 0, 0.0,true);
        this.cellulesTerrain[38][31] = new Cellule(38, 31, 0, 0.0,true);
        this.cellulesTerrain[38][32] = new Cellule(38, 32, 0, 0.0,true);
        logger.debug("Obstacle initialisée");
    }

    public void generationAleatoireNourriture() {
        int k = 0;
        while (k < LancementProg.config.nombreSourcesNourriture) {
	       int a = (int)(Math.random() * (double)tailleTerrainCellules[0]);
	       int b = (int)(Math.random() * (double)tailleTerrainCellules[1]);
	       if( this.cellulesTerrain[a][b].getObstacle()==false){
	            int c = (int) (double)LancementProg.config.nourritureMaxSurSource;
	            this.ajouterNourriture(c, this.cellulesTerrain[a][b]);
	            logger.debug("Sources de nourriture aléatoire générées");
	       }
	            ++k;
        	
        }
    }

    public void evolutionSourcesNourriture() {
        if (LancementProg.config.nourritureTotaleSurTerrainMin > LancementProg.config.nourritureTotaleSurTerrain) {
			int a = (int)(Math.random() * (double)tailleTerrainCellules[0]);
			int b = (int)(Math.random() * (double)tailleTerrainCellules[1]);
			if( this.cellulesTerrain[a][b].getObstacle()==false){
				int c = (int)(Math.random() * (double)LancementProg.config.nourritureMaxSurSource);
				this.ajouterNourriture(c, cellulesTerrain[a][b]);
	            logger.debug("Ajout d'une source de nourriture effectué");
			}
        }
    }
    
    public void resetPheromone() {
        int k = 0;
        while (k <= this.tailleTerrainCellules[0] - 1) {
            int i = 0;
            while (i <= this.tailleTerrainCellules[1] - 1) {
                this.cellulesTerrain[k][i].setNbPheromones(0.0);
                ++i;
            }
            ++k;
        }
        logger.debug("Pheromone reset");
    	
    }

    public void ajouterNourriture(int nourrriture, Cellule cellule) {
        cellule.setNourriture(nourrriture);
    }

    public void ajouterNbPheromones(int nbPheromones, Cellule cellule) {
        cellule.setNbPheromones(nbPheromones);
    }

    public Cellule[][] getCellulesTerrain() {
        return cellulesTerrain;
    }

    public void setCellulesTerrain(Cellule[][] cellulesTerrain) {
        this.cellulesTerrain = cellulesTerrain;
    }

    public int[] getTaille() {
        return tailleTerrainCellules;
    }

    public void setTaille(int[] taille) {
        tailleTerrainCellules = taille;
    }
}

