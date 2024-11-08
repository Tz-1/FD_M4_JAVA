package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import servicios.PromedioServicioImp;

@DisplayName("Test para la clase PromedioServicioImp")
public class CalcularPromedioImpTest {

	private PromedioServicioImp promedioServicio = new PromedioServicioImp();
	
	@Test
	@DisplayName("Test para calcular el promedio.")
	public void calcularPromedioTest() {
		List<Double> n = Arrays.asList(3.2, 6.5, 4.8, 5.0);
		double promedio = promedioServicio.calcularPromedio(n);
		assertEquals(4.875, promedio);
	}
	
}
