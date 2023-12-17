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

    public static int obtenerIDG(Conexion conectar, String grupo) throws SQLException {
        int idGrupo = -1;
        Connection conexion = conectar.conectar();
        String query = "SELECT id_grupo FROM grupo WHERE grupo = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, grupo);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    idGrupo = resultSet.getInt("id_grupo");
                }
            }
        }
        return idGrupo;
    }

    public static int obtenerIDD(Conexion conectar, int idGrupo) {
        int idDocente = -1; // Valor predeterminado si no se encuentra ningún resultado
        Connection conexion = conectar.conectar();
        try {
            String query = "SELECT id_docente FROM Grupo WHERE id_grupo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idGrupo);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    idDocente = resultSet.getInt("id_docente");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja las excepciones según tu lógica
        }

        return idDocente;
    }
    
    public static int obtenerIDIG(Conexion conectar, int idGrupo) {
        int idInfoGrupo = -1; // Valor predeterminado si no se encuentra ningún resultado
        Connection conexion = conectar.conectar();
        try {
            String query = "SELECT id_infogrupo FROM infogrupo WHERE id_grupo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idGrupo);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    idInfoGrupo = resultSet.getInt("id_infogrupo");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja las excepciones según tu lógica
        }

        return idInfoGrupo;
    }
}
