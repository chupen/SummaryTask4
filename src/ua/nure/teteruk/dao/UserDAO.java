package ua.nure.teteruk.dao;

import ua.nure.teteruk.entity.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User> {

    User getByLoginOrEmail(String loginOrEmail);

    User getByName(String login);

    User getByLoginAndPassword(String login, String password);

    boolean isExist(String login);

    boolean updateUser(User entity, String oldLogin);

    boolean block (String login);

    boolean unblock (String login);
//    List<User> getByGroup(String groupName); 
}
