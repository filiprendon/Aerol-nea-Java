package Aerolinea;

public class Avion {
    private String nombreAvion;
    private String fechaCreacion;
    private int capacidadCombustible;
    private int numeroPlazas;


    public Avion(String nombreAvion, String fechaCreacion, int capacidadCombustible, int numeroPlazas) {
        this.nombreAvion = nombreAvion;
        this.fechaCreacion = fechaCreacion;
        this.capacidadCombustible = capacidadCombustible;
        this.numeroPlazas = numeroPlazas;
    }
    public Avion(String nombreAvion, String fechaCreacion) {
        this.nombreAvion = nombreAvion;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreAvion() {
        return nombreAvion;
    }

    public void setNombreAvion(String nombreAvion) {
        this.nombreAvion = nombreAvion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(int capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public String toString() {
        return String.format(
                "---------------------\n" +
                "Nombre del avión: " + nombreAvion + "\n" +
                "Fecha de creación: " + fechaCreacion + "\n" +
                "Capacidad de combustible: " + capacidadCombustible + " Litros\n" +
                "Numero de plazas: " + numeroPlazas + "\n"
        );
    }
}





