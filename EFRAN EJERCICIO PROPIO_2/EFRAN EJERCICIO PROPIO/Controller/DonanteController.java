package Controller;

import Model.Comite;
import Model.Donante;
import View.DonanteView;

import java.util.ArrayList;
import java.util.List;

public class DonanteController {
    private List<Donante> donantes;
    private DonanteView donanteView;

    public DonanteController(List<Donante> donantes, DonanteView donanteView) {
        this.donantes = donantes;
        this.donanteView = donanteView;
    }

    public void createDonante(Donante donante) {
        if (donante != null && donante.getName() != null && !donante.getName().isEmpty() && donante.getAmountDonation() >= 0) {
            donantes.add(donante);
        } else {
            System.out.println("Error: No se puede agregar el donante. Verifica los datos proporcionados.");
        }
    }
    public void updateDonante(Donante donanteToUpdate, double newAmountDonation) {
        if (donanteToUpdate != null && newAmountDonation >= 0) {
            donanteToUpdate.setAmountDonation(newAmountDonation);
        } else {
            System.out.println("Error: No se puede actualizar el donante. Verifica los datos proporcionados.");
        }
    }


    public void deleteDonante(Donante donanteToDelete) {
        if (donantes.contains(donanteToDelete)) {
            donantes.remove(donanteToDelete);
            System.out.println("Donante eliminado correctamente.");
        } else {
            System.out.println("El donante no existe en la lista. No se puede eliminar.");
        }
    }

    public void listDonantes() {
        if (donantes.isEmpty()) {
            System.out.println("No hay donantes registrados.");
        } else {
            donanteView.displayDonantesList(donantes);
        }
    }

    public void filterDonantesByLocation(String location) {
        List<Donante> filteredDonantes = donanteView.filterDonantesByLocation(donantes, location);
        donanteView.displayDonantesList(filteredDonantes);
    }

    public Donante findDonanteByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Nombre de donante no válido.");
            return null;
        }

        String trimmedName = name.trim().toLowerCase();

        for (Donante donante : donantes) {
            if (donante.getName().toLowerCase().equals(trimmedName)) {
                return donante;
            }
        }

        System.out.println("Error: Donante no encontrado con el nombre '" + name + "'.");
        return null;
    }
    public List<Donante> filterDonantesByAmount(double amount) {
        if (amount >= 0) {
            List<Donante> filteredDonantes = new ArrayList<>();
            for (Donante donante : donantes) {
                if (donante.getAmountDonation() >= amount) {
                    filteredDonantes.add(donante);
                }
            }
            donanteView.displayDonantesList(filteredDonantes);
            return filteredDonantes;
        } else {
            System.out.println("Error: El monto para filtrar debe ser un valor no negativo.");
            return new ArrayList<>();
        }
    }

}
