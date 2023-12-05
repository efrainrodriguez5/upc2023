package View;

import Model.PartidoPolitico;
import Model.Comite;
import Model.Donante;
import Model.EncuestaSatisfaccion;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartidoPoliticoView {
    public void displayPartidoPoliticoDetails(PartidoPolitico partidoPolitico) {
        System.out.println("Partido Politico Details:");
        System.out.println("Nombre: " + partidoPolitico.getNombre());
        System.out.println("Fondos Totales: $" + partidoPolitico.getFondosTotales());
        System.out.println("Donantes:");
        for (Donante donante : partidoPolitico.getDonantes()) {
            System.out.println("- " + donante.getName() + ": $" + donante.getAmountDonation());
        }
        System.out.println("Encuestas de Satisfaccion:");
        for (EncuestaSatisfaccion encuesta : partidoPolitico.getEncuestas()) {
            System.out.println("- " + encuesta.getSatisfactionpercentage() + "%: " + encuesta.getComment());
        }
        System.out.println("Segmentacion Demografica:");
        displayMap(partidoPolitico.getSegmentacionDemográfica());
        System.out.println("Temas de Interes de Votantes:");
        displayMap(partidoPolitico.getTemasInteresVotantes());
        System.out.println("Comites:");
        for (Comite comite : partidoPolitico.getComites()) {
            System.out.println("- " + comite.getNombre());
        }
    }

    public void displayPartidosPoliticosList(List<PartidoPolitico> partidosPoliticos) {
        int contador = 0;
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║      Lista de Partidos Políticos           ║");
        System.out.println("╠════════════════════════════════════════════╣");
        if (!partidosPoliticos.isEmpty()) {
            for (PartidoPolitico partidoPolitico : partidosPoliticos) {
                contador++;
                System.out.println("║ Partido Político " + contador);
                System.out.println("║ ────────────────");
                System.out.println("║ Nombre: " + partidoPolitico.getNombre());
                System.out.println("║ Fondos Totales: $" + partidoPolitico.getFondosTotales());
                System.out.println("║ ────────────────");
            }
        } else {
            System.out.println("║ No hay partidos políticos para mostrar.     ║");
        }
        System.out.println("╚════════════════════════════════════════════╝");
    }


    public List<PartidoPolitico> filterPartidosPoliticosByFondos(List<PartidoPolitico> partidosPoliticos, double fondos) {
        return partidosPoliticos.stream()
                .filter(p -> p.getFondosTotales() >= fondos)
                .collect(Collectors.toList());
    }

    private void displayMap(Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
