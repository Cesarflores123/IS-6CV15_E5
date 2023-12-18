/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package damain;

import java.time.LocalDate;

public class Asistencia {
    private int idAsistencia;
    private int idInfoAlumno;
    private LocalDate fecha;
    private String marca;

    public Asistencia(int idAsistencia, int idInfoAlumno, LocalDate fecha, String marca) {
        this.idAsistencia = idAsistencia;
        this.idInfoAlumno = idInfoAlumno;
        this.fecha = fecha;
        this.marca = marca;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public int getIdInfoAlumno() {
        return idInfoAlumno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getMarca() {
        return marca;
    }
}