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
        partidosPoliticos.add(partidoPolitico);
    }

    public void updatePartidoPolitico(PartidoPolitico partidoPoliticoToUpdate, double newFondos) {
        partidoPoliticoToUpdate.setFondosTotales(newFondos);
    }

    public void deletePartidoPolitico(PartidoPolitico partidoPoliticoToDelete) {
        partidosPoliticos.remove(partidoPoliticoToDelete);
    }

    public void listPartidosPoliticos() {
        partidoPoliticoView.displayPartidosPoliticosList(partidosPoliticos);
    }

    public void filterPartidosPoliticosByFondos(double fondos) {
        List<PartidoPolitico> filteredPartidosPoliticos = partidoPoliticoView.filterPartidosPoliticosByFondos(partidosPoliticos, fondos);
        partidoPoliticoView.displayPartidosPoliticosList(filteredPartidosPoliticos);
    }

    public PartidoPolitico findPartidoPoliticoByName(String name) {
        return partidosPoliticos.stream()
                .filter(partido -> partido.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
