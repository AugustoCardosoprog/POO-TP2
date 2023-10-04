package Ej5;

import Ej4.Cliente;

import Ej4.MainEj4;

import static Ej4.MainEj4.*;

public class MainEj5 {
    public static void main(String[] args) {
        ClienteMejorado juan = new ClienteMejorado("12345678","Juan","Cruz");
        juan.otorgarCuentaMejorada(1000,1000);
        mostrarCuentaComun(juan);

        intentarCompra(juan,800);
        mostrarCuentaComun(juan);

        juan.setPrecancelarCuenta(true);
        System.out.println("Se activo 'Precancelar'");

        intentarCompra(juan,800);
        mostrarCuentaComun(juan);

        juan.setPrecancelarCuenta(false);
        System.out.println("Se desactivo 'Precancelar'");

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
    }
}
