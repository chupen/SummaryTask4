package ua.nure.teteruk.dao.mapper;

import ua.nure.teteruk.constant.FieldsConstants;
import ua.nure.teteruk.entity.TestQuestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestQuestionMapper {

    public TestQuestion map(ResultSet resultSet) throws SQLException {
        return new TestQuestion()
                .setId(resultSet.getInt(FieldsConstants.TEST_QUESTION_ID))
                .setTestInfoId(resultSet.getInt(FieldsConstants.TEST_QUESTION_TEST_INFO_ID))
                .setQuestionText(resultSet.getString(FieldsConstants.TEST_QUESTION_QUESTION_TEXT));
    }

    public int unMap (PreparedStatement statement, TestQuestion entity) throws SQLException {
        int k = 1;
        statement.setInt(k++, entity.getTestInfoId());
        statement.setString(k++, entity.getQuestionText());
        return k;
    }
}
