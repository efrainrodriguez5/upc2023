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
        donantes.add(donante);
    }

    public void updateDonante(Donante donanteToUpdate, double newAmountDonation) {
        donanteToUpdate.setAmountDonation(newAmountDonation);
    }

    public void deleteDonante(Donante donanteToDelete) {
        donantes.remove(donanteToDelete);
    }

    public void listDonantes() {
        donanteView.displayDonantesList(donantes);
    }

    public void filterDonantesByLocation(String location) {
        List<Donante> filteredDonantes = donanteView.filterDonantesByLocation(donantes, location);
        donanteView.displayDonantesList(filteredDonantes);
    }

    public Donante findDonanteByName(String name) {
        for (Donante donante : donantes) {
            if (donante.getName().equalsIgnoreCase(name)) {
                return donante;
            }
        }
        return null;
    }
    public List<Donante> filterDonantesByAmount(double amount) {
        List<Donante> filteredDonantes = new ArrayList<>();
        for (Donante donante : donantes) {
            if (donante.getAmountDonation() >= amount) {
                filteredDonantes.add(donante);
            }
        }
        donanteView.displayDonantesList(filteredDonantes);
        return filteredDonantes;
    }
}
