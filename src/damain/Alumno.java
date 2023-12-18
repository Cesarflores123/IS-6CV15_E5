/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package damain;

import java.util.List;

public class Alumno {
    private int idAlumno;
    private String nombreCompleto;
    private String boleta;
    private List<Asistencia> asistencias;

    public Alumno(int idAlumno, String nombreCompleto, String boleta, List<Asistencia> asistencias) {
        this.idAlumno = idAlumno;
        this.nombreCompleto = nombreCompleto;
        this.boleta = boleta;
        this.asistencias = asistencias;
    }
    
    // Getters y setters
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getBoleta() {
        return boleta;
    }

    public void setBoleta(String boleta) {
        this.boleta = boleta;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }
}