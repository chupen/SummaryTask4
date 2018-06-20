package ua.nure.teteruk.dao.mysql;

import ua.nure.teteruk.constant.QueriesConstants;
import ua.nure.teteruk.dao.GroupDAO;
import ua.nure.teteruk.dao.mapper.GroupMapper;
import ua.nure.teteruk.entity.Group;
import ua.nure.teteruk.exception.DBException;
import ua.nure.teteruk.transaction.ThreadLocalHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDAOImpl implements GroupDAO {
    @Override
    public Group create(Group entity) {
        GroupMapper mapper = new GroupMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.GROUPS_CREATE, Statement.RETURN_GENERATED_KEYS)){
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
    public Group get(int id) {
        GroupMapper mapper = new GroupMapper();
        Group group  = null;
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.GROUPS_GET)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                group = mapper.map(resultSet);
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
        return group;
    }

    @Override
    public List<Group> getAll() {
        List<Group> groups = new ArrayList<>();
        GroupMapper mapper = new GroupMapper();
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.GROUPS_GET_ALL)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                groups.add(mapper.map(resultSet));
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return groups;
    }

    @Override
    public void update(Group entity) {
        throw new UnsupportedOperationException("Groups#update()");
    }

    @Override
    public boolean delete(Group entity) {
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.GROUPS_DELETE)){
            statement.setString(1, entity.getName());
            statement.executeQuery();
        } catch (SQLException e){
            throw new DBException(e);
        }
        return true;
    }

    @Override
    public Group getByName(String groupName) {
        GroupMapper mapper = new GroupMapper();
        Group group = null;
        Connection connection = ThreadLocalHandler.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(QueriesConstants.GROUPS_GET_BY_NAME)){
            statement.setString(1, groupName);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                group = mapper.map(resultSet);
            }
        } catch (SQLException e){
            throw new DBException(e);
        }
        return group;
    }
}
