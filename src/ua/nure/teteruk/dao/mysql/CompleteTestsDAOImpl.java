package ua.nure.teteruk.dao.mysql;

import ua.nure.teteruk.constant.QueriesConstants;
import ua.nure.teteruk.dao.CompleteTestsDAO;
import ua.nure.teteruk.dao.mapper.CompleteTestMapper;
import ua.nure.teteruk.entity.CompleteTests;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.exception.DBException;
import ua.nure.teteruk.transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompleteTestsDAOImpl implements CompleteTestsDAO {
    @Override
    public CompleteTests create(CompleteTests entity) {
        CompleteTestMapper mapper = new CompleteTestMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueriesConstants.COMPLETE_TESTS_CREATE, Statement.RETURN_GENERATED_KEYS)) {
            mapper.unMap(statement, entity);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                entity.setAnswerId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return entity;
    }

    @Override
    public CompleteTests get(int id) {
        return null;
    }

    @Override
    public List<CompleteTests> getCorrectByTestInfoIdAndTestQuestionId(int testInfoId, int testQuestionId) {
        List<CompleteTests> completeTestsList = new ArrayList<>();
        CompleteTestMapper mapper = new CompleteTestMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.COMPLETE_TESTS_GET_ALL_CORRECT_BY_TEST_INFO_ID_AND_TEST_QUESTION_ID)){
            statement.setInt(1, testInfoId);
            statement.setInt(2, testQuestionId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                completeTestsList.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return completeTestsList;
    }

    @Override
    public List<CompleteTests> getByTestInfoIdAndTestQuestionId(int testInfoId, int testQuestionId) {
        List<CompleteTests> completeTestsList = new ArrayList<>();
        CompleteTestMapper mapper = new CompleteTestMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.COMPLETE_TESTS_GET_BY_TEST_INFO_ID_AND_TEST_QUESTION_ID)){
            statement.setInt(1, testInfoId);
            statement.setInt(2, testQuestionId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                completeTestsList.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return completeTestsList;
    }

    @Override
    public List<CompleteTests> getAll() {
        List<CompleteTests> completeTestsList = new ArrayList<>();
        CompleteTestMapper mapper = new CompleteTestMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueriesConstants.COMPLETE_TESTS_GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                completeTestsList.add(mapper.map(resultSet));
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return completeTestsList;
    }

    @Override
    public void update(CompleteTests entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean updateCompleteTest(CompleteTests completeTests, int testQuestionId, int testInfoId) {
        CompleteTestMapper mapper = new CompleteTestMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.COMPLETE_TESTS_UPDATE)){
            int k = 1;
            statement.setString(k++, completeTests.getAnswerText());
            statement.setInt(k++, completeTests.getCorrect());
            statement.setInt(k++, completeTests.getAnswerId());
            statement.setInt(k++, testQuestionId);
            statement.setInt(k, testInfoId);
            statement.executeUpdate();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }

    @Override
    public boolean delete(CompleteTests entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueriesConstants.COMPLETE_TESTS_DELETE)) {
            statement.setInt(1, entity.getAnswerId());
            statement.setInt(2, entity.getTestQuestionId());
            statement.setInt(3, entity.getTestInfoId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return true;
    }

    @Override
    public boolean deleteByTestInfo(TestInfo entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueriesConstants.COMPLETE_TESTS_DELETE_BY_TEST_INFO_ID)) {
            statement.setInt(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return true;
    }
}
