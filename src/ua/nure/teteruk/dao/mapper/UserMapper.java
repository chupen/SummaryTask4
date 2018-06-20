package ua.nure.teteruk.dao.mapper;

import ua.nure.teteruk.constant.FieldsConstants;
import ua.nure.teteruk.entity.User;
import ua.nure.teteruk.entity.UserRole;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements EntityMapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        return new User().setId(resultSet.getInt(FieldsConstants.USERS_ID))
                .setLogin(resultSet.getString(FieldsConstants.USERS_LOGIN))
                .setPassword(resultSet.getString(FieldsConstants.USERS_PASSWORD))
                .setEmail(resultSet.getString(FieldsConstants.USERS_EMAIL))
                .setRole(UserRole.valueOf(resultSet.getString(FieldsConstants.USERS_ROLE)))
                .setName(resultSet.getString(FieldsConstants.USERS_NAME))
                .setSurname(resultSet.getString(FieldsConstants.USERS_SURNAME))
                .setBlocked(resultSet.getInt(FieldsConstants.USERS_BLOCKED))
                .setGroupId(resultSet.getInt(FieldsConstants.USERS_GROUP_ID));
    }

    @Override
    public int unMap(PreparedStatement preparedStatement, User entity) throws SQLException {
        int k = 1;
        preparedStatement.setString(k++, entity.getLogin());
        preparedStatement.setString(k++, entity.getPassword());
        preparedStatement.setString(k++, entity.getEmail());
        preparedStatement.setString(k++, String.valueOf(entity.getRole()));
        preparedStatement.setString(k++, entity.getName());
        preparedStatement.setString(k++, entity.getSurname());
        preparedStatement.setInt(k++, entity.getBlocked());
        preparedStatement.setInt(k++, entity.getGroupId());
        return k;
    }
}
