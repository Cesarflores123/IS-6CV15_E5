package damain;

import coneccion.*;
import java.sql.*;

public class ObtenerID {

    public static int obtenerIDA(Conexion conectar, String nombreAsignatura) throws SQLException {
        int idAsignatura = -1;
        Connection conexion = conectar.conectar();
        String query = "SELECT id_asignatura FROM asignatura WHERE asignatura = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, nombreAsignatura);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    idAsignatura = resultSet.getInt("id_asignatura");
                }
            }
        }
        return idAsignatura;
    }
    public static int obtenerIDC(Conexion conectar, String cicloEscolar) throws SQLException {
        int idCicloEscolar = -1;
        Connection conexion = conectar.conectar();
        String query = "SELECT id_cicloescolar FROM cicloescolar WHERE cicloescolar = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, cicloEscolar);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    idCicloEscolar = resultSet.getInt("id_cicloescolar");
                }
            }
        }
        return idCicloEscolar;
    }
}
