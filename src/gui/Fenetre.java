package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Fenêtre principale qui contient tous les sous-fenêtres
 * @author Pifou
 *
 */
public class Fenetre extends JFrame {


	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar = new JMenuBar();

	public JDesktopPane fenetreBase;
	private FenetreSimulation fenetreSimulation;
	private Statistiques fenetreStats;
	private SaisieParametres fenetreParametres;
	private FenetreJournal fenetreJournal;
	private FenetreLancementSimulation fenetreLancementSimulation;
	private final JMenuItem exitButton = new JMenuItem("Quitter");
	private final JMenu actionMenu = new JMenu("Actions");
	private final JMenuItem buttonKillPheromones = new JMenuItem("Supprimer phéromones");
	private final JMenuItem resetButton = new JMenuItem("Reset");
	Logger logger = LogManager.getLogger();

	/**
	 * Constructeur Fenetre()
	 */
	public Fenetre() {
		setTitle("Simulation de colonie de fourmis");
		setVisible(true);
		this.setSize(1300, 1000);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		fenetreBase = new JDesktopPane();
		setBackground(Color.darkGray);
		fenetreSimulation = new FenetreSimulation();
		fenetreSimulation.setDefaultCloseOperation(1);
		fenetreStats = new Statistiques(LancementProg.config);
		fenetreStats.setDefaultCloseOperation(1);
		fenetreParametres = new SaisieParametres(LancementProg.config);
		fenetreParametres.setDefaultCloseOperation(1);
		fenetreLancementSimulation = new FenetreLancementSimulation(LancementProg.config);
		fenetreParametres.setDefaultCloseOperation(1);
		fenetreJournal = new FenetreJournal(LancementProg.config);
		fenetreJournal.setDefaultCloseOperation(1);
		fenetreBase.add(fenetreParametres);
		fenetreBase.add(fenetreStats);
		fenetreBase.add(fenetreSimulation);
		fenetreBase.add(fenetreLancementSimulation);
		fenetreBase.add(fenetreJournal);

		getContentPane().add((Component) fenetreBase, "Center");
		initMenu();
		setVisible(true);
	}

	private void initMenu() {

		JMenu simulationMenu = new JMenu("Simulation");
		menuBar.add(simulationMenu);

		JMenuItem startButton = new JMenuItem("Start");
		simulationMenu.add(startButton);

		JMenuItem pauseButton = new JMenuItem("Pause");
		simulationMenu.add(pauseButton);

		simulationMenu.add(resetButton);

		simulationMenu.add(exitButton);

		menuBar.add(actionMenu);

		actionMenu.add(buttonKillPheromones);

		setJMenuBar(menuBar);


		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LancementProg.config.confirmationPause = false;
				LancementProg.config.pause = false;
                logger.info("Simulation lancé");
			}
		});

		pauseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LancementProg.config.pause = true;
				logger.info("Simulation mis en pause");
			}
		});


		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LancementProg.config.resetTerrain();
				LancementProg.config.pause = true;
				rafraichir();
				logger.info("Terrain reset");

			}
		});

		buttonKillPheromones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LancementProg.config.terrain.resetPheromone();
				rafraichir();
				logger.info("Pheromone reset");

			}
		});



	}


	/**
	 * Permet de rafraichir la sous fenetre "Statistique" et la fenetre de Simulation
	 */
	public void rafraichir() {
		fenetreJournal.journal();
		if (LancementProg.config.ensembleFourmi.nombreDeFourmis() != 0) {
			fenetreStats.repaint();
		}

		fenetreSimulation.repaint();

	}
}