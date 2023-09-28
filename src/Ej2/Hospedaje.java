package Ej2;

public class Hospedaje extends Servicio{
    private String ubicacion;

    public Hospedaje(String nombre,Proveedor proveedor) {
        super(nombre,proveedor);

    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
