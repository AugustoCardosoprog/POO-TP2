package Ej2;

import java.util.ArrayList;

public class Paquete {
    private String nombre;
    private Destino destino;
    private MedioTransporte medioTransporte;
    private Hospedaje hospedaje;
    private ArrayList<Excursion> excursiones = new ArrayList<>();

    public Paquete(String nombre){
        this.nombre = nombre;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public void addExcursion(Excursion excursion) {
        excursiones.add(excursion);
    }

    public void setHospedaje(Hospedaje hospedaje) {
        this.hospedaje = hospedaje;
    }

    public void setMedioTransporte(MedioTransporte medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Excursion> getExcursiones() {
        return excursiones;
    }

    public Destino getDestino() {
        return destino;
    }

    public Hospedaje getHospedaje() {
        return hospedaje;
    }

    public MedioTransporte getMedioTransporte() {
        return medioTransporte;
    }
}
