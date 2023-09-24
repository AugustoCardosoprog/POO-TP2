package Ej1;

public class Socio {
    private String nombre;
    private String apellido;
    private int dni;
    private String direccion;
    private String email;
    private Credencial credencial;
    private Subscripcion subscripcion;

    public enum Subscripcion{
        BASICA,MEDIA,DESTACADA
    }


    public Socio(String nombre,String apellido,String direccion,String email,int dni,Subscripcion subscripcion){
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.email=email;
        this.dni=dni;
        this.subscripcion=subscripcion;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public Subscripcion getSubscripcion() {
        return subscripcion;
    }

    public int getDni() {
        return dni;
    }
}

