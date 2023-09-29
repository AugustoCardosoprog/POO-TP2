package EJ4;

import java.util.ArrayList;

public class CuentaCredito {
    private double saldo;
    private double limiteCredito;
    private double limiteCreditoInicial;
    private double montoEnCredito;
    private ArrayList<Compra> compras;
    private static double RECARGOFIJO = 0.05;

    public CuentaCredito(double saldo,double limiteCreditoInicial){
        this.saldo = saldo;
        this.limiteCreditoInicial = limiteCreditoInicial;
        limiteCredito = limiteCreditoInicial;
    }

    public boolean comprar(double monto){
        if (saldo>=monto){
            saldo -= monto;
            Compra nuevaCompra = new Compra(monto);
            compras.add(nuevaCompra);
            return true;
        } else if ((monto<=(saldo+limiteCredito))){
            monto -= saldo;
            saldo = 0;
            limiteCredito-= monto;
            montoEnCredito += monto;
            Compra nuevaCompra = new Compra(monto);
            compras.add(nuevaCompra);
            return true;
        }else {
            return false;
        }
    }

    public void depositar(double monto){
        saldo += monto;
    }

    public boolean pagarDeuda(double monto){
        double montoConInteres = monto*RECARGOFIJO;
        if (montoEnCredito==0){
            return false;
        } else if(montoConInteres >= montoEnCredito) {
            montoConInteres -= montoEnCredito;
            montoEnCredito = 0;
            limiteCredito += monto;
            saldo += monto;
            return true;
        }else {
            montoEnCredito-= montoConInteres;
            limiteCredito += monto;
            return true;
        }

    }
}
