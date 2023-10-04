package EJ4;

import java.util.ArrayList;

public class Cuenta {
    private double saldo;
    private double limiteGiro;
    private double limiteGiroInicial;
    private double montoEnGiro;
    private double invertido = 0;
    private ArrayList<Compra> compras = new ArrayList<>();


    public Cuenta(double saldo,double limiteGiroInicial){
        this.saldo = saldo;
        this.limiteGiroInicial = limiteGiroInicial;
        limiteGiro = limiteGiroInicial;
    }

    public boolean comprar(double monto){
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
    }
    public boolean necesitaGiro(double monto){
        if (saldo<monto){
            return true;
        }else {
            return false;
        }
    }

    public boolean invertir(double monto){
        if ((saldo>=monto)&&(invertido==0)){
            saldo -= monto;
            invertido += monto;
            return true;
        }else {
            return false;
        }
    }

    public boolean recuperarInversion(){
        if (invertido!=0){
            saldo += (invertido+(invertido*0.40));
            invertido = 0;
            return true;
        }else {
            return false;
        }
    }

    public void depositar(double monto){
        if (montoEnGiro==0){
            saldo += monto;
        }else if (montoEnGiro >= monto){
            montoEnGiro -= monto;
            limiteGiro += monto;
        } else {
            monto -= montoEnGiro;
            montoEnGiro = 0;
            limiteGiro = limiteGiroInicial;
            saldo += monto;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public double getInvertido() {
        return invertido;
    }

    public double getMontoEnGiro() {
        return montoEnGiro;
    }

    public double getLimiteGiro() {
        return limiteGiro;
    }
}
