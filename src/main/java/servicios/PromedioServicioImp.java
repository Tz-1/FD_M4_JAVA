/**
 * Servicio para calcular el promedio de los estudiantes.
 */
package servicios;

import java.util.List;

public class PromedioServicioImp {
	 /**
     * Calcula el promedio de una lista de notas que fue ingresada a traves del usuario.
     * 
     * @param valores Lista de notas (Double) para calcular el promedio.
     * @return El promedio de las notas o 0 si la lista esta vacia o es nula.
     */
	public Double calcularPromedio(List<Double> valores) {
        if (valores == null || valores.isEmpty()) {
            System.out.println("El alumno no posee notas añadidas.");
        }

        double suma = 0.0;
        for (Double valor : valores) {
            suma += valor;
        }
        
        return suma / valores.size();
    }
}
