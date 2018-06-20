package ua.nure.teteruk.dao.mapper;

import ua.nure.teteruk.constant.FieldsConstants;
import ua.nure.teteruk.entity.Faculty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyMapper implements EntityMapper<Faculty> {
    @Override
    public Faculty map(ResultSet resultSet) throws SQLException {
        return new Faculty()
                .setId(resultSet.getInt(FieldsConstants.FACULTIES_ID))
                .setName(resultSet.getString(FieldsConstants.FACULTIES_NAME))
                .setUniversitiesId(resultSet.getInt(FieldsConstants.FACULTIES_UNIVERSITIES_ID));
    }

    @Override
    public int unMap(PreparedStatement preparedStatement, Faculty entity) throws SQLException {
        int k = 1;
        preparedStatement.setString(k++, entity.getName());
        preparedStatement.setInt(k++, entity.getUniversitiesId());
        return k;
    }
}
