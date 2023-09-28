package Ej2;

public class Proveedor {
    private String nombre;
    private Tipo tipo;

    enum Tipo{
        MEDIOTRANSPORTE,HOSPEDAJE,EXCURSION
    }
    public Proveedor(String nombre,Tipo tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }


    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }
}

