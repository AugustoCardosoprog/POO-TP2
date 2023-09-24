package Ej1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainEj1 {
    public static void main(String[] args) {
        ArrayList<Socio> listaSocios = new ArrayList<>();
        ArrayList<Actividad> listaActividades = new ArrayList<>();

        //Socios
        Socio juan = new Socio("Juan","Perez","123","juan@gmail.com",12345678,Socio.Subscripcion.MEDIA);
        listaSocios.add(juan);
        Socio ana = new Socio("Ana","Lopez","132","ana@gmail.com",32435476,Socio.Subscripcion.DESTACADA);
        listaSocios.add(ana);
        Socio mirta = new Socio("Mirta","Ford","700","mirta@gmail.com",29435996,Socio.Subscripcion.BASICA);
        listaSocios.add(mirta);

        for (Socio socio: listaSocios) {
            System.out.println("DNI: "+socio.getDni()+" "+socio.getNombre()+" "+socio.getApellido()+" Subscripcion: "+socio.getSubscripcionStr());
        }

        //Actividades
        Actividad cancha = new Actividad("Cancha",2);
        listaActividades.add(cancha);
        Actividad vestuarios = new Actividad("Vestuarios",3);
        listaActividades.add(vestuarios);
        Actividad buffet = new Actividad("Buffet",1);
        listaActividades.add(buffet);
        Actividad palco = new Actividad("Palco",3);
        listaActividades.add(palco);

        System.out.println("--------------------------------");
        for (Actividad actividad: listaActividades) {
            System.out.println("Actividad: "+actividad.getNombre()+", Nivel: "+actividad.getNivel());
        }

        System.out.println("----------------------------------------------------------------");

        System.out.println("Socios ordenados por subscripcion: ");
        for (Socio socio: sociosPorSubscripcion(listaSocios)){
            System.out.println("DNI: "+socio.getDni()+" "+socio.getNombre()+" "+socio.getApellido()+" Subscripcion: "+socio.getSubscripcionStr());
        }
        System.out.println("--------------------------------");

        System.out.println("Actividades ordenadas por nivel: ");
        for (Actividad actividad: actividadesPorNivel(listaActividades)) {
            System.out.println("Actividad: "+actividad.getNombre()+", Nivel: "+actividad.getNivel());
        }

        //Intentos de acceso
        System.out.println("----------------------------------------------------------------");
        intentaIngresar(ana,vestuarios);
        intentaIngresar(juan,vestuarios);
        intentaIngresar(juan,cancha);
        intentaIngresar(mirta,buffet);
        intentaIngresar(mirta,palco);
        intentaIngresar(ana,buffet);


    }

    public static void intentaIngresar(Socio socio,Actividad actividad){
        System.out.println(socio.getNombre()+" intenta ingresar a "+actividad.getNombre()+"...");
        if (socio.accederActividad(actividad)){
            System.out.println("Acceso otorgado.\n");
        }else {
            System.out.println("Acceso denegado.\n");
        }
    }
    public static ArrayList<Actividad> actividadesPorNivel(ArrayList<Actividad> lActividades){
        java.util.ArrayList<Ej1.Actividad> listaActividadesAux = new ArrayList<>(lActividades);
        Comparator<Ej1.Actividad> porNivel = Comparator.comparing(Ej1.Actividad::getNivel);
        Collections.sort(listaActividadesAux,porNivel);
        return listaActividadesAux;
    }

    public static ArrayList<Socio> sociosPorSubscripcion(ArrayList<Socio> lSocios){
        ArrayList<Socio> listaSociosAux = new ArrayList<>(lSocios);
        Comparator<Socio> porSubscripcion = Comparator.comparing(Socio::getSubscripcion);
        Collections.sort(listaSociosAux,porSubscripcion);
        return listaSociosAux;
    }
}
