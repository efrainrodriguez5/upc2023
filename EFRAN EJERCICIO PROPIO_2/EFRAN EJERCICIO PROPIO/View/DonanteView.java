package View;

import Model.Donante;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collectors;

public class DonanteView {
    public void displayDonanteDetails(Donante donante) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        Detalles del Donante           ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ Nombre: " + donante.getName());
        System.out.println("║ Apellido: " + donante.getLastName());
        System.out.println("║ DNI: " + donante.getDNI());
        System.out.println("║ Ubicación: " + donante.getLocation());
        System.out.println("║ Edad: " + donante.getAge());
        System.out.println("║ Profesión: " + donante.getProfession());
        System.out.println("║ Monto de Donación: $" + donante.getAmountDonation());
        System.out.println("╚══════════════════════════════════════╝");
    }

    public void displayDonantesList(List<Donante> donantes) {
        int contador = 0;
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        Lista de Donantes             ║");
        System.out.println("╠══════════════════════════════════════╣");
        if (!donantes.isEmpty()) {
            for (Donante donante : donantes) {
                contador++;
                System.out.println("║ Donante " + contador);
                System.out.println("║ ──────────");
                System.out.println("║ Nombre: " + donante.getName());
                System.out.println("║ Apellido: " + donante.getLastName());
                System.out.println("║ DNI: " + donante.getDNI());
                System.out.println("║ Ubicación: " + donante.getLocation());
                System.out.println("║ Edad: " + donante.getAge());
                System.out.println("║ Profesión: " + donante.getProfession());
                System.out.println("║ Monto de Donación: $" + donante.getAmountDonation());
                System.out.println("║ ──────────");
            }
        } else {
            System.out.println("║ No hay donantes para mostrar.        ║");
        }
        System.out.println("╚══════════════════════════════════════╝");
    }


    public List<Donante> filterDonantesByLocation(List<Donante> donantes, String location) {
        return donantes.stream()
                .filter(d -> d.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }
}