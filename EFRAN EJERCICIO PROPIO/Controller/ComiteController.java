package Controller;

import Model.Comite;
import View.ComiteView;

import java.util.List;

public class ComiteController {
    private List<Comite> comites;
    private ComiteView comiteView;

    public ComiteController(List<Comite> comites, ComiteView comiteView) {
        this.comites = comites;
        this.comiteView = comiteView;
    }

    public void createComite(Comite comite) {
        comites.add(comite);
    }

    public void updateComite(Comite comiteToUpdate, String newObjective) {
        comiteToUpdate.setObjetivo(newObjective);
    }

    public void deleteComite(Comite comiteToDelete) {
        comites.remove(comiteToDelete);
    }

    public void listComites() {
        comiteView.displayComitesList(comites);
    }

    public void filterComitesByObjective(String objective) {
        List<Comite> filteredComites = comiteView.filterComitesByObjective(comites, objective);
        comiteView.displayComitesList(filteredComites);
    }
    public Comite findComiteByName(String name) {
        for (Comite comite : comites) {
            if (comite.getNombre().equalsIgnoreCase(name)) {
                return comite;
            }
        }
        return null; // Comite not found
    }
}
