package Ej3;

public class Credencial {
    private String dniAlumno;
    private Comision comision;


    public Credencial(String dniAlumno,Comision comision){
        this.dniAlumno = dniAlumno;
        this.comision = comision;
    }

    public Comision getComision() {
        return comision;
    }
}
