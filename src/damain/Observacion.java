/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package damain;

import java.util.Date;

/**
 *
 * @author Cesar
 */
public class Observacion {
    private String observacion;
    private Date fecha;

    // Constructor para inicializar la observacion y la fecha
    public Observacion(String observacion, Date fecha) {
        this.observacion = observacion;
        this.fecha = fecha;
    }

    // Métodos getter para obtener los valores de los atributos
    public String getObservacion() {
        return observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    // Métodos setter si necesitas cambiar los valores después de la creación
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public String toString() {
        return fecha + ": " + observacion;
    }
}
