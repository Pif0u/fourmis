package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import objets.Cellule;
import objets.Fourmi;

/**
 * Classe DessinTerrain
 * @author Pifou
 *
 */
public class DessinTerrain extends JPanel {

	private static final long serialVersionUID = 1L;
	private int[] tailleTerrainPixels;
	private int[] tailleTerrainCellules;
	double rapportX;
	double rapportY;
	/**
	 * Contructeur DessinTerrain
	 * Récupère la taille de la fenetre de simulation depuis la classe "Parametres"
	 * Calcule la taille d'une seule celulle.
	 */
	public DessinTerrain() {
		this.tailleTerrainCellules = LancementProg.config.terrain.getTaille();
		this.tailleTerrainPixels = LancementProg.config.tailleTerrainPixels;
		this.rapportX = (double)this.tailleTerrainPixels[0] / (double)this.tailleTerrainCellules[0];
		this.rapportY = (double)this.tailleTerrainPixels[1] / (double)this.tailleTerrainCellules[1];

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		ImageIcon fond = new ImageIcon(DessinTerrain.class.getResource("/images/fond.png"));
		ImageIcon fourmiSprite = new ImageIcon(DessinTerrain.class.getResource("/images/fourmis.png"));
		ImageIcon obstacle1 = new ImageIcon(DessinTerrain.class.getResource("/images/Obstacle2.png"));

		ImageIcon nourriture1 = new ImageIcon(DessinTerrain.class.getResource("/images/Meat1-1.png"));
		ImageIcon nourriture2 = new ImageIcon(DessinTerrain.class.getResource("/images/Meat1-3.png"));
		ImageIcon nourriture3 = new ImageIcon(DessinTerrain.class.getResource("/images/Meat1-5.png"));


		fond.paintIcon(this,g,0,0);


		/*
		 * Debut "Dessin Grille"
		 */
		if(LancementProg.config.affichageGrille) {
			g.setColor(Color.BLACK);

			int lignes = 40;
			int colonnes = 40;

			int largeur = getWidth(); 
			int hauteur = getHeight(); 

			for (int ligne = 0; ligne < lignes; ligne++)
			{
				int cellY = (int) (rapportX * ligne);
				g.drawLine(0, cellY, largeur, cellY);
			}

			for (int colonne = 0; colonne < colonnes; colonne++)
			{
				int cellX = (int) (rapportY * colonne);
				g.drawLine(cellX, 0, cellX, hauteur);
			}
		}
		/*
		 * Fin "Dessin Grille"
		 */




		g.setColor(Color.white);
		int nourritureTotaleSurTerrain = 0;
		int k = 0;
		while (k <= tailleTerrainCellules[0] - 1) {
			int l = 0;
			while (l <= tailleTerrainCellules[1] - 1) {
				Cellule celluleActive = LancementProg.config.terrain.getCellulesTerrain()[k][l];
				int x1 = (int)((double)celluleActive.getX() * rapportX);
				int y1 = (int)((double)celluleActive.getY() * rapportY);


				int cellX = (int) (rapportX * x1);
				int cellY = (int) (rapportY * y1);


				int cell_largeur = (int) (rapportX * (x1 + 1) - cellX) ;
				int cell_hauteur = (int) (rapportY * (y1 + 1) - cellY) ;


				/*
				 * Debut "Dessin pheromones"
				 */
				 if (celluleActive.getNbPheromones() > 0.0) {
					 celluleActive.evaporationPheromones();
					 Graphics2D g2d = (Graphics2D)g;
					 g2d.setColor(Color.orange);
					 float alphaValeur = (float)(0.001 + celluleActive.getNbPheromones() / (LancementProg.config.nbPheromonesMax + 1.0));
					 g2d.setComposite(AlphaComposite.getInstance(3, alphaValeur));
					 g2d.fillRect(x1, y1, Math.max(cell_largeur - 1, 1), Math.max(cell_hauteur - 1, 1));
					 g2d.setComposite(AlphaComposite.getInstance(3, 1.0f));
				 }
				 /*
				  * Fin "Dessin pheromones"
				  */


				 /*
				  * Debut "Dessin Nourriture" 
				  */
				 if (celluleActive.getNourriture() > 0) {


					 if(celluleActive.getNourriture() <= 275000 && celluleActive.getNourriture() >= 183333 ) {
						 nourriture1.paintIcon(this,g,x1, y1 );
					 } else if (celluleActive.getNourriture() < 183333 && celluleActive.getNourriture() >= 91666 ) {
						 nourriture2.paintIcon(this,g,x1, y1 );

					 } else if (celluleActive.getNourriture() < 91666 ) {
						 nourriture3.paintIcon(this,g,x1, y1 );
					 }                 
					 nourritureTotaleSurTerrain += celluleActive.getNourriture();
				 }
				 /*
				  * Fin "Dessin Nourriture"
				  */


				 /*
				  * Debut "Dessin obstacle"
				  */
				 if(celluleActive.getObstacle()) {
					 obstacle1.paintIcon(this,g, x1,y1);
				 }
				 /*
				  * Fin "Dessin obtacle"
				  */

				 ++l;
			}
			++k;
		}

		LancementProg.config.nourritureTotaleSurTerrain = nourritureTotaleSurTerrain;

		/*
		 * Debut "Dessin Fourmilière"
		 */
		g.setColor(Color.green);
		int xFourmiliere = (int)((double)LancementProg.config.fourmiliere.getPosition().getX() * rapportX);
		int yFourmiliere = (int)((double)LancementProg.config.fourmiliere.getPosition().getY() * rapportY);
		g.fillOval(xFourmiliere, yFourmiliere, 20, 20);
		/*
		 * Debut "Dessin Fourmilière"
		 */

		/*
		 * Debut "Dessin fourmi"
		 */
		int k2 = 0;
		while (k2 < LancementProg.config.ensembleFourmi.nombreDeFourmis()) {
			Fourmi fourmiActive = LancementProg.config.ensembleFourmi.trouverFourmi(k2);

			int xFourmiActive = (int)((double)fourmiActive.getPosition().getX() * rapportX);
			int yFourmiActive = (int)((double)fourmiActive.getPosition().getY() * rapportY);



			fourmiSprite.paintIcon(this,g,xFourmiActive, yFourmiActive);
			++k2;
		}
		/*
		 * Fin "Dessin fourmi"
		 */

	}

	/**
	 * Fonction getTailleTerrainPixels()
	 * @return La taille du terrain en pixel
	 */
	public int[] getTailleTerrainPixels() {
		return tailleTerrainPixels;
	}
}

