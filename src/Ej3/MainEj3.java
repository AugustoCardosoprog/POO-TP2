package Ej3;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class MainEj3 {
    public static void main(String[] args) {
        Secretaria secretaria = new Secretaria();

        //Disciplina
        Disciplina dTango = new Disciplina("Tango");
        Disciplina dSalsa = new Disciplina("Salsa");
        Disciplina dClasico = new Disciplina("Clasico");
        Disciplina dBachata = new Disciplina("Bachata");

        //Profesores
        Profesor profe1 = new Profesor("12345678","Pepe");
        Profesor profe2 = new Profesor("12345679","Graciela");
        Profesor profe3 = new Profesor("12345677","Oscar");

        //Comisiones
        Comision cTangoLun = new Comision(Comision.Dia.LUNES, LocalTime.of(10,30),dTango,profe1 );
        Comision cClasicoJue = new Comision(Comision.Dia.JUEVES, LocalTime.of(19,00),dClasico,profe3 );
        Comision cTangoMar= new Comision(Comision.Dia.MARTES, LocalTime.of(14,15),dTango,profe2 );
        Comision cSalsaMier = new Comision(Comision.Dia.MIERCOLES, LocalTime.of(10,30),dSalsa,profe2 );

        //Alumnos
        Alumno carlos = secretaria.registrarAlumno("87654321","Carlos","Flores",cTangoLun);
        Alumno pedro = secretaria.registrarAlumno("87654322","Pedro","Martinez",cTangoMar);
        Alumno laura = secretaria.registrarAlumno("87654323","Laura","Ruiz",cClasicoJue);
        Alumno isabella = secretaria.registrarAlumno("87654324","Isabella","Torres",cClasicoJue);
        Alumno maria = secretaria.registrarAlumno("87654325","Maria","Perez",cClasicoJue);
        Alumno juan = secretaria.registrarAlumno("87654326","Juan","Gonzalez",cSalsaMier);

        //Asistencias
        secretaria.registrarAsistencia(carlos);
        secretaria.registrarAsistencia(pedro);
        secretaria.registrarAsistencia(laura);
        secretaria.registrarAsistencia(juan);
        secretaria.registrarAsistencia(carlos);
        secretaria.registrarAsistencia(maria);
        secretaria.registrarAsistencia(isabella);
        secretaria.registrarAsistencia(juan);
        secretaria.registrarAsistencia(isabella);

        System.out.println("Asistencias: ");
        System.out.println("----------------------------------");
        mostrarAsistencias(secretaria.getLAsistencias());

        System.out.println();
        System.out.println("Pagos a profesores: ");
        System.out.println("----------------------------------");
        System.out.println("Pago profesor "+profe1.getNombre()+": "+secretaria.calcularPagoProfesor(profe1));
        System.out.println("Pago profesor "+profe2.getNombre()+": "+secretaria.calcularPagoProfesor(profe2));
        System.out.println("Pago profesor "+profe3.getNombre()+": "+secretaria.calcularPagoProfesor(profe3));

        System.out.println();
        System.out.println("Disciplina mas rentable: ");
        System.out.println(secretaria.calcularDisciplinamasRentable().getNombre());
    }

    public static void mostrarAsistencias(ArrayList<Asistencia> lAsistencias){
        for (Asistencia asistencia: lAsistencias) {
            System.out.println(asistencia.getComision().getDisciplina().getNombre()+", Dia: "+asistencia.getDia()+", Hora: "+asistencia.getHora()+", DNI Alumno: "+asistencia.getDniAlumno()+", Profe:"+asistencia.getComision().getProfesor().getNombre());
        }
    }
}
