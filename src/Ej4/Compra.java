package Ej4;

import java.time.LocalDate;

public class Compra {
    private double monto;
    private LocalDate fecha;

    public Compra(double monto){
        this.monto = monto;
        fecha = LocalDate.now();
    }
}
