package gui;


import javax.swing.JInternalFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import parametres.Parametres;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Sous fenetre qui affiche les boutons start et pause
 * @author Pifou
 *
 */
class FenetreLancementSimulation extends JInternalFrame {
  
	private static final long serialVersionUID = 1L;
	Logger logger = LogManager.getLogger();

    public FenetreLancementSimulation(Parametres parametres) {
        setTitle("Lancement de la simulation");
        setClosable(false);
        setResizable(false);
        setSize(351, 105);
        setLocation(LancementProg.config.tailleTerrainPixels[0] + 30, 465);
        getContentPane().setLayout(null);
        
        
        JButton btnNewButton = new JButton("Start");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
                LancementProg.config.confirmationPause = false;
                LancementProg.config.pause = false;
                logger.info("Simulation lancé");
        	}
        });
        btnNewButton.setBounds(10, 11, 127, 55);
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Pause");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		 LancementProg.config.pause = true;
        		 logger.info("Simulation mis en pause");
        	}
        });
        btnNewButton_1.setBounds(158, 11, 116, 55);
        getContentPane().add(btnNewButton_1);
        setVisible(true);
    }
}

