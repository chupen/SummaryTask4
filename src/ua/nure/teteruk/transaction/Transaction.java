package ua.nure.teteruk.transaction;

import java.sql.SQLException;

@FunctionalInterface
public interface Transaction<T> {
    T execute() throws SQLException;
}
