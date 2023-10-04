package EJ4;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private Cuenta cuentaComun=null;
    private CuentaCredito cuentaCredito=null;
    public Cliente(String dni,String nombre,String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void otorgarCuentaComun(double saldoInicial,double limiteGiroInicial){
        cuentaComun = new Cuenta(saldoInicial,limiteGiroInicial);
    }


    public void otorgarCuentaCredito(double limiteCreditoInicial){
        cuentaCredito = new CuentaCredito(limiteCreditoInicial);
    }
    public boolean comprar(double monto){
        if (cuentaComun != null){
            return cuentaComun.comprar(monto);
        }else {
            return false;
        }
    }

    public boolean booleanCompraNecesitaGiro(double monto){
        if (cuentaComun != null) {
            return cuentaComun.necesitaGiro(monto);
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
        if (cuentaComun != null) {
            return cuentaComun.invertir(monto);
        } else {
            return  false;
        }
    }

    public boolean recuperarInversion(){
        if (cuentaComun != null) {
            return cuentaComun.recuperarInversion();
        }else {
            return  false;
        }

    }

    public void depositar(double monto){
        if (cuentaComun != null) {
            cuentaComun.depositar(monto);
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
        return cuentaComun.getSaldo();
    }


    public String getNombre() {
        return nombre;
    }

    public double getMontoEnGiro(){
        return cuentaComun.getMontoEnGiro();
    }

    public double getLimiteGiro(){
        return cuentaComun.getLimiteGiro();
    }

    public double getMontoEnCredito(){
        return cuentaCredito.getMontoEnCredito();
    }

    public double getLimiteCredito(){
        return cuentaCredito.getLimiteCredito();
    }
    public double getInvertido(){
        return cuentaComun.getInvertido();
    }
}
