package Alvarado.Jostin;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Conector conector = new Conector();

        try ( Connection cnx = conector.getConnection();) {

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
