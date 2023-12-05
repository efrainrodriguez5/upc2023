package Model;

import java.util.*;
// Clase PartidoPolitico extendida para mostrar herencia y uso de clases abstractas
public class PartidoPolitico extends EntidadFinanciera {
    private String nombre;
    private List<Donante> donantes;
    private List<EncuestaSatisfaccion> encuestas;
    private Map<String, List<String>> segmentacionDemográfica;
    private Map<String, List<String>> temasInteresVotantes;

    private List<Comite> comites;
    private double fondosTotales; //nuevo atributo

    public PartidoPolitico(String nombre, double fondos){
        super(fondos);
        this.nombre=nombre;
        this.donantes=new ArrayList<>();
        this.encuestas=new ArrayList<>();
        this.segmentacionDemográfica=new HashMap<>();
        this.temasInteresVotantes=new HashMap<>();
        this.fondosTotales=0;
        this.comites=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Donante> getDonantes() {
        return donantes;
    }

    public void setDonantes(List<Donante> donantes) {
        this.donantes = donantes;
    }

    public List<EncuestaSatisfaccion> getEncuestas() {
        return encuestas;
    }

    public void setEncuestas(List<EncuestaSatisfaccion> encuestas) {
        this.encuestas = encuestas;
    }

    public Map<String, List<String>> getSegmentacionDemográfica() {
        return segmentacionDemográfica;
    }

    public void setSegmentacionDemográfica(Map<String, List<String>> segmentacionDemográfica) {
        this.segmentacionDemográfica = segmentacionDemográfica;
    }

    public Map<String, List<String>> getTemasInteresVotantes() {
        return temasInteresVotantes;
    }

    public void setTemasInteresVotantes(Map<String, List<String>> temasInteresVotantes) {
        this.temasInteresVotantes = temasInteresVotantes;
    }

    public List<Comite> getComites() {
        return comites;
    }

    public void setComites(List<Comite> comites) {
        this.comites = comites;
    }

    public double getFondosTotales() {
        return fondosTotales;
    }

    public void setFondosTotales(double fondosTotales) {
        this.fondosTotales = fondosTotales;
    }

    public void agregarComite(Comite comite) {
        comites.add(comite);
    }

    @Override
    public void realizarTransaccion(double monto) {
        this.fondos += monto;
        System.out.println("Transacción realizada. Fondos totales del partido: $" + this.fondos);
    }
}

