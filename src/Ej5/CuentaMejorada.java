package Ej5;


import Ej4.Compra;
import Ej4.Cuenta;

import java.time.LocalDate;

public class CuentaMejorada extends Cuenta {
    private boolean precancelar = false;
    private LocalDate fechaInversion;
    private LocalDate fechaFinInversion;
    public CuentaMejorada(double saldo, double limiteGiroInicial) {
        super(saldo, limiteGiroInicial);
    }

    public void setPrecancelar(boolean precancelar) {
        this.precancelar = precancelar;
    }



    public boolean comprar(double monto){
        if (precancelar==false){
            if (saldo>=monto) {
                saldo -= monto;
                Compra nuevaCompra = new Compra(monto);
                compras.add(nuevaCompra);
                return true;
            }else if (monto<=(saldo+limiteGiro)){
                monto -= saldo;
                saldo = 0;
                limiteGiro -= monto;
                montoEnGiro += monto;
                Compra nuevaCompra = new Compra(monto);
                compras.add(nuevaCompra);
                return true;
            }else {
                return false;
            }
        }else {
            if (saldo>=monto) {
                saldo -= monto;
                Compra nuevaCompra = new Compra(monto);
                compras.add(nuevaCompra);
                return true;
            }else {
                return false;
            }
        }
    }

    public boolean invertir(double monto){
        if ((saldo>=monto)&&(invertido==0)){
            saldo -= monto;
            invertido += monto;
            fechaInversion = LocalDate.now();
            fechaFinInversion = fechaInversion.plusDays(60);
            fechaInversion = LocalDate.now();
            return true;
        }else {
            return false;
        }
    }

    public boolean recuperarInversion(){
        if (invertido != 0) {
            if (fechaFinInversion.isBefore(LocalDate.now()) || fechaFinInversion.isEqual(LocalDate.now())) {
                //Si ya paso la fecha de fin inversion o es la actual
                saldo += (invertido + (invertido * 0.40));
                invertido = 0;
                return true;
            } else if (fechaInversion.plusDays(30).isBefore(LocalDate.now())){
                //Si ya pasaron 30 dias
                saldo += (invertido + (invertido * 0.05));
                invertido = 0;
                return true;
            } else{
                //Si no pasaron ni 30 dias
                saldo += invertido;
                invertido = 0;
                return true;
            }
        } else {
            return false;
        }
    }

}
