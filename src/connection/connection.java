package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Patrón Singleton
public class connection {
        private static String usuario = "campus2023";
        private static String contrasena = "campus2023";
        private static Connection connection;
        private static final String db = "banco_union";

        public static Connection getConnection() {
            try {
                if (connection == null || connection.isClosed()) {
                    String url = "jdbc:mysql://localhost:3306/"+ db;
                    connection = DriverManager.getConnection(url, usuario, contrasena);
                    System.out.println("Conectado ;)");
                } else {
                    return connection;
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error "+ e.getMessage());
            }
            return connection;}



}
