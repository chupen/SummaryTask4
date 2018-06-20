package ua.nure.teteruk.dao.mapper;

import ua.nure.teteruk.constant.FieldsConstants;
import ua.nure.teteruk.entity.CompleteTests;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompleteTestMapper {
    
    public CompleteTests map (ResultSet resultSet) throws SQLException {
        return new CompleteTests()
                .setAnswerId(resultSet.getInt(FieldsConstants.COMPLETE_TESTS_ANSWER_ID))
                .setTestQuestionId(resultSet.getInt(FieldsConstants.COMPLETE_TESTS_TEST_QUESTION_ID))
                .setTestInfoId(resultSet.getInt(FieldsConstants.COMPLETE_TESTS_TEST_INFO_ID))
                .setAnswerText(resultSet.getString(FieldsConstants.COMPLETE_TESTS_ANSWER_TEXT))
                .setCorrect(resultSet.getInt(FieldsConstants.COMPLETE_TESTS_CORRECT));
    }
    
    public int unMap (PreparedStatement statement, CompleteTests entity) throws SQLException {
        int k = 1;
        //statement.setInt(k++, entity.getAnswerId());
        statement.setInt(k++, entity.getTestQuestionId());
        statement.setInt(k++, entity.getTestInfoId());
        statement.setString(k++, entity.getAnswerText());
        statement.setInt(k++, entity.getCorrect());
        return k;
    }
}
