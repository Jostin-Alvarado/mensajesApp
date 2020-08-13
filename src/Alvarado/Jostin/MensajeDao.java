package Alvarado.Jostin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MensajeDao {

    public static void registroMensaje(Mensaje msg) {

        Connection dbConnect = null;

        try(Connection connection = dbConnect){
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO mensajes (mensaje, autorMensaje) VALUES (?,?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, msg.getMensaje());
                ps.setString(2, msg.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Exito al crear el mensaje");
            }catch (SQLException x){
                System.out.println("No se pudo crear");
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void listarMensaje() {

    }

    public static void eliminarMensaje(int idMensaje) {

    }

    public static void actualizarMensaje(Mensaje msg) {

    }

}
