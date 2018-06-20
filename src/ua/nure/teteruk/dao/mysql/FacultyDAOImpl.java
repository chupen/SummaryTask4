package ua.nure.teteruk.dao.mysql;

import ua.nure.teteruk.constant.QueriesConstants;
import ua.nure.teteruk.dao.FacultyDAO;
import ua.nure.teteruk.dao.mapper.FacultyMapper;
import ua.nure.teteruk.entity.Faculty;
import ua.nure.teteruk.exception.DBException;
import ua.nure.teteruk.transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAOImpl implements FacultyDAO {
    @Override
    public Faculty create(Faculty entity) {
        FacultyMapper mapper = new FacultyMapper();
        Faculty faculty = new Faculty();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.FACULTIES_CREATE, Statement.RETURN_GENERATED_KEYS)){
            mapper.unMap(statement, entity);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                entity.setId(resultSet.getInt(1));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return faculty;
    }

    @Override
    public Faculty get(int id) {
        throw new UnsupportedOperationException("get doesn`t exist");
    }

    @Override
    public List<Faculty> getByUniversityId(int universityId) {
        List<Faculty> faculties = new ArrayList<>();
        FacultyMapper mapper = new FacultyMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.FACULTIES_GET_BY_UNIVERSITY_ID)){
            statement.setInt(1, universityId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                faculties.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return faculties;
    }

    @Override
    public List<Faculty> getAll() {
        List<Faculty> faculties = new ArrayList<>();
        FacultyMapper mapper = new FacultyMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.FACULTIES_GET_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                faculties.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return faculties;
    }

    @Override
    public void update(Faculty entity) {

    }

    @Override
    public boolean delete(Faculty entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.FACULTIES_DELETE)){
            statement.setString(1, entity.getName());
            statement.executeQuery();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }
}
