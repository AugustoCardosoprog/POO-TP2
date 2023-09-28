package Ej2;

import java.time.LocalDate;

public class Compra {
    private Cliente cliente;
    private Paquete paquete;
    private LocalDate fecha;
    private int monto;

    public Compra(Cliente cliente, Paquete paquete,int monto){
        this.cliente = cliente;
        this.paquete = paquete;
        this.monto = monto;
        fecha = LocalDate.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getMonto() {
        return monto;
    }

    public Paquete getPaquete() {
        return paquete;
    }
}
