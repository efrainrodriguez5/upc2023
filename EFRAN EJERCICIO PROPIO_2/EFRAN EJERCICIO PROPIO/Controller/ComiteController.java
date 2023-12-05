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
        if (comite != null) {
            comites.add(comite);
        } else {
            System.out.println("Error: No se puede agregar un comité nulo.");
        }
    }

    public void updateComite(Comite comiteToUpdate, String newObjective, String newName) {
        if (comiteToUpdate != null) {
            comiteToUpdate.setObjetivo(newObjective);
            comiteToUpdate.setNombre(newName);
        } else {
            System.out.println("Error: Comité no válido para actualizar.");
        }
    }

    public void deleteComite(Comite comiteToDelete) {
        if (comiteToDelete != null) {
            comites.remove(comiteToDelete);
        } else {
            System.out.println("Error: No se puede eliminar un comité nulo.");
        }
    }

    public void listComites() {
        if (!comites.isEmpty()) {
            comiteView.displayComitesList(comites);
        } else {
            System.out.println("No hay comités para mostrar.");
        }
    }

    public void filterComitesByObjective(String objective) {
        if (objective != null && !objective.trim().isEmpty()) {
            List<Comite> filteredComites = comiteView.filterComitesByObjective(comites, objective);
            if (!filteredComites.isEmpty()) {
                comiteView.displayComitesList(filteredComites);
            } else {
                System.out.println("No hay comités con el objetivo especificado.");
            }
        } else {
            System.out.println("Error: Objetivo no válido para filtrar comités.");
        }
    }
    public Comite findComiteByName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            String trimmedName = name.trim().toLowerCase();
            for (Comite comite : comites) {
                if (comite.getNombre().toLowerCase().equals(trimmedName)) {
                    return comite;
                }
            }
            System.out.println("Error: Comité no encontrado con el nombre '" + name + "'.");
        } else {
            System.out.println("Error: Nombre de comité no válido.");
        }
        return null;
    }
}
