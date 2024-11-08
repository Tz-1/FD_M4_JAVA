/**
 * @author Tz Tomas
 * @version 2.4
 * Plantilla del menu, en donde la iniciacion de este es la unica que esta completada
 */

package vistas;

import java.util.Scanner;

public class MenuTemplate {
	
	public void crearAlumno() {
	}
	
	public void listarAlumnos() {
	}
	
	public void agregarMateria() {
	}
	
	public void agregarNota() {
	}
	
	public void terminarPrograma(){
		System.out.println("\nBye bye!");
		sc.close();
	}
	
	public void exportarDatos() {	
	}
	
	public Scanner sc = new Scanner(System.in);
	
	public void iniciarMenu() {
		while(true) {
			System.out.println("1. Crear Alumnos");
			System.out.println("2. Listar Alumnos");
			System.out.println("3. Agregar Materias");
			System.out.println("4. Agregar Notas");
			System.out.println("5. Salir");
			System.out.println("6. Exportar datos");
			System.out.print("Seleccion: ");
			int opt = sc.nextInt();
			sc.nextLine();
			switch(opt) {
			case 1 -> crearAlumno();
			case 2 -> listarAlumnos();
			case 3 -> agregarMateria();
			case 4 -> agregarNota();
			case 5 -> {terminarPrograma(); return;}
			case 6 -> exportarDatos();
			default -> System.out.println("Ingrese una opcion valida.");
			}
		}
	}
}
