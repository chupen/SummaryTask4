package ua.nure.teteruk.dao.mysql;

import ua.nure.teteruk.constant.QueriesConstants;
import ua.nure.teteruk.dao.UniversityDAO;
import ua.nure.teteruk.dao.mapper.UniversityMapper;
import ua.nure.teteruk.entity.University;
import ua.nure.teteruk.exception.DBException;
import ua.nure.teteruk.transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversityDAOImpl implements UniversityDAO {
    @Override
    public University create(University entity) {
        UniversityMapper mapper = new UniversityMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueriesConstants.UNIVERSITIES_CREATE, Statement.RETURN_GENERATED_KEYS)) {
            mapper.unMap(statement, entity);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                entity.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return entity;
    }

    @Override
    public University get(int id) {
        throw new UnsupportedOperationException("get doesn`t exist");
    }

    @Override
    public List<University> getAll() {
        List<University> universities = new ArrayList<>();
        UniversityMapper mapper = new UniversityMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueriesConstants.UNIVERSITIES_GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                universities.add(mapper.map(resultSet));
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return universities;
    }

    @Override
    public void update(University entity) {
        throw new UnsupportedOperationException("update doesn`t exist");
    }

    @Override
    public void updateSphere(University entity) {
        UniversityMapper mapper = new UniversityMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueriesConstants.UNIVERSITIES_UPDATE_SPHERE)) {
            int k = mapper.unMap(statement, entity);
            statement.setString(++k, entity.getName());
            statement.executeQuery();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    @Override
    public boolean delete(University entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueriesConstants.UNIVERSITIES_DELETE)) {
            statement.setString(1, entity.getName());
            statement.executeQuery();
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return true;
    }

    @Override
    public University getByName(String universityName) {
        UniversityMapper mapper = new UniversityMapper();
        University university = new University();
        Connection connection = ThreadLocalHandler.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(QueriesConstants.UNIVERSITIES_GET_BY_NAME)) {
            statement.setString(1, universityName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                university = mapper.map(resultSet);
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return university;
    }
}
