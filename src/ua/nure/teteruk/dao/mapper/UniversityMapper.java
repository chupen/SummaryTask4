package ua.nure.teteruk.dao.mapper;

import ua.nure.teteruk.constant.FieldsConstants;
import ua.nure.teteruk.entity.University;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UniversityMapper implements EntityMapper<University> {

    @Override
    public University map(ResultSet resultSet) throws SQLException {
        return new University()
                .setId(resultSet.getInt(FieldsConstants.UNIVERSITIES_ID))
                .setName(resultSet.getString(FieldsConstants.UNIVERSITIES_NAME))
                .setSphere(resultSet.getString(FieldsConstants.UNIVERSITIES_SPHERE));
    }

    @Override
    public int unMap(PreparedStatement preparedStatement, University entity) throws SQLException {
        int k = 1;
        preparedStatement.setString(k++, entity.getName());
        preparedStatement.setString(k++, entity.getSphere());
        return k;
    }
}
