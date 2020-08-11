package Alvarado.Jostin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

    public Connection getConnection() {

        Connection conection = null;

        try {

            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app?serverTimezone=UTC", "root", "");
            if (conection != null) {
                System.out.println("Excelente, todo va bien.");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return conection;
    }
}
