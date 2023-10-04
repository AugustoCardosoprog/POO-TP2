package Ej5;

import Ej4.Cliente;
import Ej4.Cuenta;

public class ClienteMejorado extends Cliente {


    public ClienteMejorado(String dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
    }

    public void otorgarCuentaMejorada(double saldoInicial,double limiteGiroInicial){
        cuenta = new CuentaMejorada(saldoInicial, limiteGiroInicial);
    }

    public void setPrecancelarCuenta(boolean precan){
        if (cuenta instanceof CuentaMejorada){
            CuentaMejorada cuentaMejorada = (CuentaMejorada) cuenta;
            cuentaMejorada.setPrecancelar(precan);
        }
    }
}
