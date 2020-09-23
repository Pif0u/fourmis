package parametres;


import java.io.Serializable;
import gui.Fenetre;
import objets.EnsembleFourmis;
import objets.Fourmi;
import objets.Fourmiliere;
import objets.Ouvriere;
import objets.Terrain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Parametres
implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public double nbPheromoneDeposee;
    public int nbNourritureTransportee;
    public int nbNourriturePersoMax;
    public int nbNourritureTransporteeMax;
    
 
    public double nbPheromonesMax;
    public double tauxEvaporationPheromones;
    public int nourritureInitialeFourmiliere;
    public int[] positionFourmiliere = new int[2];
    public int nombreSourcesNourriture;
    public int nourritureMaxSurSource;
    public int nourritureTotaleSurTerrain;
    public int nourritureTotaleSurTerrainMin;
    public int nombreInitialFourmis;
    public int IndiceProchaineFourmi;
    public int[] tailleTerrainPixels = new int[2];
    public int[] tailleTerrainCellules = new int[2];
    public int[] tailleFenetre = new int[2];
    public int dureeTour;
    public boolean pause;
    public boolean confirmationPause;
    public int temps;
    public int dureeSimulation;
    public Fourmiliere fourmiliere;
    public Terrain terrain;
    public EnsembleFourmis ensembleFourmi;
    public Fenetre fenetre;
    public Fourmi newFourmis;
    public boolean affichageGrille;
    public int nbFourmisReset;
    
    Logger logger = LogManager.getLogger();
    
    
    public static String withSuffix(long count) {
        if (count < 1000) return "" + count;
        int exp = (int) (Math.log(count) / Math.log(1000));
        return String.format("%.1f %c",
                             count / Math.pow(1000, exp),
                             "kMGTPE".charAt(exp-1));
    }


    public void itere() {
        if (this.pause) {
            try {	
                Thread.sleep(this.dureeTour);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.confirmationPause = true;
        } else {
            ++this.temps;
            this.dureeSimulation += this.dureeTour;
            this.terrain.evolutionSourcesNourriture();
            System.out.println("Temps écoulé : " + this.temps);
            System.out.println("Nombre de nourritures déposées dans la fourmilière : " + withSuffix(this.fourmiliere.getStockNourriture()));
            System.out.println("Nombre de fourmis : " + this.ensembleFourmi.nombreDeFourmis());
            System.out.println("-----------------------------------");
            this.ensembleFourmi.avancer();
            this.fenetre.rafraichir();
            try {
                Thread.sleep(this.dureeTour);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void initialisationParametres() {
        this.temps = 0;
        this.dureeSimulation = 0;
        this.nbPheromoneDeposee = 1.5;
        this.nbPheromonesMax = 50.0;
        this.nombreInitialFourmis = 25;
        this.dureeTour = 20;
        this.nourritureInitialeFourmiliere = 0;
        this.tauxEvaporationPheromones = 0.97;
        this.nbNourriturePersoMax = 100;
        this.nbNourritureTransportee = 0;
        this.nbNourritureTransporteeMax = 275;
        this.nombreSourcesNourriture = 12;
        this.nourritureMaxSurSource = 1000 * this.nbNourritureTransporteeMax;
        this.tailleTerrainPixels[0] = 880;
        this.tailleTerrainPixels[1] = 880;
        this.tailleTerrainCellules[0] = 40;
        this.tailleTerrainCellules[1] = 40;
        this.IndiceProchaineFourmi = 0;
        this.pause = true;
        this.confirmationPause = false;
        this.affichageGrille = false;
        this.nbFourmisReset = 25;
    }
    
    
    public void initialisationReset() {
        this.temps = 0;
        this.dureeSimulation = 0;
        this.nbPheromoneDeposee = 1.0;
        this.nbPheromonesMax = 50.0;
        this.dureeTour = 20;
        this.nourritureInitialeFourmiliere = 0;
        this.tauxEvaporationPheromones = 0.97;
        this.nbNourriturePersoMax = 100;
        this.nbNourritureTransportee = 0;
        this.nbNourritureTransporteeMax = 275;
        this.nourritureMaxSurSource = 1000 * this.nbNourritureTransporteeMax;
        this.tailleTerrainPixels[0] = 880;
        this.tailleTerrainPixels[1] = 880;
        this.tailleTerrainCellules[0] = 40;
        this.tailleTerrainCellules[1] = 40;
        this.IndiceProchaineFourmi = 0;
        this.pause = true;
        this.confirmationPause = false;
        this.affichageGrille = false;
     }
        
        
    
    public void initialisationObjets() {
        this.terrain = new Terrain();
        logger.debug("Terrain initialisé");
        this.nourritureTotaleSurTerrainMin = this.nourritureMaxSurSource * this.nombreSourcesNourriture / 2;
        this.terrain.generationAleatoireNourriture();
        this.positionFourmiliere[0] = 20;
        this.positionFourmiliere[1] = 20;
        this.fourmiliere = new Fourmiliere(this.nourritureInitialeFourmiliere, this.terrain.getCellulesTerrain()[this.positionFourmiliere[0]][this.positionFourmiliere[1]]);
        this.terrain.getCellulesTerrain()[this.positionFourmiliere[0]][this.positionFourmiliere[1]].setNourriture(0);
        this.ensembleFourmi = new EnsembleFourmis();
        logger.info("Ensemble Fourmis initialisé");
        Fourmi[] fourmis = new Fourmi[this.nombreInitialFourmis];
        String nom = "fourmi";
        int k = 0;
        while (k < this.nombreInitialFourmis) {
            String num = String.valueOf(k);
            fourmis[k] = new Ouvriere(String.valueOf(nom) + num);
            logger.debug("Fourmi n°" + k + " crée");
            ++k;
        }
        this.fenetre = new Fenetre();
        this.fenetre.setVisible(true);
    }
    
    
    public void resetTerrain() {
    	initialisationReset();
    	this.terrain = new Terrain();
        logger.debug("Terrain reset");
        this.nourritureTotaleSurTerrainMin = this.nourritureMaxSurSource * this.nombreSourcesNourriture / 2;
        this.terrain.generationAleatoireNourriture();
        this.positionFourmiliere[0] = 20;
        this.positionFourmiliere[1] = 20;
        this.fourmiliere = new Fourmiliere(this.nourritureInitialeFourmiliere, this.terrain.getCellulesTerrain()[this.positionFourmiliere[0]][this.positionFourmiliere[1]]);
        this.terrain.getCellulesTerrain()[this.positionFourmiliere[0]][this.positionFourmiliere[1]].setNourriture(0);
        
        this.ensembleFourmi = new EnsembleFourmis();
        Fourmi[] fourmis = new Fourmi[this.nbFourmisReset];
        String nom = "fourmi";
        int k = 0;
        while (k < this.nbFourmisReset) {
            String num = String.valueOf(k);
            fourmis[k] = new Ouvriere(String.valueOf(nom) + num);
            logger.debug("Fourmi n°" + k + " crée");
            ++k;
        }   
        
    }  
    
    public void setParametres(int nbFourmis, int nbSourceNourriture) {
    	initialisationParametres();
    	logger.debug("Paramètres initalisées");
        this.nombreSourcesNourriture = nbSourceNourriture;
    	this.terrain = new Terrain();
    	logger.debug("Terrain initalisé");
        this.nourritureTotaleSurTerrainMin = this.nourritureMaxSurSource * this.nombreSourcesNourriture / 2;
        this.terrain.generationAleatoireNourriture();
        this.positionFourmiliere[0] = 20;
        this.positionFourmiliere[1] = 20;
        this.fourmiliere = new Fourmiliere(this.nourritureInitialeFourmiliere, this.terrain.getCellulesTerrain()[this.positionFourmiliere[0]][this.positionFourmiliere[1]]);
        this.terrain.getCellulesTerrain()[this.positionFourmiliere[0]][this.positionFourmiliere[1]].setNourriture(0);
        this.nbFourmisReset = nbFourmis;
        this.ensembleFourmi = new EnsembleFourmis();
        Fourmi[] fourmis = new Fourmi[nbFourmis];
        String nom = "fourmi";
        int k = 0;
        while (k < nbFourmis) {
            String num = String.valueOf(k);
            fourmis[k] = new Ouvriere(String.valueOf(nom) + num);
            logger.debug("Fourmi n°" + k + " crée");
            ++k;
        }   
        
    }
    
    
    

}

