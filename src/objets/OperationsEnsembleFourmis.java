package objets;

import java.util.ArrayList;

public class OperationsEnsembleFourmis {
	
    public void add(ArrayList<Fourmi> arrayList, Fourmi fourmi) {
        arrayList.add(fourmi);
    }

    public void remove(ArrayList<Fourmi> arrayList, Fourmi fourmi) {
        arrayList.remove(fourmi);
    }

    public int size(ArrayList<Fourmi> arrayList) {
        return arrayList.size();
    }

    public Fourmi get(ArrayList<Fourmi> arrayList, int i) {
        return arrayList.get(i);
    }
}


	