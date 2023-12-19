
package damain;

import coneccion.*;
import java.sql.*;

public class ContadorID {
    public static int obtenerMaxId(Conexion conectar, String tabla) throws SQLException {
        try {
            Connection conexion = conectar.conectar();

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
    public static int obtenerMaxIdO(Conexion conectar, String tabla) throws SQLException {
        try {
            Connection conexion = conectar.conectar();

            String sql = "SELECT MAX(id_observacion) AS max_id FROM " + tabla;
            try (Statement statement = conexion.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                return resultSet.next() ? resultSet.getInt("max_id") : 0;
            }
        } finally {
            // Cerrar la conexión después de utilizarla
            conectar.cerrarConexion();
        }
    }
    public static int obtenerMaxIdA(Conexion conectar) throws SQLException {
        try {
            Connection conexion = conectar.conectar();

            String sql = "SELECT MAX(id_alumno) AS max_id FROM alumno" ;
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
