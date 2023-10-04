package Ej4;

import java.util.ArrayList;

public class CuentaCredito {
    //private double saldo;
    private double limiteCredito;
    private double limiteCreditoInicial;
    private double montoEnCredito;
    private ArrayList<Compra> compras = new ArrayList<>();
    private static double RECARGOFIJO = 0.05;

    public CuentaCredito(double limiteCreditoInicial){
        this.limiteCreditoInicial = limiteCreditoInicial;
        limiteCredito = limiteCreditoInicial;
    }

    public boolean comprar(double monto){
        double montoConRecargo = monto+(monto*RECARGOFIJO);
        if(montoConRecargo<=limiteCredito){
            limiteCredito -= montoConRecargo;
            montoEnCredito += monto;
            return true;
        }else {
            return false;
        }

    }


    public boolean pagarDeuda(double monto){
        //double montoConInteres = montoEnCredito+(montoEnCredito*RECARGOFIJO);
        if (montoEnCredito==0){
            return false;
        } else if(montoEnCredito>=monto) {
            montoEnCredito -= monto;
            limiteCredito += monto;
            return true;
        }else {
            return false;
        }
    }


    public double getLimiteCredito() {
        return limiteCredito;
    }

    public double getMontoEnCredito() {
        return montoEnCredito;
    }
}
