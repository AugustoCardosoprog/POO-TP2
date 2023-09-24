package Ej1;

public class CredencialMedia extends Credencial {
    private final Actividad.Nivel nivel = Actividad.Nivel.MEDIO;

    public CredencialMedia(int dni) {
        super(dni);
    }


    //La credencial media tiene acceso a actividades de nivel medio y basico
    @Override
    public boolean validarActividad(Actividad actividad){
        if ((actividad.getNivel() == nivel)||(actividad.getNivel() == Actividad.Nivel.BASICO)){
            return true;
        }
        else {
            return false;
        }
    }
}

