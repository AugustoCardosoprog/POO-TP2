package Ej4;

public class MainEj4 {
    public static void main(String[] args) {

        //Cuenta Comun
        Cliente juan = new Cliente("12345678","Juan","Cruz");
        juan.otorgarCuentaComun(1000,1000);
        mostrarCuentaComun(juan);

        intentarCompra(juan,800);
        mostrarCuentaComun(juan);

        intentarCompra(juan,800);
        mostrarCuentaComun(juan);

        intentarCompra(juan,1000);
        mostrarCuentaComun(juan);

        juan.depositar(1000);
        System.out.println("Deposito 1000");
        mostrarCuentaComun(juan);

        intentarInvertir(juan,400);
        mostrarCuentaComun(juan);

        intentarInvertir(juan,100);
        mostrarCuentaComun(juan);

        juan.recuperarInversion();
        System.out.println("Recupero invertido");
        mostrarCuentaComun(juan);

        //Cuenta credito
        System.out.println("------------------------------------------");

        juan.otorgarCuentaCredito(1000);
        mostrarCuentaCredito(juan);

        intentarCompraCredito(juan,600);
        mostrarCuentaCredito(juan);

        intentarCompraCredito(juan,600);
        mostrarCuentaCredito(juan);

        intentarPagar(juan,300);
        mostrarCuentaCredito(juan);

        intentarPagar(juan,300);
        mostrarCuentaCredito(juan);

        intentarCompraCredito(juan,2000);
        mostrarCuentaCredito(juan);

        intentarPagar(juan,500);
        mostrarCuentaCredito(juan);
    }
    public static void intentarCompra(Cliente cliente,double monto){
        if (cliente.comprar(monto)){
            System.out.println(cliente.getNombre()+" Realizo compra de "+monto);;
        }else {
            System.out.println("No se pudo realizar compra de "+monto);
        }
    }


    public static void intentarCompraCredito(Cliente cliente,double monto){
        if (cliente.comprarConCredito(monto)){
            System.out.println(cliente.getNombre()+" Realizo compra de "+monto);;
        }else {
            System.out.println("No se pudo realizar compra de "+monto);
        }
    }
    public static void intentarInvertir(Cliente cliente,double monto){
        if (cliente.invertir(monto)){
            System.out.println(cliente.getNombre()+" Invirtio "+monto);;
        }else {
            System.out.println("No se pudo realizar la inversion de "+monto);
        }
    }
    public static void intentarPagar(Cliente cliente,double monto){
        if (cliente.pagarCredito(monto)){
            System.out.println(cliente.getNombre()+" ingreso pago de  "+monto);;
        }else {
            System.out.println("No se pudo realizar el pago de deuda de "+monto);
        }
    }
    public static void mostrarCuentaComun(Cliente cliente){
        System.out.println(cliente.getNombre()+", saldo:"+cliente.getSaldoCuenta()+", monto en giro en descubierto:"+cliente.getMontoEnGiro()+", Invertido:"+cliente.getInvertido()+", limite giro: "+cliente.getLimiteGiro()+"\n");
    }

    public static void mostrarCuentaCredito(Cliente cliente){
        System.out.println("Cuenta credito "+cliente.getNombre()+", monto en credito:"+cliente.getMontoEnCredito()+", limite credito: "+cliente.getLimiteCredito()+"\n");
    }
}
