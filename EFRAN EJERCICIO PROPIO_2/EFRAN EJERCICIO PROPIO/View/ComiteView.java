package View;
import Model.Comite;
import Model.Persona;

import java.util.List;
import java.util.stream.Collectors;

public class ComiteView {
    public void displayComiteDetails(Comite comite) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║          Comite Details              ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ Nombre: " + comite.getNombre());
        System.out.println("║ Objetivo: " + comite.getObjetivo());
        System.out.println("║ Lider: " + comite.getLider().getName());
        for (Persona miembro : comite.getMiembros()) {
            System.out.println("║ - " + miembro.getName());
        }
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();
    }

    public void displayComitesList(List<Comite> comites) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         Lista de Comites             ║");
        System.out.println("╠══════════════════════════════════════╣");
        int contador = 0;
        for (Comite comite : comites) {
            contador++;
            System.out.println("║ Comite " + contador);
            System.out.println("║ ──────────");
            System.out.println("║ Nombre: " + comite.getNombre());
            System.out.println("║ Objetivo: " + comite.getObjetivo());
            System.out.println("║ Lider: " + comite.getLider().getName());
            System.out.println("║ ──────────");
        }
        System.out.println("╚══════════════════════════════════════╝");
    }


    public List<Comite> filterComitesByObjective(List<Comite> comites, String objective) {
        return comites.stream()
                .filter(c -> c.getObjetivo().equalsIgnoreCase(objective))
                .collect(Collectors.toList());
    }
}