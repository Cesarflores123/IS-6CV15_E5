package damain;

import coneccion.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExportarExcel {

    Conexion conectar = Conexion.getInstance();

    public static void exportarHojaAsistencia(Conexion conectar, String grupo, String nombreArchivo) throws SQLException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Hoja de Asistencia");
            Connection conexion = conectar.conectar();
            int idGrupo = ObtenerID.obtenerIDG(conectar, grupo);

            String nombreGrupo = obtenerNombreGrupo(conectar, idGrupo);
            String nombreDocente = obtenerNombreDocente(conectar, idGrupo);
            String nombreLaboratorio = obtenerNombreLaboratorio(conectar, idGrupo);
            String nombreCicloEscolar = obtenerCicloEscolar(conectar, idGrupo);
            List<AlumnoAsistencia> alumnos = obtenerDatosAlumnosAsistencia(conectar, idGrupo);
            Set<String> fechasUnicas = obtenerFechasUnicas(alumnos);
            // Encabezados
            Row row1 = sheet.createRow(0);
            row1.createCell(0).setCellValue("Nombre del Grupo");
            row1.createCell(1).setCellValue("Nombre completo del Docente");
            row1.createCell(2).setCellValue("Nombre del Laboratorio");
            row1.createCell(3).setCellValue("Ciclo Escolar");

            // Datos
            Row row2 = sheet.createRow(1);
            row2.createCell(0).setCellValue(nombreGrupo);
            row2.createCell(1).setCellValue(nombreDocente);
            row2.createCell(2).setCellValue(nombreLaboratorio);
            row2.createCell(3).setCellValue(nombreCicloEscolar);

            // Filas 5 y 6 en blanco
            sheet.createRow(4);
            sheet.createRow(5);

            // Nombres de columnas
            llenarEncabezadosFechas(sheet, alumnos);

            // Llenar filas con datos de alumnos y asistencias
            llenarDatosAlumnosAsistencias(sheet, alumnos, fechasUnicas);

            // Crear un estilo de celda para centrar el contenido
            CellStyle estiloCentrado = workbook.createCellStyle();
            estiloCentrado.setAlignment(HorizontalAlignment.CENTER);
            estiloCentrado.setVerticalAlignment(VerticalAlignment.CENTER);

            // Observaciones
            Row row38 = sheet.getRow(37); // Obtener la fila existente si ya fue creada
            if (row38 == null) {
                row38 = sheet.createRow(37); // Crear la fila solo si no existe
            }
            Cell observacionesCell = row38.createCell(0);
            observacionesCell.setCellValue("Observaciones");

// Obtener observaciones
            List<String> observaciones = obtenerObservaciones(conectar, idGrupo);

// Crear fila 38 y agrupar las primeras 8 columnas
            Row row39 = sheet.getRow(38);
            if (row39 == null) {
                row39 = sheet.createRow(38);
            }
            for (int i = 0; i < 8; i++) {
                Cell cell = row39.createCell(i);
                cell.setCellValue("");  // Puedes ajustar este valor según tus necesidades
            }

// Agrupar las primeras 8 columnas
            sheet.groupColumn(0, 7);

// Combinar celdas para las observaciones
            CellRangeAddress observacionesRange = new CellRangeAddress(38, 48, 0, 7);
            sheet.addMergedRegion(observacionesRange);

// Llenar la fila 38 con observaciones obtenidas de la base de datos
            Row rowObservacion = sheet.getRow(38);
            if (rowObservacion == null) {
                rowObservacion = sheet.createRow(38);
            }
            Cell cell = rowObservacion.createCell(0);

// Concatenar todas las observaciones con saltos de línea
            StringBuilder observacionesText = new StringBuilder();
            for (String observacion : observaciones) {
                observacionesText.append(observacion).append("\n");
            }

            cell.setCellValue(observacionesText.toString().trim());

            CellStyle estiloSuperior = workbook.createCellStyle();
            estiloSuperior.setVerticalAlignment(VerticalAlignment.TOP);
            estiloSuperior.setWrapText(true);
            cell.setCellStyle(estiloSuperior);

            for (int i = 0; i <= 300; i++) { // ajustar las primeras 4 columnas en este caso
                sheet.autoSizeColumn(i);
            }
            // Aplicar el estilo de celda a todas las celdas en la hoja
            for (int i = 0; i <= 36; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    for (int j = 0; j <= 300; j++) {
                        Cell cella = row.getCell(j);
                        if (cella != null) {
                            cella.setCellStyle(estiloCentrado);
                        }
                    }
                }
            }
            // Obtener la carpeta "Descargas" del usuario
            String carpetaDescargas = System.getProperty("user.home") + File.separator + "Downloads";

            // Asegurar que el nombre del archivo tenga la extensión ".xlsx"
            if (!nombreArchivo.toLowerCase().endsWith(".xlsx")) {
                nombreArchivo += ".xlsx";
            }

            // Crear la ruta completa para el archivo en la carpeta "Descargas"
            String rutaCompleta = carpetaDescargas + File.separator + nombreArchivo;

            // Guardar en archivo
            try (FileOutputStream fileOut = new FileOutputStream(rutaCompleta)) {
                workbook.write(fileOut);
                System.out.println("Exportación exitosa a Excel. Ruta del archivo: " + rutaCompleta);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String obtenerNombreGrupo(Conexion conectar, int idGrupo) {
        String nombreGrupo = "";
        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT grupo FROM Grupo WHERE id_grupo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idGrupo);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    nombreGrupo = resultSet.getString("grupo");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreGrupo;
    }

    public static String obtenerNombreDocente(Conexion conectar, int idGrupo) {
        String nombreDocente = "";
        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT D.nombre, D.apellido_pat, D.apellido_mat "
                    + "FROM Docente D "
                    + "JOIN Grupo G ON D.id_docente = G.id_docente "
                    + "WHERE G.id_grupo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idGrupo);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String apellidoPat = resultSet.getString("apellido_pat");
                    String apellidoMat = resultSet.getString("apellido_mat");
                    nombreDocente = nombre + " " + apellidoPat + " " + apellidoMat;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreDocente;
    }

    public static String obtenerNombreLaboratorio(Conexion conectar, int idGrupo) {
        String nombreLaboratorio = "";
        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT laboratorio FROM Laboratorio WHERE id_laboratorio = "
                    + "(SELECT id_laboratorio FROM InfoGrupo WHERE id_grupo = ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idGrupo);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    nombreLaboratorio = resultSet.getString("laboratorio");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreLaboratorio;
    }

    public static String obtenerCicloEscolar(Conexion conectar, int idGrupo) {
        String cicloEscolar = "";
        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT cicloEscolar FROM CicloEscolar WHERE id_cicloEscolar = "
                    + "(SELECT id_cicloEscolar FROM InfoGrupo WHERE id_grupo = ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idGrupo);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    cicloEscolar = resultSet.getString("cicloEscolar");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cicloEscolar;
    }

    public static String obtenerAsignatura(Conexion conectar, int idGrupo) {
        String nombreAsignatura = "";
        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT Asignatura.asignatura FROM Asignatura "
                    + "JOIN InfoGrupo ON Asignatura.id_asignatura = InfoGrupo.id_asignatura "
                    + "WHERE InfoGrupo.id_grupo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idGrupo);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    nombreAsignatura = resultSet.getString("asignatura");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreAsignatura;
    }

    public static void llenarEncabezadosFechas(Sheet sheet, List<AlumnoAsistencia> alumnos) {
        // Crear fila para encabezados
        Row row7 = sheet.createRow(6);
        row7.createCell(0).setCellValue("Nombres");
        row7.createCell(1).setCellValue("Boleta");

        // Obtener fechas únicas de asistencia
        Set<String> fechasUnicas = new HashSet<>();
        for (AlumnoAsistencia alumno : alumnos) {
            for (Map.Entry<String, String> entry : alumno.getAsistencias().entrySet()) {
                fechasUnicas.add(entry.getKey());
            }
        }

        // Llenar encabezados de fechas
        int columnaActual = 2; // Empezar desde la tercera columna (0-indexed)
        for (String fechaUnica : fechasUnicas) {
            row7.createCell(columnaActual++).setCellValue("Fecha " + fechaUnica);
            row7.createCell(columnaActual++).setCellValue("Marca " + fechaUnica);
        }
    }

    public static void llenarDatosAlumnosAsistencias(Sheet sheet, List<AlumnoAsistencia> alumnos, Set<String> fechasUnicas) {
        // Llenar filas con datos de alumnos y asistencias
        int currentRow = 7;

        for (AlumnoAsistencia alumno : alumnos) {
            Row rowAlumno = sheet.createRow(currentRow);
            rowAlumno.createCell(0).setCellValue(alumno.getNombreCompleto());
            rowAlumno.createCell(1).setCellValue(alumno.getBoleta());

            // Llenar celdas de asistencia para cada fecha
            int columnaActual = 2;

            for (String fechaUnica : fechasUnicas) {
                String marcaAsistencia = alumno.getAsistencias().getOrDefault(fechaUnica, "");
                rowAlumno.createCell(columnaActual++).setCellValue(fechaUnica);
                rowAlumno.createCell(columnaActual++).setCellValue(marcaAsistencia);
            }

            // Incrementar el índice de fila actual
            currentRow++;
        }

        // Agregar alumnos sin asistencia
        for (AlumnoAsistencia alumno : alumnos) {
            if (alumno.getAsistencias().isEmpty()) {
                Row rowAlumno = sheet.createRow(currentRow);
                rowAlumno.createCell(0).setCellValue(alumno.getNombreCompleto());
                rowAlumno.createCell(1).setCellValue(alumno.getBoleta());
                currentRow++;
            }
        }
    }

    private static Set<String> obtenerFechasUnicas(List<AlumnoAsistencia> alumnos) {
        Set<String> fechasUnicas = new HashSet<>();
        for (AlumnoAsistencia alumno : alumnos) {
            for (Map.Entry<String, String> entry : alumno.getAsistencias().entrySet()) {
                fechasUnicas.add(entry.getKey());
            }
        }
        return fechasUnicas;
    }

    public static List<AlumnoAsistencia> obtenerDatosAlumnosAsistencia(Conexion conectar, int idGrupo) {
        List<AlumnoAsistencia> alumnos = new ArrayList<>();

        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT A.id_alumno, A.nombre_completo, A.boleta, Asistencia.fecha, Asistencia.asistencia\n"
                    + "FROM Alumno A\n"
                    + "JOIN InfoAlumno IA ON A.id_alumno = IA.id_alumno\n"
                    + "JOIN Asistencia Asistencia ON IA.id_infoAlumno = Asistencia.id_infoAlumno\n"
                    + "WHERE IA.id_grupo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idGrupo);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int idAlumno = resultSet.getInt("id_alumno");
                    String nombreCompleto = resultSet.getString("nombre_completo");
                    String boleta = resultSet.getString("boleta");

                    AlumnoAsistencia alumno = obtenerAlumnoPorId(alumnos, idAlumno);
                    if (alumno == null) {
                        alumno = new AlumnoAsistencia(idAlumno, nombreCompleto, boleta);
                        alumnos.add(alumno);
                    }

                    alumno.addAsistencia(resultSet.getString("fecha"), resultSet.getString("asistencia"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumnos;
    }

    private static AlumnoAsistencia obtenerAlumnoPorId(List<AlumnoAsistencia> alumnos, int idAlumno) {
        for (AlumnoAsistencia alumno : alumnos) {
            if (alumno.getIdAlumno() == idAlumno) {
                return alumno;
            }
        }
        return null;
    }

    public static List<String> obtenerObservaciones(Conexion conectar, int idGrupo) {
        List<String> observacionesList = new ArrayList<>();
        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT observacion FROM Observaciones WHERE id_InfoGrupo IN (SELECT id_InfoGrupo FROM InfoGrupo WHERE id_grupo = ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idGrupo);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String observacion = resultSet.getString("observacion");
                    observacionesList.add(observacion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return observacionesList;
    }
}
