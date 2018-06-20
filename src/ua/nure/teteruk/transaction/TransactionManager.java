package ua.nure.teteruk.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

import ua.nure.teteruk.exception.ApplicationException;

public class TransactionManager {
    private DataSource dataSource;

    public TransactionManager(DataSource ds){
        dataSource = ds;
    }

    public <T> T execute(Transaction<T> transaction) {
        Connection connection = null;
        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            ThreadLocalHandler.setConnection(connection);
            T returnedValue = transaction.execute();
            connection.commit();
            return returnedValue;
        } catch (SQLException e){
            tryToRollBack(connection);
            throw new ApplicationException(e);
        } finally {
            ThreadLocalHandler.setConnection(null);
            tryToClose(connection);
        }
    }

    private void tryToClose(Connection connection) {
        if(!Objects.equals(connection, null)){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new ApplicationException(e);
            }
        }
    }

    private void tryToRollBack(Connection connection) {
        if(!Objects.equals(connection, null)){
            try {
                connection.rollback();
            } catch (SQLException e) {
                throw new ApplicationException(e);
            }
        }
    }
}
