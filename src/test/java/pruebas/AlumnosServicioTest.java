package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import servicios.AlumnoServicio;

@DisplayName("Test para el crud creado en la clase de AlumnosServicio")
public class AlumnosServicioTest {
	private AlumnoServicio alumnoServicio;
	
	@Mock
	AlumnoServicio alumnoServicioMock;
	Materia matematicas;
	Materia lenguaje;	
	Alumno mapu;
	
	@BeforeEach
	public void setUp() {
		alumnoServicio = new AlumnoServicio();
        MockitoAnnotations.openMocks(this);
        alumnoServicioMock = mock(AlumnoServicio.class);

        matematicas = new Materia(MateriaEnum.MATEMATICAS);
        lenguaje = new Materia(MateriaEnum.LENGUAJE);

        mapu = new Alumno("12345678-9", "Yuuka", "Kazami", "Lost Forest");
	}
	
	
	@Test
	@DisplayName("Test para la creacion de el alumno")
	public void crearAlumnoTest() {
		alumnoServicio.crearAlumno(mapu);
	    Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
	    assertTrue(alumnos.containsKey("12345678-9"));	
	}
	
	@Test
	@DisplayName("Test para añadir materias a los alumnos")
	public void agregarMateriaTest() {
		alumnoServicio.crearAlumno(mapu);
        alumnoServicio.agregarMateria("12345678-9", matematicas);
        
        List<Materia> materias = alumnoServicio.materiasPorAlumno("12345678-9");
        assertEquals(1, materias.size());
        assertEquals(MateriaEnum.MATEMATICAS, materias.get(0).getNombre());
	}
	
	@Test
	@DisplayName("Test para listar las materias que tiene cada alumno")
	public void materiasPorAlumnosTest() {
		when(alumnoServicioMock.materiasPorAlumno("12345678-9")).thenReturn(Arrays.asList(matematicas, lenguaje));

        List<Materia> materias = alumnoServicioMock.materiasPorAlumno("12345678-9");
        assertEquals(2, materias.size());
        assertEquals(MateriaEnum.MATEMATICAS, materias.get(0).getNombre());
        assertEquals(MateriaEnum.LENGUAJE, materias.get(1).getNombre());
	}
	
	@Test
	@DisplayName("Test para listar los alumnos junto con su rut")
	public void listarAlumnosTest() {
		alumnoServicio.crearAlumno(mapu);

        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        assertEquals(1, alumnos.size());
        assertTrue(alumnos.containsKey("12345678-9"));	
	}
}
