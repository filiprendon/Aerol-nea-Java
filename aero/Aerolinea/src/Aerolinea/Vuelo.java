package Aerolinea;

import java.time.LocalTime;

public class Vuelo {
    private int codigoVuelo;
    private String origen;
    private String destino;
    private int duracionVuelo;
    private LocalTime horaSalida;
    private LocalTime horaLlegada;
    private int billetes;
    private double precioBillete;
    private Piloto piloto;
    private Avion avion;

    private int plazasDisponibles;
    private double porcentajeDevolucion;

    public Vuelo(Avion avion, Piloto piloto, int codigoVuelo, String origen, String destino, LocalTime horaSalida, int duracionVuelo, double precioBillete) {
        this.avion = avion;
        this.piloto = piloto;
        this.codigoVuelo = codigoVuelo;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        calcularHoraLegada(duracionVuelo);
        this.duracionVuelo = duracionVuelo;
        this.precioBillete = precioBillete;
    }

    public int getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(int codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDuracionVuelo() {
        return duracionVuelo;
    }

    public void setDuracionVuelo(int duracionVuelo) {
        this.duracionVuelo = duracionVuelo;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getBitllets() {
        return billetes;
    }

    public void setBilletes(int bitllets) {
        this.billetes = billetes;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Avion getAvion() {
        return avion;
    }


    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public double getPrecioBillete() {
        return precioBillete;
    }

    public void setPrecioBillete(double precioBillete) {
        this.precioBillete = precioBillete;
    }

    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public void setPlazasDisponibles(int plazasDisponibles) {
        this.plazasDisponibles = plazasDisponibles;
    }

    public double getPorcentajeDevolucion() {
        return porcentajeDevolucion;
    }

    public void setPorcentajeDevolucion(double porcentajeDevolucion) {
        this.porcentajeDevolucion = porcentajeDevolucion;
    }
    public void calcularHoraLegada(int duracionVuelo){
        this.duracionVuelo = duracionVuelo;
        this.horaLlegada = this.horaSalida.plusMinutes(this.duracionVuelo);
    }


    public String toString(){
        return String.format(
                "---------------------\n" +
                        "Código de vuelo: "+codigoVuelo+"\n" +
                        "Origen: "+origen+"\n" +
                        "Destino: "+destino+"\n" +
                        "Duración: "+duracionVuelo+"\n" +
                        "Hora de salida: "+horaSalida+"\n" +
                        "Hora de llegada: "+horaLlegada+"\n"
        );
    }


}