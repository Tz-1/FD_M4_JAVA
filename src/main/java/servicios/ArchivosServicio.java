package servicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import modelos.Alumno;
import modelos.Materia;

public class ArchivosServicio {
    private PromedioServicioImp promedioServicio = new PromedioServicioImp();

    public void exportarDatos(Map<String, Alumno> alumnos, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Alumno alumno : alumnos.values()) {
                writer.write("Alumno: " + alumno.getRut() + " - " + alumno.getNombre());
                writer.newLine();
                for (Materia materia : alumno.getMaterias()) {
                    double promedio = promedioServicio.calcularPromedio(materia.getNotas());
                    writer.write("Materia: " + materia.getNombre() + " - Promedio: " + String.format("%.2f", promedio));
                    writer.newLine();
                }
                writer.write("------------------------------------------------");
                writer.newLine();
                System.out.println("Datos exportados correctamente.");
            }
        } catch (IOException e) {
            System.err.println("Error al exportar datos: " + e.getMessage());
        }
    }
}
