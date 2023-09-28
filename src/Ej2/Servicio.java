package Ej2;

public class Servicio {
    private String nombre;
    private String descripcion;
    private boolean disponibilidad;
    protected Proveedor proveedor;

    public Servicio(String nombre,Proveedor proveedor){
        this.nombre = nombre;
        this.proveedor = proveedor;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
