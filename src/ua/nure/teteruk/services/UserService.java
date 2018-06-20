package ua.nure.teteruk.services;

import ua.nure.teteruk.entity.Faculty;
import ua.nure.teteruk.entity.Group;
import ua.nure.teteruk.entity.University;
import ua.nure.teteruk.entity.User;

import java.util.List;

public interface UserService {

    //Users
    User validate(String login, String password);

    User createUser(User user);

    void updateUser(User user, String oldLogin);

    boolean isExist(String login);

    boolean block(String login);

    boolean unblock(String login);

    User getUser(int id);

    User read(String loginOrEmail);

    List<User> getAllUsers();

    //Groups
    Group createGroup(Group group);

    Group getGroup(int id);
    
    Group getGroupByName(String groupName);

    List<Group> getAllGroups();

    //Faculties
    Faculty createFaculty(Faculty faculty);

    List<Faculty> getAllFaculties();

    //Universities
    University createUniversity(University university);

    List<University> getAllUniversities();
}
