package Ej3;

import Ej1.Actividad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Comision {
    private Dia dia;
    private LocalTime hora;
    private Nivel nivel;
    private Disciplina disciplina;
    private Profesor profesor;

    enum Dia{
        LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO,DOMINGO
    }
    public Comision(Dia dia, LocalTime hora, Disciplina disciplina, Profesor profesor){
        this.dia = dia;
        this.hora = hora;
        this.disciplina = disciplina;
        this.profesor = profesor;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    enum Nivel{
        INICIAL,INTERMEDIO,AVANZADO
    }

    public Dia getDia() {
        return dia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
