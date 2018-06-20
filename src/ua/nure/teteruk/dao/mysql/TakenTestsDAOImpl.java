package ua.nure.teteruk.dao.mysql;

import ua.nure.teteruk.constant.QueriesConstants;
import ua.nure.teteruk.dao.TakenTestsDAO;
import ua.nure.teteruk.dao.mapper.TakenTestMapper;
import ua.nure.teteruk.entity.TakenTests;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.exception.DBException;
import ua.nure.teteruk.transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TakenTestsDAOImpl implements TakenTestsDAO {
    @Override
    public TakenTests create(TakenTests entity) {
        TakenTestMapper mapper = new TakenTestMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TAKEN_TESTS_CREATE, Statement.RETURN_GENERATED_KEYS)){
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
    public TakenTests get(int id) {
        return null;
    }

    @Override
    public List<TakenTests> getTakenTestsByUserId(int userId) {
        List<TakenTests> takenTestsList = new ArrayList<>();
        TakenTestMapper mapper = new TakenTestMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TAKEN_TESTS_GET_BY_USER_ID)){
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                takenTestsList.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return takenTestsList;
    }

    @Override
    public List<TakenTests> getAll() {
        List<TakenTests> takenTestsList = new ArrayList<>();
        TakenTestMapper mapper = new TakenTestMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TAKEN_TESTS_GET_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                takenTestsList.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return takenTestsList;
    }

    @Override
    public void update(TakenTests entity) {

    }

    @Override
    public boolean delete(TakenTests entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TAKEN_TESTS_DELETE)){
            statement.setInt(1, entity.getId());
            statement.executeQuery();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }

    @Override
    public boolean deleteByTestInfoId(TestInfo entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.TAKEN_TESTS_DELETE_BY_TEST_INFO_ID)){
            statement.setInt(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }
}
