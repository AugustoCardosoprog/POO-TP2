package Ej3;

import java.time.LocalDate;
import java.time.LocalTime;

public class Asistencia {
    private LocalDate dia;
    private LocalTime hora;
    private String dniAlumno;
    private Comision comision;

    public Asistencia(LocalDate dia,LocalTime hora,String dniAlumno,Comision comision){
        this.dia = dia;
        this.hora = hora;
        this.dniAlumno = dniAlumno;
        this.comision = comision;
    }

    public Comision getComision() {
        return comision;
    }

    public LocalDate getDia() {
        return dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getDniAlumno() {
        return dniAlumno;
    }
}
