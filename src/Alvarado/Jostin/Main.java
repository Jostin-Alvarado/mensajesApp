package Alvarado.Jostin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {

        boolean salir;

        do {

            System.out.println("----------------------------------------------");
            System.out.println("Bienvenido.");
            System.out.println("1. Crear un mensaje.");
            System.out.println("2. Listar mensaje.");
            System.out.println("3. Editar mensaje.");
            System.out.println("4. Borrar mensaje.");
            System.out.println("5. Salir");
            String opcion = leer.readLine();
            salir = opcionMenu(opcion);
        } while (!salir);
    }

    public static boolean opcionMenu(String opcion) throws IOException {

        boolean salir = false;

        switch (opcion) {

            case "1" -> registrarMensaje();
            case "2" -> listarMensaje();
            case "3" -> editarMensaje();
            case "4" -> borrarMensaje();
            case "5" -> salir = true;
            default -> System.out.println("----------------------------------------------\n" +
                    "Lo sentimos, esa no es una opción válida.");
        }
        return salir;
    }

    public static void registrarMensaje() throws IOException {
        MensajeServicio.registroMensaje();
    }

    public static void listarMensaje() {
        MensajeServicio.listarMensaje();
    }

    public static void editarMensaje() {
        MensajeServicio.actualizarMensaje();
    }

    public static void borrarMensaje() throws IOException {
        MensajeServicio.eliminarMensaje();
    }

}