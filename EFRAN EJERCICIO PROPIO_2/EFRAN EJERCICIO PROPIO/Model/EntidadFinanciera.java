package Model;

// Clase abstracta para mostrar clases abstractas
abstract class EntidadFinanciera {
    protected double fondos;

    public EntidadFinanciera(double fondos) {
        this.fondos = fondos;
    }

    // Método abstracto que debe ser implementado por las clases hijas
    public abstract void realizarTransaccion(double monto);
}

