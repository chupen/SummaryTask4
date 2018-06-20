package ua.nure.teteruk.dao.mysql;

import ua.nure.teteruk.constant.QueriesConstants;
import ua.nure.teteruk.dao.SubjectDAO;
import ua.nure.teteruk.dao.mapper.SubjectMapper;
import ua.nure.teteruk.entity.Subject;
import ua.nure.teteruk.exception.DBException;
import ua.nure.teteruk.transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {
    @Override
    public Subject create(Subject entity) {
        SubjectMapper mapper = new SubjectMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.SUBJECTS_CREATE, Statement.RETURN_GENERATED_KEYS)){
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
    public Subject get(int id) {
        SubjectMapper mapper = new SubjectMapper();
        Subject subject = new Subject();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.SUBJECTS_GET)){
            statement.setInt(1 ,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                subject = mapper.map(resultSet);
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return subject;
    }

    @Override
    public List<Subject> getAll() {
        List<Subject> subjects = new ArrayList<>();
        SubjectMapper mapper = new SubjectMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.SUBJECTS_GET_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                subjects.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return subjects;
    }

    @Override
    public void update(Subject entity) {

    }

    @Override
    public boolean delete(Subject entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.SUBJECTS_DELETE)){
            statement.setInt(1, entity.getId());
            statement.executeQuery();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }
}
