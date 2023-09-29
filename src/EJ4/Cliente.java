package EJ4;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private Cuenta cuentaComun;
    private CuentaCredito cuentaCredito;
    public Cliente(String dni,String nombre,String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void otorgarCuentaComun(double saldoInicial,double limiteGiroInicial){
        cuentaComun = new Cuenta(saldoInicial,limiteGiroInicial);
    }

    public void otorgarCuentaCredito(double saldoInicial,double limiteCreditoInicial){
        cuentaCredito = new CuentaCredito(saldoInicial,limiteCreditoInicial);
    }
    public boolean comprar(double monto){
        return cuentaComun.comprar(monto);
    }

    public boolean comprarConCredito(double monto){
        return cuentaCredito.comprar(monto);
    }

    public boolean invertir(double monto){
        return cuentaComun.invertir(monto);
    }

    public boolean recuperarInversion(){
        return cuentaComun.recuperarInversion();
    }

    public void depositar(double monto){
        cuentaComun.depositar(monto);
    }

    public void depositarCuentaCredito(double monto){
        cuentaCredito.depositar(monto);
    }

    public boolean pagarCredito(double monto){
        return cuentaCredito.pagarDeuda(monto);
    }
}
