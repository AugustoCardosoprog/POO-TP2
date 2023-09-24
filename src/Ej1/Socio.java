package Ej1;

public class Socio {
    private String nombre;
    private String apellido;
    private int dni;
    private String direccion;
    private String email;
    private Credencial credencial;
    public Socio(String nombre,String apellido,String direccion,String email,int dni){
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.email=email;
        this.dni=dni;
    }
}
