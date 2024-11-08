package utilidades;

import java.io.IOException;

public class Utilidad {

    public static void esperarEnter() {
        System.out.println("Presiona Enter para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {
            System.err.println("Error al esperar la entrada: " + e.getMessage());
        }
    }
}
