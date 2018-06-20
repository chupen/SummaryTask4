package ua.nure.teteruk.dao.mapper;

import ua.nure.teteruk.constant.FieldsConstants;
import ua.nure.teteruk.entity.TakenTests;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TakenTestMapper {

    public TakenTests map(ResultSet resultSet) throws SQLException {
        return new TakenTests()
                .setId(resultSet.getInt(FieldsConstants.TAKEN_TESTS_ID))
                .setMark(resultSet.getInt(FieldsConstants.TAKEN_TESTS_MARK))
                .setPassed(resultSet.getInt(FieldsConstants.TAKEN_TESTS_PASSED))
                .setDateOfTaking(resultSet.getString(FieldsConstants.TAKEN_TESTS_DATE_OF_TAKING))
                .setUserId(resultSet.getInt(FieldsConstants.TAKEN_TESTS_USER_ID))
                .setTestsInfoId(resultSet.getInt(FieldsConstants.TAKEN_TESTS_TESTS_INFO_ID));
    }

    public int unMap(PreparedStatement statement, TakenTests entity) throws SQLException {
        int k = 1;
        statement.setInt(k++, entity.getMark());
        statement.setInt(k++, entity.getPassed());
        statement.setString(k++, entity.getDateOfTaking());
        statement.setInt(k++, entity.getUserId());
        statement.setInt(k++, entity.getTestsInfoId());
        return k;
    }
}
