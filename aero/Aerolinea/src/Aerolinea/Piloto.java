package Aerolinea;

public class Piloto {
    private int idPiloto;
    private String nombre;
    private String apellido;
    private String dni;
    private int telefono;

    private String fechaNacimiento;

    public Piloto(int idPiloto, String nombre, String apellido, String dni, int telefono, String fechaNacimiento) {
        this.idPiloto = idPiloto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdentificacion() {
        return idPiloto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setIdentificacion(int identificacion) {
        this.idPiloto = identificacion;
    }


    public String toString(){
        return String.format(
                "---------------------\n" +
                        "Codigo del piloto: "+idPiloto+"\n" +
                        "Nombre: "+nombre+"\n" +
                        "Apellido: "+apellido+"\n" +
                        "DNI: "+dni+"\n" +
                        "Telefono: "+telefono+"\n" +
                        "Fecha de nacimiento: "+fechaNacimiento+"\n"
        );
    }
}
