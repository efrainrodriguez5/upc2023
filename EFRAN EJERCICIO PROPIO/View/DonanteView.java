package View;

import Model.Donante;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collectors;

public class DonanteView {
    public void displayDonanteDetails(Donante donante) {
        System.out.println("Donante Details:");
        System.out.println("Nombre: " + donante.getName());
        System.out.println("Apellido: " + donante.getLastName());
        System.out.println("DNI: " + donante.getDNI());
        System.out.println("Ubicación: " + donante.getLocation());
        System.out.println("Edad: " + donante.getAge());
        System.out.println("Profesión: " + donante.getProfession());
        System.out.println("Monto de Donación: $" + donante.getAmountDonation());
    }

    public void displayDonantesList(List<Donante> donantes) {
        int contador=0;
        System.out.println("Lista de Donantes:");
        System.out.println("\n");
        for (Donante donante : donantes) {
            contador++;
            System.out.println("Donante "+contador);
            System.out.println("-------");
            System.out.println("Nombre: " + donante.getName());
            System.out.println("Apellido: " + donante.getLastName());
            System.out.println("DNI: " + donante.getDNI());
            System.out.println("Ubicación: " + donante.getLocation());
            System.out.println("Edad: " + donante.getAge());
            System.out.println("Profesión: " + donante.getProfession());
            System.out.println("Monto de Donación: $" + donante.getAmountDonation());
            System.out.println("\n");
        }
    }

    public List<Donante> filterDonantesByLocation(List<Donante> donantes, String location) {
        return donantes.stream()
                .filter(d -> d.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }
}