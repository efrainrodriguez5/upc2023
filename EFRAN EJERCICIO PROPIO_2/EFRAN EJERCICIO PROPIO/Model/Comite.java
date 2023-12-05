package Model;

import java.util.List;

public class Comite {
    private List<Persona> miembros;
    private String nombre;
    private String objetivo;
    private Persona lider;

    public Comite(String nombre, List<Persona> miembros, String objetivo,Persona lider){
        this.nombre=nombre;
        this.miembros=miembros;
        this.objetivo=objetivo;
        this.lider=lider;
    }

    public List<Persona> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Persona> miembros) {
        this.miembros = miembros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Persona getLider() {
        return lider;
    }

    public void setLider(Persona lider) {
        this.lider = lider;
    }
}
