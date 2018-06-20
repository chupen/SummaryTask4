package ua.nure.teteruk.dao.mapper;

import ua.nure.teteruk.constant.FieldsConstants;
import ua.nure.teteruk.entity.Complexity;
import ua.nure.teteruk.entity.Subject;
import ua.nure.teteruk.entity.TestInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestInfoMapper {

    public TestInfo map(ResultSet resultSet) throws SQLException {
        return new TestInfo()
                .setId(resultSet.getInt(FieldsConstants.TESTS_INFO_ID))
                .setName(resultSet.getString(FieldsConstants.TESTS_INFO_NAME))
                .setComplexity(Complexity.valueOf(resultSet.getString(FieldsConstants.TESTS_INFO_COMPLEXITY)))
                .setTime(resultSet.getInt(FieldsConstants.TESTS_INFO_TIME))
                .setPassMark(resultSet.getInt(FieldsConstants.TESTS_INFO_PASS_MARK))
                .setSubjectId(resultSet.getInt(FieldsConstants.TESTS_INFO_SUBJECT_ID))
                .setAuthorId(resultSet.getInt(FieldsConstants.TESTS_INFO_AUTHOR_ID));
    }

    public int unMap(PreparedStatement statement, TestInfo entity) throws SQLException {
        int k = 1;
        statement.setString(k++, entity.getName());
        statement.setString(k++, String.valueOf(entity.getComplexity()));
        statement.setInt(k++, entity.getTime());
        statement.setInt(k++, entity.getPassMark());
        statement.setInt(k++, entity.getSubjectId());
        statement.setInt(k++, entity.getAuthorId());
        return k;
    }
}
