/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package damain;

import coneccion.*;
import java.sql.*;
/**
 *
 * @author Cesar
 */
public class ContadorID {
    public static int obtenerMaxId(Conexion conectar, String tabla) throws SQLException {
        try {
            // Obtener la conexión a la base de datos
            Connection conexion = conectar.conectar();

            // Realizar la consulta para obtener el máximo ID
            String sql = "SELECT MAX(id_" + tabla + ") AS max_id FROM " + tabla;
            try (Statement statement = conexion.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                return resultSet.next() ? resultSet.getInt("max_id") : 0;
            }
        } finally {
            // Cerrar la conexión después de utilizarla
            conectar.cerrarConexion();
        }
    }
}
