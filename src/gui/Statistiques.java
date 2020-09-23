package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import parametres.Parametres;

/**
 * Sous fenetre qui affiche les statistiques de la simulation
 * @author Pifou
 *
 */
class Statistiques extends JInternalFrame {
  
	private static final long serialVersionUID = 1L;
	static JPanel panTexte;

    public Statistiques(Parametres parametres) {
        setTitle("Statistiques de la simulation");
        setClosable(false);
        setResizable(false);
        setSize(351, 160);
        setLocation(LancementProg.config.tailleTerrainPixels[0] + 30, 575);
        setVisible(true);
        panTexte = new JPanel(){

      
			private static final long serialVersionUID = 1L;

            public void paintComponent(Graphics g) {
                g.setColor(Color.white);
                g.fillRect(0, 0, 1000, 1000);
                g.setColor(Color.black);
                g.drawString("Nombres d'étapes : " + LancementProg.config.temps, 10, 40);
                g.drawString("Durée: " + (double)LancementProg.config.dureeSimulation / 1000.0, 10, 60);
                g.drawString("Nourritures déposées dans la fourmilière : " + withSuffix(LancementProg.config.fourmiliere.getStockNourriture()), 10, 80);
                g.drawString("Nombre de fourmis : " + LancementProg.config.ensembleFourmi.nombreDeFourmis(), 10, 100);
            }
        };
        panTexte.setBackground(Color.white);
        panTexte.setPreferredSize(new Dimension(250, 60));
        panTexte.setBorder(BorderFactory.createTitledBorder("Statistiques"));
        getContentPane().add((Component)panTexte, "Center");
    }
    
    
    public static String withSuffix(long count) {
        if (count < 1000) return "" + count;
        int exp = (int) (Math.log(count) / Math.log(1000));
        return String.format("%.1f %c",
                             count / Math.pow(1000, exp),
                             "kMGTPE".charAt(exp-1));
    }

}

