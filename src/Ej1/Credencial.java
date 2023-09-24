package Ej1;

public class Credencial {
    private int dniSocio;
    private final Actividad.Nivel nivel=null;


    public Credencial(int dni) {
        this.dniSocio = dni;
    }

    public boolean validarActividad(Actividad actividad){
        if (actividad.getNivel()== nivel){
            return true;
        }
        else {
            return false;
        }
    }
}
