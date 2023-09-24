package Ej1;

public class CredencialBasica extends Credencial {
    public final Actividad.Nivel nivel = Actividad.Nivel.BASICO;

    public CredencialBasica(int dni) {
        super(dni);
    }

    @Override
    public boolean validarActividad(Actividad actividad){
        if (actividad.getNivel()== nivel){
            return true;
        }
        else {
            return false;
        }
    }
}
