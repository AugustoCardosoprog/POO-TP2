package Ej3;


public class Alumno {
    private String DNI;
    private String nombre;
    private String apellido;
    private Credencial credencial;

    public Alumno(String DNI,String nombre,String apellido){
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }
}
