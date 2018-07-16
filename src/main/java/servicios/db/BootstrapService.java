package servicios.db;

import org.h2.tools.Server;

import java.sql.SQLException;

public class BootstrapService {

    public static void startDb() throws SQLException {
        Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
    }

    public static void stopDb() throws SQLException {
        Server.shutdownTcpServer("jdbc:h2:tcp://localhost/~/parcial2", "", true, true);
    }
}
