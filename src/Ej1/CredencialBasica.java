package Ej1;

public class CredencialBasica extends Credencial {
    public final Actividad.Nivel nivel = Actividad.Nivel.BASICO;

    public CredencialBasica(int dni) {
        super(dni);
    }
}
