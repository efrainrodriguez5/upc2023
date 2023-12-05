package View;

import Model.EncuestaSatisfaccion;

import java.util.List;
import java.util.stream.Collectors;

public class EncuestaSatisfaccionView {
    public void displayEncuestaSatisfaccionDetails(EncuestaSatisfaccion encuesta) {
        System.out.println("Encuesta Satisfaccion Details:");
        System.out.println("Satisfaccion: " + encuesta.getSatisfactionpercentage() + "%");
        System.out.println("Comentario: " + encuesta.getComment());
    }

    public void displayEncuestasList(List<EncuestaSatisfaccion> encuestas) {
        int contador = 0;
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║     Lista de Encuestas de Satisfaccion     ║");
        System.out.println("╠════════════════════════════════════════════╣");
        if (!encuestas.isEmpty()) {
            for (EncuestaSatisfaccion encuesta : encuestas) {
                contador++;
                System.out.println("║ Encuesta Satisfaccion " + contador);
                System.out.println("║ ──────────");
                System.out.println("║ Satisfaccion: " + encuesta.getSatisfactionpercentage() + "%");
                System.out.println("║ Comentario: " + encuesta.getComment());
                System.out.println("║ ──────────");
            }
        } else {
            System.out.println("║ No hay encuestas de satisfacción para mostrar. ║");
        }
        System.out.println("╚════════════════════════════════════════════╝");
    }


    public List<EncuestaSatisfaccion> filterEncuestasBySatisfaction(List<EncuestaSatisfaccion> encuestas, int satisfaction) {
        return encuestas.stream()
                .filter(e -> e.getSatisfactionpercentage() == satisfaction)
                .collect(Collectors.toList());
    }
}
