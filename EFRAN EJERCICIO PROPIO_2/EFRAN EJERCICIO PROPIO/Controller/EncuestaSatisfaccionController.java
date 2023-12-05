package Controller;

import Model.EncuestaSatisfaccion;
import View.EncuestaSatisfaccionView;

import java.util.List;

public class EncuestaSatisfaccionController {
    public List<EncuestaSatisfaccion> encuestas;
    private EncuestaSatisfaccionView encuestaSatisfaccionView;

    public EncuestaSatisfaccionController(List<EncuestaSatisfaccion> encuestas, EncuestaSatisfaccionView encuestaSatisfaccionView) {
        this.encuestas = encuestas;
        this.encuestaSatisfaccionView = encuestaSatisfaccionView;
    }

    public void createEncuestaSatisfaccion(EncuestaSatisfaccion encuesta) {
        if (encuesta != null) {
            encuestas.add(encuesta);
        } else {
            System.out.println("Error: No se puede agregar una encuesta de satisfacción nula.");
        }
    }


    public void updateEncuestaSatisfaccion(EncuestaSatisfaccion encuestaToUpdate, int newSatisfaction) {
        if (encuestaToUpdate != null) {
            encuestaToUpdate.setSatisfactionpercentage(newSatisfaction);
        } else {
            System.out.println("Error: Encuesta de satisfacción no válida para actualizar.");
        }
    }


    public void deleteEncuestaSatisfaccion(EncuestaSatisfaccion encuestaToDelete) {
        if (encuestaToDelete != null) {
            encuestas.remove(encuestaToDelete);
        } else {
            System.out.println("Error: No se puede eliminar una encuesta de satisfacción nula.");
        }
    }


    public void listEncuestasSatisfaccion() {
        if (!encuestas.isEmpty()) {
            encuestaSatisfaccionView.displayEncuestasList(encuestas);
        } else {
            System.out.println("No hay encuestas de satisfacción para mostrar.");
        }
    }


    public void filterEncuestasBySatisfaction(int satisfaction) {
        List<EncuestaSatisfaccion> filteredEncuestas = encuestaSatisfaccionView.filterEncuestasBySatisfaction(encuestas, satisfaction);
        if (!filteredEncuestas.isEmpty()) {
            encuestaSatisfaccionView.displayEncuestasList(filteredEncuestas);
        } else {
            System.out.println("No hay encuestas de satisfacción con el porcentaje especificado.");
        }
    }


    public void filterEncuestasSatisfaccionByPercentage(int minSatisfaction) {
        if (minSatisfaction >= 0 && minSatisfaction <= 100) {
            List<EncuestaSatisfaccion> filteredList = encuestas.stream()
                    .filter(encuesta -> encuesta.getSatisfactionpercentage() >= minSatisfaction)
                    .toList();

            if (!filteredList.isEmpty()) {
                encuestaSatisfaccionView.displayEncuestasList(filteredList);
            } else {
                System.out.println("No hay encuestas de satisfacción con el porcentaje especificado.");
            }
        } else {
            System.out.println("Error: Porcentaje de satisfacción no válido.");
        }
    }
}
