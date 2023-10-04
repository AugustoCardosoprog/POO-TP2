package Ej4;

import Ej5.CuentaMejorada;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    protected Cuenta cuenta=null;
    private CuentaCredito cuentaCredito=null;

    public Cliente(String dni,String nombre,String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void otorgarCuentaComun(double saldoInicial,double limiteGiroInicial){
        cuenta = new Cuenta(saldoInicial,limiteGiroInicial);
    }


    public void otorgarCuentaCredito(double limiteCreditoInicial){
        cuentaCredito = new CuentaCredito(limiteCreditoInicial);
    }
    public boolean comprar(double monto){
        if (cuenta != null){
            return cuenta.comprar(monto);
        }else {
            return false;
        }
    }

    public boolean booleanCompraNecesitaGiro(double monto){
        if (cuenta != null) {
            return cuenta.necesitaGiro(monto);
        }else {
            return false;
        }
    }

    public boolean comprarConCredito(double monto){
        if (cuentaCredito != null) {
        return cuentaCredito.comprar(monto);
        }else {
            return false;
        }
    }

    public boolean invertir(double monto){
        if (cuenta != null) {
            return cuenta.invertir(monto);
        } else {
            return  false;
        }
    }

    public boolean recuperarInversion(){
        if (cuenta != null) {
            return cuenta.recuperarInversion();
        }else {
            return  false;
        }

    }

    public void depositar(double monto){
        if (cuenta != null) {
            cuenta.depositar(monto);
        }
    }


    public boolean pagarCredito(double monto){
        if (cuentaCredito!= null) {
            return cuentaCredito.pagarDeuda(monto);
        }else {
            return  false;
        }
    }

    public double getSaldoCuenta(){
        if (cuenta!=null){
        return cuenta.getSaldo();
        }
        return 0;
    }


    public String getNombre() {
        return nombre;
    }

    public double getMontoEnGiro(){
        return cuenta.getMontoEnGiro();
    }

    public double getLimiteGiro(){
        return cuenta.getLimiteGiro();
    }

    public double getMontoEnCredito(){
        return cuentaCredito.getMontoEnCredito();
    }

    public double getLimiteCredito(){
        return cuentaCredito.getLimiteCredito();
    }
    public double getInvertido(){
        return cuenta.getInvertido();
    }
}
