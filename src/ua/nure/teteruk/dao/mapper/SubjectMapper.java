package ua.nure.teteruk.dao.mapper;

import ua.nure.teteruk.constant.FieldsConstants;
import ua.nure.teteruk.entity.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectMapper {

    public Subject map (ResultSet resultSet) throws SQLException {
        return new Subject()
                .setId(resultSet.getInt(FieldsConstants.SUBJECTS_ID))
                .setName(resultSet.getString(FieldsConstants.SUBJECTS_NAME));
    }

    public int unMap (PreparedStatement statement, Subject entity) throws SQLException {
        int k = 1;
        statement.setString(k++, entity.getName());
        return k;
    }
}
