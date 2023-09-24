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
        otorgarCredencial();
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

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getSubscripcionStr(){
        if(subscripcion==Subscripcion.MEDIA){
            return "MEDIA";
        } else if (subscripcion==Subscripcion.DESTACADA) {
            return "DESTACADA";
        }else {
            return "BASICA";
        }
    }

    public void otorgarCredencial(){
        if (subscripcion== Socio.Subscripcion.MEDIA){
            CredencialMedia credencialMedia = new CredencialMedia(getDni());
            setCredencial(credencialMedia);
        } else if (subscripcion== Socio.Subscripcion.DESTACADA) {
            CredencialDestacada credencialDestacada = new CredencialDestacada(getDni());
            setCredencial(credencialDestacada);
        }else {
            CredencialBasica credencialBasica = new CredencialBasica(getDni());
            setCredencial(credencialBasica);
        }
    }

    public boolean accederActividad(Actividad actividad){
        return credencial.validarActividad(actividad);
    }
}

