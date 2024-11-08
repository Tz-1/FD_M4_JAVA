package servicios;

import java.util.List;

public class PromedioServicioImp {
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
