package Controller;

import Model.EncuestaSatisfaccion;
import View.EncuestaSatisfaccionView;

import java.util.List;

public class EncuestaSatisfaccionController {
    private List<EncuestaSatisfaccion> encuestas;
    private EncuestaSatisfaccionView encuestaSatisfaccionView;

    public EncuestaSatisfaccionController(List<EncuestaSatisfaccion> encuestas, EncuestaSatisfaccionView encuestaSatisfaccionView) {
        this.encuestas = encuestas;
        this.encuestaSatisfaccionView = encuestaSatisfaccionView;
    }

    public void createEncuestaSatisfaccion(EncuestaSatisfaccion encuesta) {
        encuestas.add(encuesta);
    }

    public void updateEncuestaSatisfaccion(EncuestaSatisfaccion encuestaToUpdate, int newSatisfaction) {
        encuestaToUpdate.setSatisfactionpercentage(newSatisfaction);
    }

    public void deleteEncuestaSatisfaccion(EncuestaSatisfaccion encuestaToDelete) {
        encuestas.remove(encuestaToDelete);
    }

    public void listEncuestasSatisfaccion() {
        encuestaSatisfaccionView.displayEncuestasList(encuestas);
    }

    public void filterEncuestasBySatisfaction(int satisfaction) {
        List<EncuestaSatisfaccion> filteredEncuestas = encuestaSatisfaccionView.filterEncuestasBySatisfaction(encuestas, satisfaction);
        encuestaSatisfaccionView.displayEncuestasList(filteredEncuestas);
    }

    public void filterEncuestasSatisfaccionByPercentage(int minSatisfaction) {
        // Filtrar encuestas por porcentaje de satisfacción
        List<EncuestaSatisfaccion> filteredList = encuestas.stream()
                .filter(encuesta -> encuesta.getSatisfactionpercentage() >= minSatisfaction)
                .toList();

        // Mostrar resultados
        encuestaSatisfaccionView.displayEncuestasList(filteredList);
    }
}
