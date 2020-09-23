package gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import parametres.Parametres;

/**
 * Classe "main", permet de lancer le programme
 * @author Pifou
 *
 */


public class LancementProg {
    public static Parametres config;
    static Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
    	logger.info("Le programme vient d'être lancer");
        config = new Parametres();
        config.initialisationParametres();
        config.initialisationObjets();
        do {
            config.itere();	
        } while (true);
    }
}

