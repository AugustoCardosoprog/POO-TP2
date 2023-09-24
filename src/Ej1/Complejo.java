package Ej1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Complejo {
    private ArrayList<Socio> listaSocios = new ArrayList<>();
    private ArrayList<Actividad> listaActividades = new ArrayList<>();

    public void altaSocio(String nombre, String apellido, String direccion, String email, int dni, Socio.Subscripcion subscripcion){
        Socio socio = new Socio(nombre,apellido,direccion,email,dni,subscripcion);
        listaSocios.add(socio);
    }

    public void altaActividad(String nombre,int level){
        Actividad actividad = new Actividad(nombre,level);
        listaActividades.add(actividad);
    }
    public ArrayList<Actividad> actividadesPorNivel(){
        ArrayList<Actividad> listaActividadesAux = new ArrayList<>(listaActividades);
        Comparator<Actividad> porNivel = Comparator.comparing(Actividad::getNivel);
        Collections.sort(listaActividadesAux,porNivel);
        return listaActividadesAux;
    }

    public ArrayList<Socio> sociosPorSubscripcion(){
        ArrayList<Socio> listaSociosAux = new ArrayList<>(listaSocios);
        Comparator<Socio> porSubscripcion = Comparator.comparing(Socio::getSubscripcion);
        Collections.sort(listaSociosAux,porSubscripcion);
        return listaSociosAux;
    }

    public void otorgarCredencial(Socio socio){
        if (socio.getSubscripcion()== Socio.Subscripcion.MEDIA){
            CredencialMedia credencialMedia = new CredencialMedia(socio.getDni());
            socio.setCredencial(credencialMedia);
        } else if (socio.getSubscripcion()== Socio.Subscripcion.DESTACADA) {
            CredencialDestacada credencialDestacada = new CredencialDestacada(socio.getDni());
            socio.setCredencial(credencialDestacada);
        }else {
            CredencialBasica credencialBasica = new CredencialBasica(socio.getDni());
            socio.setCredencial(credencialBasica);
        }
    }

}
