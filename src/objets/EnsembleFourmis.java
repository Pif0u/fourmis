package objets;

import java.util.ArrayList;

public class EnsembleFourmis {
	private ArrayList<Fourmi> fourmis = new ArrayList<Fourmi>();
    private OperationsEnsembleFourmis operationsEnsembleFourmis = new OperationsEnsembleFourmis();

    /**
     * Permet de faire avancer toutes les fourmis en même temps
     */
    public void avancer() {
        int k = 0;
        while (k < nombreDeFourmis()) {
            Fourmi fourmiActive = trouverFourmi(k);
            fourmiActive.avancer();
            ++k;
        }
    }

  
    /**
     * Ajoute une seule fourmi dans l'ensemble des fourmis
     * @param fourmi Une fourmi
     */
    public void ajouterFourmi(Fourmi fourmi) {
       operationsEnsembleFourmis.add(fourmis, fourmi);
    }

    /**
     * Retire une seule fourmi dans l'ensemble des fourmis
     * @param fourmi Une fourmi
     */
    public void retirerFourmi(Fourmi fourmi) {
        operationsEnsembleFourmis.remove(fourmis, fourmi);
    }

    /**
     * 
     * @return Le nombre de fourmis dans l'ensemble de fourmis
     */
    public int nombreDeFourmis() {
        return operationsEnsembleFourmis.size(fourmis);
    }

    /**
     * 
     * @return Permet de trouver une seule fourmi avec son indice
     */
    public Fourmi trouverFourmi(int k) {
        return operationsEnsembleFourmis.get(fourmis, k);
    }
}

