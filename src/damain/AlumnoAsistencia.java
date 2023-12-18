/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package damain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoAsistencia {

    private int idAlumno;
    private String nombreCompleto;
    private String boleta;
    private Map<String, String> asistencias;

    public AlumnoAsistencia(int idAlumno, String nombreCompleto, String boleta) {
        this.idAlumno = idAlumno;
        this.nombreCompleto = nombreCompleto;
        this.boleta = boleta;
        this.asistencias = new HashMap<>();
    }

    public void addAsistencia(String fecha, String marcaAsistencia) {
        asistencias.put(fecha, marcaAsistencia);
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getBoleta() {
        return boleta;
    }

    public Map<String, String> getAsistencias() {
        return asistencias;
    }
}
