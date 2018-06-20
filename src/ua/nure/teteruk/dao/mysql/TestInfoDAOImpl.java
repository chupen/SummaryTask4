package ua.nure.teteruk.dao.mysql;

import ua.nure.teteruk.constant.QueriesConstants;
import ua.nure.teteruk.dao.TestInfoDAO;
import ua.nure.teteruk.dao.mapper.TestInfoMapper;
import ua.nure.teteruk.dao.mapper.TestQuestionMapper;
import ua.nure.teteruk.entity.Complexity;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.exception.DBException;
import ua.nure.teteruk.transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestInfoDAOImpl implements TestInfoDAO {
    @Override
    public TestInfo create(TestInfo entity) {
        TestInfoMapper mapper = new TestInfoMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TESTS_INFO_CREATE, Statement.RETURN_GENERATED_KEYS)){
            mapper.unMap(statement, entity);
            statement.setString(1, entity.getName());
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
    public TestInfo get(int id) {
        TestInfoMapper mapper = new TestInfoMapper();
        TestInfo testInfo = null;
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TESTS_INFO_GET)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                testInfo = mapper.map(resultSet);
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return testInfo;
    }

    @Override
    public TestInfo getByName(String name) {
        TestInfoMapper mapper = new TestInfoMapper();
        TestInfo testInfo = null;
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TESTS_INFO_GET_BY_NAME)){
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                testInfo = mapper.map(resultSet);
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return testInfo;
    }

    @Override
    public List<TestInfo> getAll() {
        List<TestInfo> testInfoList = new ArrayList<>();
        TestInfoMapper mapper = new TestInfoMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TESTS_INFO_GET_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                testInfoList.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return testInfoList;
    }

    @Override
    public List<TestInfo> getBySubjectId(int subjectId) {
        List<TestInfo> testInfoList = new ArrayList<>();
        TestInfoMapper mapper = new TestInfoMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TESTS_INFO_GET_BY_SUBJECT_ID)){
            statement.setInt(1, subjectId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                testInfoList.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return testInfoList;
    }

    @Override
    public void update(TestInfo entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean updateTestInfo(TestInfo entity, int id){
        TestInfoMapper mapper = new TestInfoMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TESTS_INFO_UPDATE)){
            int k = mapper.unMap(statement, entity);
            statement.setInt(k, id);
            statement.executeUpdate();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }

    @Override
    public List<TestInfo> orderByName() {
        List<TestInfo> testInfoList = new ArrayList<>();
        TestInfoMapper mapper = new TestInfoMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TESTS_INFO_SORT_BY_NAME)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                testInfoList.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return testInfoList;
    }

    @Override
    public List<TestInfo> orderByComplexity() {
        List<TestInfo> testInfoList = new ArrayList<>();
        TestInfoMapper mapper = new TestInfoMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TESTS_INFO_SORT_BY_COMPLEXITY)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                testInfoList.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return testInfoList;
    }

    @Override
    public boolean delete(TestInfo entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TESTS_INFO_DELETE)){
            statement.setString(1, entity.getName());
            statement.executeUpdate();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }
}
