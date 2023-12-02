package View;
import Model.Comite;
import Model.Persona;

import java.util.List;
import java.util.stream.Collectors;

public class ComiteView {
    public void displayComiteDetails(Comite comite) {
        System.out.println("Comite Details:");
        System.out.println("Nombre: " + comite.getNombre());
        System.out.println("Objetivo: " + comite.getObjetivo());
        System.out.println("Sedes: " + comite.getSedes());
        System.out.println("Lider: " + comite.getLider().getName());
        System.out.println("Miembros:");
        for (Persona miembro : comite.getMiembros()) {
            System.out.println("- " + miembro.getName());
        }
    }

    public void displayComitesList(List<Comite> comites) {
        int contador=0;
        System.out.println("Lista de Comites:");
        System.out.println("\n");
        for (Comite comite : comites) {
            contador++;
            System.out.println("Comite "+contador);
            System.out.println("-------");
            System.out.println("Nombre: " + comite.getNombre());
            System.out.println("Objetivo: " + comite.getObjetivo());
            System.out.println("Sedes: " + comite.getSedes());
            System.out.println("Lider: " + comite.getLider().getName());
            System.out.println("Miembros:");
            for (Persona miembro : comite.getMiembros()) {
                System.out.println("- " + miembro.getName());
            }
            System.out.println("\n");
        }
    }

    public List<Comite> filterComitesByObjective(List<Comite> comites, String objective) {
        return comites.stream()
                .filter(c -> c.getObjetivo().equalsIgnoreCase(objective))
                .collect(Collectors.toList());
    }
}