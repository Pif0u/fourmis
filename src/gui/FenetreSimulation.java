package gui;

import java.awt.Component;
import javax.swing.JInternalFrame;


/**
 * Sous fenetre qui affiche le terrain et la simulation
 * @author Pifou
 *
 */
public class FenetreSimulation extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private DessinTerrain dessinTerrain = new DessinTerrain();

    public FenetreSimulation() {
    	this.setTitle("Terrain graphique");
    	this.setClosable(false);
        this.setResizable(false);
    	this.setSize(dessinTerrain.getTailleTerrainPixels()[0] + 10, dessinTerrain.getTailleTerrainPixels()[1] + 30);
    	this.setLocation(10, 10);
    	this.setVisible(true);
    	this.getContentPane().add((Component)dessinTerrain, "Center");

    }

    public DessinTerrain getLePanneauTerrainGraphique() {
        return dessinTerrain;
    }

    public void setLePanneauTerrainGraphique(DessinTerrain dessinTerrain) {
        this.dessinTerrain = dessinTerrain;
    }
}

