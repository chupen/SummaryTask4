package ua.nure.teteruk.dao.mysql;

import ua.nure.teteruk.constant.QueriesConstants;
import ua.nure.teteruk.dao.TestQuestionDAO;
import ua.nure.teteruk.dao.mapper.TestQuestionMapper;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.entity.TestQuestion;
import ua.nure.teteruk.exception.DBException;
import ua.nure.teteruk.transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestQuestionDAOImpl implements TestQuestionDAO {
    @Override
    public TestQuestion create(TestQuestion entity) {
        TestQuestionMapper mapper = new TestQuestionMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TEST_QUESTIONS_CREATE, Statement.RETURN_GENERATED_KEYS)){
            mapper.unMap(statement, entity);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                entity.setId(resultSet.getInt(1));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return entity;
    }

    @Override
    public TestQuestion get(int id) {
        TestQuestionMapper mapper = new TestQuestionMapper();
        TestQuestion testQuestion = null;
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TEST_QUESTIONS_GET)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                testQuestion = mapper.map(resultSet);
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return testQuestion;
    }

    @Override
    public List<TestQuestion> getTestQuestionsByTestInfoId(int testInfoId) {
        List<TestQuestion> testQuestionList = new ArrayList<>();
        TestQuestionMapper mapper = new TestQuestionMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TEST_QUESTIONS_GET_BY_TEST_INFO_ID)){
            statement.setInt(1, testInfoId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                testQuestionList.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return testQuestionList;
    }

    @Override
    public List<TestQuestion> getAll() {
        List<TestQuestion> testQuestionList = new ArrayList<>();
        TestQuestionMapper mapper = new TestQuestionMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TEST_QUESTIONS_GET_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                testQuestionList.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return testQuestionList;
    }

    @Override
    public TestQuestion getTestQuestionByTestInfoIdAndQuestionText(int testInfoId, String questionText) {
        TestQuestion testQuestion = new TestQuestion();
        TestQuestionMapper mapper = new TestQuestionMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TEST_QUESTION_BET_BY_TEST_INFO_ID_AND_QUESTION_TEXT)){
            statement.setInt(1, testInfoId);
            statement.setString(2, questionText);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                testQuestion = mapper.map(resultSet);
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return testQuestion;
    }

    @Override
    public void update(TestQuestion entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean updateTestQuestion(TestQuestion entity, int id, int testInfoId) {
        TestQuestionMapper mapper = new TestQuestionMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TEST_QUESTIONS_UPDATE)){
            int k = 1;
            statement.setString(k++, entity.getQuestionText());
            statement.setInt(k++, id);
            statement.setInt(k++, testInfoId);
            statement.executeUpdate();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }

    @Override
    public boolean delete(TestQuestion entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TEST_QUESTIONS_DELETE)){
            statement.setInt(1, entity.getId());
            statement.setInt(2, entity.getTestInfoId());
            statement.executeUpdate();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }

    @Override
    public boolean deleteByTestInfo(TestInfo entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TEST_QUESTIONS_DELETE_BY_TEST_INFO_ID)){
            statement.setInt(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }
}
