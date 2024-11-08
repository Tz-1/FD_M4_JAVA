package interfaces;

import java.util.List;
import java.util.Map;

import modelos.Alumno;
import modelos.Materia;

public interface IAlumno {
	public void crearAlumno (Alumno alumno);
	public void agregarMateria(String rutAlumno, Materia currentMat);
	public List<Materia> materiasPorAlumno(String rutAlumno);
	public Map<String, Alumno> listarAlumnos();
	public void agregarNota(String rutAlumno, Materia currentMat,double nota);
}
