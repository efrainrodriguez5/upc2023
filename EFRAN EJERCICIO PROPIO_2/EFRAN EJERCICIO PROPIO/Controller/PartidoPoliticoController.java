package Controller;

import Model.PartidoPolitico;
import View.PartidoPoliticoView;

import java.util.List;

public class PartidoPoliticoController {
    private List<PartidoPolitico> partidosPoliticos;
    private PartidoPoliticoView partidoPoliticoView;

    public PartidoPoliticoController(List<PartidoPolitico> partidosPoliticos, PartidoPoliticoView partidoPoliticoView) {
        this.partidosPoliticos = partidosPoliticos;
        this.partidoPoliticoView = partidoPoliticoView;
    }

    public void createPartidoPolitico(PartidoPolitico partidoPolitico) {
        if (partidoPolitico != null) {
            partidosPoliticos.add(partidoPolitico);
        } else {
            System.out.println("Error: No se puede agregar un partido político nulo.");
        }
    }


    public void updatePartidoPolitico(PartidoPolitico partidoPoliticoToUpdate, double newFondos) {
        if (partidoPoliticoToUpdate != null) {
            partidoPoliticoToUpdate.setFondosTotales(newFondos);
        } else {
            System.out.println("Error: Partido político no válido para actualizar.");
        }
    }


    public void deletePartidoPolitico(PartidoPolitico partidoPoliticoToDelete) {
        if (partidoPoliticoToDelete != null) {
            partidosPoliticos.remove(partidoPoliticoToDelete);
        } else {
            System.out.println("Error: No se puede eliminar un partido político nulo.");
        }
    }


    public void listPartidosPoliticos() {
        if (!partidosPoliticos.isEmpty()) {
            partidoPoliticoView.displayPartidosPoliticosList(partidosPoliticos);
        } else {
            System.out.println("No hay partidos políticos para mostrar.");
        }
    }


    public void filterPartidosPoliticosByFondos(double fondos) {
        List<PartidoPolitico> filteredPartidosPoliticos = partidoPoliticoView.filterPartidosPoliticosByFondos(partidosPoliticos, fondos);
        if (!filteredPartidosPoliticos.isEmpty()) {
            partidoPoliticoView.displayPartidosPoliticosList(filteredPartidosPoliticos);
        } else {
            System.out.println("No hay partidos políticos con los fondos especificados.");
        }
    }


    public PartidoPolitico findPartidoPoliticoByName(String name) {
        return partidosPoliticos.stream()
                .filter(partido -> partido.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
