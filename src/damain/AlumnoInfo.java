/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package damain;

import java.util.Date;

public class AlumnoInfo {

    private int idInfoAlumno;
    private int idAlumno;
    private String nombreCompleto;
    private String boleta;
    private Date fechaAsistencia;
    private String marcaAsistencia;

    public AlumnoInfo(int idInfoAlumno, int idAlumno, String nombreCompleto, String boleta, Date fechaAsistencia, String marcaAsistencia) {
        this.idInfoAlumno = idInfoAlumno;
        this.idAlumno = idAlumno;
        this.nombreCompleto = nombreCompleto;
        this.boleta = boleta;
        this.fechaAsistencia = fechaAsistencia;
        this.marcaAsistencia = marcaAsistencia;
    }

    public int getIdInfoAlumno() {
        return idInfoAlumno;
    }

    public void setIdInfoAlumno(int idInfoAlumno) {
        this.idInfoAlumno = idInfoAlumno;
    }

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

    public Date getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(Date fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public String getMarcaAsistencia() {
        return marcaAsistencia;
    }

    public void setMarcaAsistencia(String marcaAsistencia) {
        this.marcaAsistencia = marcaAsistencia;
    }
}
