package Ej2;

import Ej1.Socio;

import java.util.*;

public class MainEj2 {
    public static void main(String[] args) {
        ArrayList<Proveedor> listaProveedores = new ArrayList<>();
        ArrayList<Paquete> listaPaquetes = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Compra> listaCompras = new ArrayList<>();

        //Prueba

        //Proveedores//
        Proveedor proveedor1 = new Proveedor("Atlantida",Proveedor.Tipo.MEDIOTRANSPORTE);
        listaProveedores.add(proveedor1);
        Proveedor proveedor2 = new Proveedor("Marina View",Proveedor.Tipo.HOSPEDAJE);
        listaProveedores.add(proveedor2);
        Proveedor proveedor3 = new Proveedor("Turismo Estrella", Proveedor.Tipo.MEDIOTRANSPORTE);
        listaProveedores.add(proveedor3);
        Proveedor proveedor4 = new Proveedor("Sunset Paradise",Proveedor.Tipo.HOSPEDAJE);
        listaProveedores.add(proveedor4);
        Proveedor proveedor5 = new Proveedor("Naturaleza Viva",Proveedor.Tipo.EXCURSION);
        listaProveedores.add(proveedor5);




        //Servicios//
        MedioTransporte auto = new MedioTransporte("Auto",proveedor2);
        MedioTransporte barco = new MedioTransporte("Barco",proveedor1);
        Hospedaje hotel1 = new Hospedaje("Hotel1",proveedor2);
        Hospedaje hotel2 = new Hospedaje("hotel2",proveedor2);
        Excursion remo = new Excursion("Remo",proveedor1);
        Excursion paseo = new Excursion("Paseo a caballo",proveedor1);

        //Destinos//
        Destino bariloche = new Destino("Bariloche");
        Destino hawai = new Destino("Hawai");

        //Paquetes//
        Paquete paquete1 = new Paquete("Paquete1");
        paquete1.setMedioTransporte(auto);
        paquete1.addExcursion(remo);
        paquete1.addExcursion(paseo);
        paquete1.setHospedaje(hotel1);
        paquete1.setDestino(hawai);
        listaPaquetes.add(paquete1);

        Paquete paquete2 = new Paquete("Paquete2");
        paquete2.setMedioTransporte(barco);
        paquete2.addExcursion(paseo);
        paquete2.addExcursion(remo);
        paquete2.setHospedaje(hotel2);
        paquete2.setDestino(bariloche);
        listaPaquetes.add(paquete2);

        //Clientes
        Cliente cliente1 = new Cliente("1234","juan");
        listaClientes.add(cliente1);
        Cliente cliente2 = new Cliente("1234","lucia");
        listaClientes.add(cliente2);

        //Compras
        Compra compra1 = new Compra(cliente1,paquete1,16000);
        listaCompras.add(compra1);
        Compra compra2 = new Compra(cliente2,paquete2,29000);
        listaCompras.add(compra2);
        Compra compra3 = new Compra(cliente2,paquete1,16000);
        listaCompras.add(compra3);

        //Prints
        System.out.println("\n");
        System.out.println("Proveedores:");
        System.out.println("-------------------------------------");
        mostrarProveedores(listaProveedores);

        System.out.println("\n");
        System.out.println("Paquetes:");
        System.out.println("-------------------------------------");
        mostrarPaquetes(listaPaquetes);

        System.out.println("\n");
        System.out.println("Clientes:");
        System.out.println("-------------------------------------");
        mostrarClientes(listaClientes);;

        System.out.println("\n");
        System.out.println("Compras:");
        System.out.println("-------------------------------------");
        mostrarComprasPorCliente(listaCompras);;

        System.out.println("\n");
        System.out.println("Compras por destino:");
        System.out.println("-------------------------------------");
        mostrarComprasPorDestino(listaCompras);;

        System.out.println("\n");
        System.out.println("-------------------------------------");
        mostrarDestinoMasVendido(listaCompras);;
    }

    public static void mostrarProveedores(ArrayList<Proveedor> listaProveedores){
        ArrayList<Proveedor> proveedoresOrdenados = proveedoresPorActividad(listaProveedores);
        for (Proveedor proveedor : proveedoresOrdenados) {
            System.out.println("Proveedor: "+proveedor.getNombre()+", Tipo: "+proveedor.getTipo());
        }
    }

    public static void mostrarPaquetes(ArrayList<Paquete> lPaquetes){
        for (Paquete paquete : lPaquetes) {
            System.out.println("-- "+paquete.getNombre()+", Destino: "+(paquete.getDestino()).getNombre()+", Medio de transporte: "+(paquete.getMedioTransporte()).getNombre());
            System.out.println(", Hospedaje: "+(paquete.getHospedaje()).getNombre()+", Excursiones: ");
            for (Excursion excursion:(paquete.getExcursiones())) {
                System.out.printf(excursion.getNombre()+",");
            }
            System.out.println();
        }
    }

    public static void mostrarClientes(ArrayList<Cliente> clientes){
        for (Cliente cliente: clientes) {
            System.out.println("DNI:"+cliente.getDNI()+", Nombre: "+cliente.getNombre());
        }
    }

    public static void mostrarComprasPorCliente(ArrayList<Compra> lCompras){

        Collections.sort(lCompras, Comparator.comparing(compra -> compra.getCliente().getNombre()));
        for (Compra compra : lCompras) {
            System.out.println("Cliente: " + compra.getCliente().getNombre() + ", Paquete : "+compra.getPaquete().getNombre()+ ", Monto: " + compra.getMonto());
        }
    }

    public static void mostrarDestinoMasVendido(ArrayList<Compra> lCompras){
        Map<Destino, Integer> contadorDestinos = new HashMap<>();

        for (Compra compra : lCompras) {
            Paquete paquete = compra.getPaquete();
            Destino destino = paquete.getDestino();
            if (contadorDestinos.containsKey(destino)) {
                contadorDestinos.put(destino, contadorDestinos.get(destino) + 1);
            } else {
                contadorDestinos.put(destino, 1);
            }
        }

        //encontrar en el hashmap el mas comprado

        Destino destinoMasComprado = null;
        int maxCompras = 0;

        for (Map.Entry<Destino, Integer> entry : contadorDestinos.entrySet()) {
            if (entry.getValue() > maxCompras) {
                maxCompras = entry.getValue();
                destinoMasComprado = entry.getKey();
            }
        }

        if (destinoMasComprado != null) {
            System.out.println("Destino mas comprado : " + destinoMasComprado.getNombre()+", Numero de compras: " + maxCompras);
        }
    }

    public static void mostrarComprasPorDestino (ArrayList<Compra> lCompras){

        Collections.sort(lCompras, Comparator.comparing(compra -> compra.getPaquete().getDestino().getNombre()));
        for (Compra compra : lCompras) {
            System.out.println("Cliente: " + compra.getCliente().getNombre() + ", Paquete : "+compra.getPaquete().getNombre()+ ", Monto: " + compra.getMonto()+", Destino: "+(compra.getPaquete().getDestino().getNombre()));
        }
    }
    public static ArrayList<Proveedor> proveedoresPorActividad(ArrayList<Proveedor> lProveedores){
        ArrayList<Proveedor> lProveedoresAux = new ArrayList<>(lProveedores);
        Comparator<Proveedor> porActividad = Comparator.comparing(Proveedor::getTipo);
        Collections.sort(lProveedoresAux,porActividad);
        return lProveedoresAux;
    }



}
