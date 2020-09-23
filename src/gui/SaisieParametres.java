package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import parametres.Parametres;

/**
 * Sous fenetre qui permet la saisie des paramètres par l'utilisateur
 * @author Pifou
 *
 */
class SaisieParametres extends JInternalFrame {
 
	private static final long serialVersionUID = 1L;
	private JPanel content;
    private JPanel panDureeTour;
    private JPanel boutons;
    private JPanel panSliderDureeTour;
    private JTextField dureeTour;
    private JLabel labelDureeTour;
    private JButton okBouton;
    private JSlider slideDureeTour;
    private JButton btnAfficherLaGrille;
    private JButton btnCacherLaGrille;
    private JLabel lblNewLabel;
    private JTextField textFieldFourmis;
    private JLabel lblNewLabel_1;
    private JTextField textFieldNourriture;

    public SaisieParametres(Parametres parametres) {
        setTitle("Parametres");
        setClosable(false);
        setResizable(false);
        setSize(351, 451);
        setLocation(LancementProg.config.tailleTerrainPixels[0] + 30, 10);
        setVisible(true);
        content = new JPanel();
        content.setBounds(0, 0, 340, 370);
        content.setBackground(Color.white);
        panDureeTour = new JPanel();
        panDureeTour.setBounds(36, 11, 250, 120);
        panDureeTour.setBackground(Color.white);
        panDureeTour.setPreferredSize(new Dimension(250, 120));
        panDureeTour.setBorder(BorderFactory.createTitledBorder("Vitesse d'éxécution"));
        labelDureeTour = new JLabel("Durée en ms : ");
        dureeTour = new JTextField(String.valueOf(LancementProg.config.dureeTour));
        dureeTour.setPreferredSize(new Dimension(60, 25));
        panSliderDureeTour = new JPanel();
        panSliderDureeTour.setPreferredSize(new Dimension(220, 60));
        panSliderDureeTour.setBackground(Color.white);
        slideDureeTour = new JSlider();
        slideDureeTour.setMaximum(101);
        slideDureeTour.setMinimum(1);
        slideDureeTour.setValue(LancementProg.config.dureeTour);
        slideDureeTour.setPaintTicks(true);
        slideDureeTour.setPaintLabels(true);
        slideDureeTour.setMinorTickSpacing(5);
        slideDureeTour.setMajorTickSpacing(25);
        slideDureeTour.setBackground(Color.white);
        slideDureeTour.addChangeListener(new ChangeListener(){

            public void stateChanged(ChangeEvent event) {
                LancementProg.config.dureeTour = ((JSlider)event.getSource()).getValue();
                SaisieParametres.this.dureeTour.setText(String.valueOf(LancementProg.config.dureeTour));
            }
        });
        slideDureeTour.setVisible(true);
        content.setLayout(null);
        panSliderDureeTour.add((Component)this.slideDureeTour, "Center");
        panDureeTour.add(labelDureeTour);
        panDureeTour.add(dureeTour);
        panDureeTour.add(panSliderDureeTour);
        content.add((Component)panDureeTour);
        
        btnAfficherLaGrille = new JButton("Afficher la grille");
        btnAfficherLaGrille.setBounds(10, 232, 123, 23);
        content.add(btnAfficherLaGrille);
        
        btnAfficherLaGrille.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
       		 LancementProg.config.affichageGrille = true;
       		 rafraichir();
       		 
       	}
       });
        getContentPane().setLayout(null);
        
        
        getContentPane().add((Component)content);
        
        btnCacherLaGrille = new JButton("Cacher la grille");
        btnCacherLaGrille.setBounds(205, 232, 123, 23);
        content.add(btnCacherLaGrille);
        
        btnCacherLaGrille.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
       		 LancementProg.config.affichageGrille = false;
       		 rafraichir();
       	}
       });
        
        lblNewLabel = new JLabel("Nombre de fourmis");
        lblNewLabel.setBounds(12, 183, 146, 14);
        content.add(lblNewLabel);
        
        textFieldFourmis = new JTextField();
        textFieldFourmis.setBounds(214, 180, 114, 20);
        content.add(textFieldFourmis);
        textFieldFourmis.setColumns(10);
        
        lblNewLabel_1 = new JLabel("Nombre de nourriture");
        lblNewLabel_1.setBounds(10, 143, 180, 14);
        content.add(lblNewLabel_1);
        
        textFieldNourriture = new JTextField();
        textFieldNourriture.setBounds(214, 143, 114, 20);
        content.add(textFieldNourriture);
        textFieldNourriture.setColumns(10);
        
        textFieldNourriture.setText(String.valueOf(12));
        textFieldFourmis.setText(String.valueOf(25));
        
        JLabel lblChangerLesPra = new JLabel("Changer les paramêtres remet à zero la simulation");
        lblChangerLesPra.setForeground(Color.RED);
        lblChangerLesPra.setBounds(12, 315, 288, 43);
        content.add(lblChangerLesPra);
        
        
        
        
        boutons = new JPanel();
        boutons.setBounds(0, 369, 340, 49);
        getContentPane().add(boutons);
        okBouton = new JButton("OK");
        okBouton.setBounds(94, 12, 156, 23);
        okBouton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0) {
                LancementProg.config.dureeTour = Integer.parseInt(this.getDureeTour());
                LancementProg.config.setParametres(Integer.parseInt(textFieldFourmis.getText()), Integer.parseInt(textFieldNourriture.getText()));
                LancementProg.config.pause = true;
                rafraichir();
            }


            public String getDureeTour() {
                return SaisieParametres.this.dureeTour.getText().equals("") ? "2" : SaisieParametres.this.dureeTour.getText();
            }

        });
        boutons.setLayout(null);
        boutons.add(okBouton);
        
        
        
        
        
        
    }
    
    
    public void rafraichir() {
    	LancementProg.config.fenetre.rafraichir();

    }
}

