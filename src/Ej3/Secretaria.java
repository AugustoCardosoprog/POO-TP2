package Ej3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Secretaria {
    private ArrayList<Asistencia> lAsistencias = new ArrayList<>();
    private ArrayList<Alumno> lAlumnos = new ArrayList<>();

    public Alumno registrarAlumno(String DNI, String nombre, String apellido, Comision comision) {
        Alumno nuevoAlumno = new Alumno(DNI, nombre, apellido);
        lAlumnos.add(nuevoAlumno);
        otorgarCredencial(nuevoAlumno, comision);
        return nuevoAlumno;
    }

    private boolean otorgarCredencial(Alumno alumno, Comision comision) {
        Credencial nuevaCredencial = new Credencial(alumno.getNombre(), comision);
        alumno.setCredencial(nuevaCredencial);
        return true;
    }

    public boolean registrarAsistencia(Alumno alumno) {
        if (alumno.getCredencial() != null) {
            Credencial credencial = alumno.getCredencial();
            Comision comision = credencial.getComision();
            Asistencia asistencia = new Asistencia(LocalDate.now(), comision.getHora(), alumno.getDNI(), comision);
            lAsistencias.add(asistencia);
            return true;
        } else {
            return false;
        }
    }

    public double calcularPagoProfesor(Profesor profesor){
        int contAsistencias = 0;
        double pagoPorAsisctencia = 10.0;
        for (Asistencia asistencia: lAsistencias){
            Profesor profesorDeLaAsistencia = asistencia.getComision().getProfesor();
            if (profesorDeLaAsistencia.equals(profesor)) {
                contAsistencias++;
            }
        }
        return contAsistencias * pagoPorAsisctencia;
    }

    public ArrayList<Asistencia> getLAsistencias() {
        return lAsistencias;
    }

    public Disciplina calcularDisciplinamasRentable(){
        Disciplina disciplinaMasAsistida = new Disciplina("");
        int maxCantidadAsistencias = 0;

        Map<Disciplina, Integer> cantidadAsistenciasPorDisciplina = new HashMap<>();

        for (Asistencia asistencia : lAsistencias) {
            int veces=0;
            Disciplina disciplina = asistencia.getComision().getDisciplina();

            if (cantidadAsistenciasPorDisciplina.containsKey(disciplina)) {
                //Si ya esta le sumo
                cantidadAsistenciasPorDisciplina.put(disciplina, cantidadAsistenciasPorDisciplina.get(disciplina) + 1);
            }else {
                //Si no esta la agrego y sumo 1
                cantidadAsistenciasPorDisciplina.put(disciplina, 1);
            }
        }

        for (Map.Entry<Disciplina, Integer> entry : cantidadAsistenciasPorDisciplina.entrySet()) {
            if (entry.getValue() > maxCantidadAsistencias) {
                maxCantidadAsistencias = entry.getValue();
                disciplinaMasAsistida = entry.getKey();
            }
        }
        return disciplinaMasAsistida;
    }
}



