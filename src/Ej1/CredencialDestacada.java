package Ej1;

public class CredencialDestacada extends Credencial {
    private final Actividad.Nivel nivel = Actividad.Nivel.MEDIO;

    public CredencialDestacada(int dni) {
        super(dni);
    }

    //La credencial destacada tiene acceso a cualquier actividad
    @Override
    public boolean validarActividad(Actividad actividad){
        return true;
    }
}

