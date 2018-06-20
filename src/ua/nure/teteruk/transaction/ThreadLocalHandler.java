package ua.nure.teteruk.transaction;

import java.sql.Connection;

public class ThreadLocalHandler {
    public static final ThreadLocal<Connection> poolConnection = new ThreadLocal<>();

    public static void setConnection(Connection connection) {
        poolConnection.set(connection);
    }

    public static Connection getConnection() {
        return poolConnection.get();
    }
}
