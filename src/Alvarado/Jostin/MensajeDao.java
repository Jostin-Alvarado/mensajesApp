package Alvarado.Jostin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDao {

    public static void registroMensaje(Mensaje msg) {

        Conector dbConn = new Conector();

        try (Connection connection = dbConn.getConnection()) {
            PreparedStatement ps;
            try {

                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, msg.getMensaje());
                ps.setString(2, msg.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Exito al crear el mensaje");
            } catch (SQLException x) {
                System.out.println("No se pudo crear" + x);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void listarMensaje() {

        Conector dbConn = new Conector();
        PreparedStatement ps;
        ResultSet rs;

        try (Connection connection = dbConn.getConnection()) {

            String query = "SELECT * FROM mensajes";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

                while (rs.next()) {

                    System.out.println("ID: " + rs.getInt("id_mensaje"));
                    System.out.println("Mensaje: " + rs.getString("mensaje"));
                    System.out.println("Autor del mensaje: " + rs.getString("autor_mensaje"));
                    System.out.println("Fecha del mensaje: " + rs.getString("fecha_mensaje"));
                }
                System.out.println("Exito al crear el mensaje");
            } catch (SQLException x) {
                System.out.println("No se pudo traer los mensajes" + x);
            }
        }

    public static void eliminarMensaje(int idMensaje) {

    }

    public static void actualizarMensaje(Mensaje msg) {

    }

}
