package Ej3;

public class Profesor {
    private String DNI;
    private String nombre;
    private String npellido;

    public Profesor(String DNI,String nombre){
        this.nombre = nombre;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }
}
