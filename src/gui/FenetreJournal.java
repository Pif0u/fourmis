package gui;

import java.time.LocalTime;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;

import parametres.Parametres;
import javax.swing.JScrollPane;

/**
 * Sous fenetre qui affiche le journal de bord
 * @author Pifou
 *
 */
class FenetreJournal extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private final static String newline = "\n";
	private JTextArea textArea_Journal = new JTextArea();

	public FenetreJournal(Parametres parametres) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setTitle("Journal de bord");
				setClosable(false);
				setResizable(false);
				setSize(351, 200);
				setLocation(LancementProg.config.tailleTerrainPixels[0] + 30, 740);

				getContentPane().setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 335, 170);
				getContentPane().add(scrollPane);
				scrollPane.setViewportView(textArea_Journal);
				textArea_Journal.setEditable(false);

				DefaultCaret caret = (DefaultCaret) textArea_Journal.getCaret();
				caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);



				setVisible(true);
			}

		});
		
	}

	public void journal() {

		LocalTime heure = LocalTime.now();

		if (LancementProg.config.ensembleFourmi.trouverFourmi(1).isRencontreObstacle()) {
			textArea_Journal.append("[" + heure + "] J'ai rencontré un obstacle" + newline);
		} else if (LancementProg.config.ensembleFourmi.trouverFourmi(1).getNbNourriturePerso() == LancementProg.config.ensembleFourmi.trouverFourmi(1).getNourriturePersoMax()) {
			textArea_Journal.append("[" + heure + "] J'ai trouvé de la nourriture!" + newline);
		}
	}


}