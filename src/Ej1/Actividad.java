package Ej1;

public class Actividad {
    private String nombre;
    private Nivel nivel;

    public enum Nivel{
        BASICO,MEDIO,DESTACADO
    }

    /**
     * POR DEFECTO SE CREA DE NIVEL BASICO
     */
    public Actividad(String nombre) {
        this.nombre = nombre;
        nivel = nivel.BASICO;

    }

    /**
     * 1.Nivel Basico / 2.Nivel Medio / 3.Nivel Destacado / Por defecto o error, Basico
     */
    public Actividad(String nombre,int level){
        this.nombre = nombre;
        cambiarNivel(level);
    }

    private boolean cambiarNivel(int level) {
        switch (level){
            case 1:
                nivel = nivel.BASICO;
                return true;
            case 2:
                nivel = nivel.MEDIO;
                return true;
            case 3:
                nivel = nivel.DESTACADO;
                return true;
            default:
                nivel = nivel.BASICO;
                return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Nivel getNivel() {
        return nivel;
    }
}
