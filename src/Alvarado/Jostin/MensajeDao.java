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

        try {

            Connection connection = dbConn.getConnection();
            String query = "SELECT * FROM mensajes";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor del mensaje: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha del mensaje: " + rs.getString("fecha_mensaje"));
            }
            System.out.println("No hay más mensajes.");
        } catch (SQLException x) {
            System.out.println("No se pudo traer los mensajes" + x);
        }
    }

    public static void eliminarMensaje(int idMensaje) {

        Conector conn = new Conector();

        try {

            Connection connDb = conn.getConnection();
            PreparedStatement ps;

            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = connDb.prepareStatement(query);
                ps.setInt(1, idMensaje);


                int countRowsUpdated = ps.executeUpdate();
                if (countRowsUpdated != 0) {
                    System.out.println(" Fue eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró el mensaje.");
                }
            } catch (SQLException x) {
                System.out.println(x);
                System.out.println("No se pudo eliminar el mensaje.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void actualizarMensaje(Mensaje msg) {

        Conector conn = new Conector();

        try {
            PreparedStatement ps;

            try{

                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conn.getConnection().prepareStatement(query);
                ps.setString(1, msg.getMensaje());
                ps.setInt(2, msg.getIdMensaje());
                ps.executeUpdate();
                System.out.println("Se actualizó correctamente.");

            }catch (SQLException ex){
                System.out.println("No se pudo actualizar." + "Error: " + ex);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
