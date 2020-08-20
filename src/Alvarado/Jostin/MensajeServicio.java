package Alvarado.Jostin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MensajeServicio {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

    public static void registroMensaje() throws IOException {

        System.out.println("Escribe tu mensaje");
        String mensaje = leer.readLine();

        System.out.println("Digite su nombre");
        String nombreAutor = leer.readLine();

        Mensaje msg = new Mensaje();

        msg.setMensaje(mensaje);
        msg.setAutorMensaje(nombreAutor);

        MensajeDao.registroMensaje(msg);
    }

    public static void listarMensaje() {

        MensajeDao.listarMensaje();
    }

    public static void eliminarMensaje() throws IOException {

        System.out.println("Digite el id del mensaje que desea eliminar.");
        int idMensaje = Integer.parseInt(leer.readLine());

        MensajeDao.eliminarMensaje(idMensaje);

    }

    public static void actualizarMensaje() throws IOException {

        System.out.println("Ingrese el nuevo mensaje.");
        String mensaje = leer.readLine();

        System.out.println("Indica el id que tiene tu mensaje viejo.");
        int id = Integer.parseInt(leer.readLine());

        Mensaje actualizar = new Mensaje();
        actualizar.setMensaje(mensaje);

        actualizar.setIdMensaje(id);

        MensajeDao.actualizarMensaje(actualizar);
    }
}
