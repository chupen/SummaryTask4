package ua.nure.teteruk.dao.mapper;

import ua.nure.teteruk.constant.FieldsConstants;
import ua.nure.teteruk.entity.Group;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupMapper implements EntityMapper<Group> {
    @Override
    public Group map(ResultSet resultSet) throws SQLException {
        return new Group()
                .setId(resultSet.getInt(FieldsConstants.GROUPS_ID))
                .setName(resultSet.getString(FieldsConstants.GROUPS_NAME))
                .setFacultyId(resultSet.getInt(FieldsConstants.GROUPS_FACULTIES_ID));
    }

    @Override
    public int unMap(PreparedStatement preparedStatement, Group entity) throws SQLException {
        int k = 1;
        preparedStatement.setString(k++, entity.getName());
        preparedStatement.setInt(k++, entity.getFacultyId());
        return k;
    }
}
