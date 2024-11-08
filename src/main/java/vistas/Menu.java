/**
 * Clase donde el menú sobreescribe los métodos de la clase {@link MenuTemplate}.
 * Aquí es donde se ejecutan todas las acciones del usuario para gestionar alumnos,
 * materias y notas en la aplicación.
 */

package vistas;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivosServicio;
import servicios.PromedioServicioImp;
import utilidades.Utilidad;


public class Menu extends MenuTemplate{
	private AlumnoServicio alumnoServicio = new AlumnoServicio();
	private ArchivosServicio archivoServicio = new ArchivosServicio();
	private PromedioServicioImp promedioServicio = new PromedioServicioImp();
    
	@Override
    public void crearAlumno() {
		System.out.println();
        System.out.println("--- Crear Alumno ---");
        System.out.print("Ingresa RUT: ");
        String rut = sc.nextLine();
        System.out.print("Ingresa nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Ingresa dirección: ");
        String direccion = sc.nextLine();
        Alumno alumno = new Alumno(rut, nombre, apellido, direccion);
        alumnoServicio.crearAlumno(alumno);
        System.out.println();
        Utilidad.esperarEnter();
    }
	
	@Override
    public void agregarMateria() {
		System.out.println();
        System.out.println("--- Agregar Materia ---");
        System.out.print("Ingresa RUT del Alumno: ");
        String rut = sc.nextLine();
        
        System.out.println("Seleccione la materia:");
        for (MateriaEnum materiaEnum : MateriaEnum.values()) {
            System.out.println((materiaEnum.ordinal() + 1) + ". " + materiaEnum);
        }
        
        int opt = sc.nextInt();
        MateriaEnum materiaSeleccionada = MateriaEnum.values()[opt - 1];
        Materia materia = new Materia(materiaSeleccionada);

        alumnoServicio.agregarMateria(rut, materia);
        System.out.println();
        Utilidad.esperarEnter();
    }
	
	@Override
	public void listarAlumnos() {
		System.out.println();
        System.out.println("--- Listar Alumnos ---");
        var alumnos = alumnoServicio.listarAlumnos();

        alumnos.forEach((rut, alumno) -> {
            System.out.println("Datos Alumno");
            System.out.println("RUT: " + alumno.getRut());
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Dirección: " + alumno.getDireccion());
            System.out.println("Materias:");
            alumno.getMaterias().forEach(materia -> {
                System.out.println(materia.getNombre());
                System.out.println("Notas: " + materia.getNotas());
                Double promedio = promedioServicio.calcularPromedio(materia.getNotas());
                System.out.println("Promedio: "+ String.format("%.2f", promedio));
            });
            System.out.println();
            Utilidad.esperarEnter();
        });
    }
	
	@Override
    public void agregarNota() {
		System.out.println();
        System.out.println("--- Agregar Nota ---");
        System.out.print("Ingresa RUT del Alumno: ");
        String rut = sc.nextLine();

        var materias = alumnoServicio.materiasPorAlumno(rut);
        if (materias.isEmpty()) {
            System.out.println("El alumno no tiene materias asignadas.");
            Utilidad.esperarEnter();
            return;
        }

        System.out.println("Alumno tiene las siguientes materias:");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println((i + 1) + ". " + materias.get(i).getNombre());
        }

        int materiaIndex = sc.nextInt() - 1;
        System.out.print("Ingresa la nota: ");
        double nota = sc.nextDouble();
        
        alumnoServicio.agregarNota(rut, materias.get(materiaIndex), nota);
        System.out.println();
        Utilidad.esperarEnter();
    }
	   
	
	@Override
    public void exportarDatos() {
		System.out.println();
        System.out.println("--- Exportar Datos ---");
        System.out.println("Ingresa la ruta de exportación: ");
        String ruta = sc.nextLine();
        
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), ruta);
        System.out.println();
        Utilidad.esperarEnter();
    }
}
