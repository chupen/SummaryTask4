package ua.nure.teteruk.dao.mysql;

import ua.nure.teteruk.constant.QueriesConstants;
import ua.nure.teteruk.dao.UserDAO;
import ua.nure.teteruk.dao.mapper.UserMapper;
import ua.nure.teteruk.entity.User;
import ua.nure.teteruk.exception.DBException;
import ua.nure.teteruk.transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User create(User entity) {
        UserMapper mapper = new UserMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(QueriesConstants.USERS_CREATE, Statement.RETURN_GENERATED_KEYS)) {
            mapper.unMap(preparedStatement, entity);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                entity.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return entity;
    }

    @Override
    public User get(int id) {
        UserMapper mapper = new UserMapper();
        User user = null;
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueriesConstants.USERS_GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = mapper.map(resultSet);
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return user;
    }

    public User getByName(String login) {
        UserMapper mapper = new UserMapper();
        User user = null;
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueriesConstants.USERS_GET)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = mapper.map(resultSet);
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return user;
    }

    @Override
    public boolean isExist(String login) {
        boolean result;
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.USERS_GET)){
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.next();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return result;
    }

    @Override
    public User getByLoginAndPassword(String login, String password) {
        UserMapper mapper = new UserMapper();
        User user = null;
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.USERS_GET_BY_LOGIN_AND_PASSWORD)){
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = mapper.map(resultSet);
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return user;
    }

   /* 
   
   get users by groups
   
   @Override
    public List<User> getByGroup(String groupName) {
        List<User> users = new ArrayList<>();
        UserMapper mapper = new UserMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(QueriesConstants.USERS_GET_BY_GROUP)){
            preparedStatement.setString(1, groupName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                users.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return users;
    }*/

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        UserMapper mapper = new UserMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(QueriesConstants.USERS_GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(mapper.map(resultSet));
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return users;
    }

    @Override
    public void update(User entity) {
        UserMapper mapper = new UserMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(QueriesConstants.USERS_UPDATE)) {
            int k = mapper.unMap(preparedStatement, entity);
            preparedStatement.setString(++k, entity.getLogin());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    @Override
    public boolean block(String login) {
        UserMapper mapper = new UserMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.USERS_CHANGE_STATUS)){
            statement.setInt(1, 1);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }

    @Override
    public boolean unblock(String login) {
        UserMapper mapper = new UserMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.USERS_CHANGE_STATUS)){
            statement.setInt(1, 0);
            statement.setString(2, login);
            statement.executeUpdate();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }

    @Override
    public boolean updateUser(User entity, String oldLogin) {
        UserMapper mapper = new UserMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(QueriesConstants.USERS_UPDATE_FULL)) {
            int k = mapper.unMap(preparedStatement, entity);
            preparedStatement.setString(k, oldLogin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return true;
    }

    @Override
    public boolean delete(User entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(QueriesConstants.USERS_DELETE)) {
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return true;
    }

    @Override
    public User getByLoginOrEmail(String loginOrEmail) {
        User user = new User();
        UserMapper mapper = new UserMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(QueriesConstants.USERS_FIND_BY_LOGIN_OR_EMAIL)) {
            preparedStatement.setString(1, loginOrEmail);
            preparedStatement.setString(2, loginOrEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = mapper.map(resultSet);
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return user;
    }
}
