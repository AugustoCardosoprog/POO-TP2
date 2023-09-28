package Ej2;

public class Cliente {
    private String DNI;
    private String nombre;
    private String telefono;

    public Cliente(String DNI,String nombre){
        this.DNI = DNI;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }
}
