/**
 * CRUD que se implementa a traves de la interface de IAlumno.
 *@param currentMat es la materia que se esta añadiendo
 */
package servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.IAlumno;
import modelos.Alumno;
import modelos.Materia;

public class AlumnoServicio implements IAlumno{
	private Map<String, Alumno> alumnos = new HashMap<>();

	@Override
	public void crearAlumno(Alumno alumno) {
		if(alumnos.containsKey(alumno.getRut())) {
			System.out.println("El Alumno ya se encuentra registrado");
		}else {
			alumnos.put(alumno.getRut(), alumno);
			System.out.println("--- ¡Alumno agregado! ---");  
		}
		
	}

	@Override
	public void agregarMateria(String rutAlumno, Materia currentMat) {
		Alumno alumno = alumnos.get(rutAlumno);
	    if (alumno != null) {
	        alumno.getMaterias().add(currentMat);
	        System.out.println("--- ¡Materia agregada! ---");
	    } else {
	        System.out.println("Alumno no encontrado");
	    }
		
	}

	@Override
	public List<Materia> materiasPorAlumno(String rutAlumno) {
		Alumno alumno = alumnos.get(rutAlumno);
        if (alumno != null) {
            return alumno.getMaterias();
        }
        System.out.println("Alumno no encontrado");
        return new ArrayList<>();
    }
	

	@Override
	public Map<String, Alumno> listarAlumnos() {
	    if (alumnos == null || alumnos.isEmpty()) { 
	        System.out.println("No se encuentra ningun alumno registrado.\n");
	        return Collections.emptyMap();
	    }
	    return alumnos;
	}

	/**
	 * Metodo extra añadido para poder añadir notas a traves de las materias. Funciona por notas del sistema de educacion chileno.
	 */
	@Override
	public void agregarNota(String rutAlumno, Materia currentMat, double nota) {
	    if (nota < 1 || nota > 7) {
	        System.out.println("La nota igual o mayor a 1 y menor o igual a 7.");
	        return; 
	    }
	    Alumno alumno = alumnos.get(rutAlumno);
	    if (alumno != null) {
	        List<Materia> materias = alumno.getMaterias();
	        for (Materia materia : materias) {
	            if (materia.getNombre().equals(currentMat.getNombre())) {
	                materia.getNotas().add(nota);
	                System.out.println("--- ¡Nota agregada! ---");
	                return;
	            }
	        }
	    } else {
	        System.out.println("Alumno no encontrado");
	    }
	}
}
