package ua.nure.teteruk.services;

import ua.nure.teteruk.dao.FacultyDAO;
import ua.nure.teteruk.dao.GroupDAO;
import ua.nure.teteruk.dao.UniversityDAO;
import ua.nure.teteruk.dao.UserDAO;
import ua.nure.teteruk.entity.Faculty;
import ua.nure.teteruk.entity.Group;
import ua.nure.teteruk.entity.University;
import ua.nure.teteruk.entity.User;
import ua.nure.teteruk.transaction.TransactionManager;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private GroupDAO groupDAO;
    private FacultyDAO facultyDAO;
    private UniversityDAO universityDAO;
    private TransactionManager transactionManager;

    public UserServiceImpl(UserDAO userDAO, GroupDAO groupDAO, FacultyDAO facultyDAO,
                           UniversityDAO universityDAO, TransactionManager transactionManager) {
        this.userDAO = userDAO;
        this.groupDAO = groupDAO;
        this.facultyDAO = facultyDAO;
        this.universityDAO = universityDAO;
        this.transactionManager = transactionManager;
    }

    //Users
    @Override
    public User validate(String login, String password) {
        return transactionManager.execute(() -> userDAO.getByLoginAndPassword(login, password));
    }

    @Override
    public User createUser(User user) {
        return transactionManager.execute(() -> userDAO.create(user));
    }

    @Override
    public User getUser(int id) {
        return transactionManager.execute(()->userDAO.get(id));
    }

    @Override
    public void updateUser(User user, String oldLogin) {
        transactionManager.execute(() -> userDAO.updateUser(user, oldLogin));
    }

    @Override
    public boolean isExist(String login) {
        return transactionManager.execute(() -> userDAO.isExist(login));
    }

    @Override
    public boolean block(String login) {
        return transactionManager.execute(() -> userDAO.block(login));
    }

    @Override
    public User read(String loginOrEmail) {
        return transactionManager.execute(() -> userDAO.getByLoginOrEmail(loginOrEmail));
    }

    @Override
    public boolean unblock(String login) {
        return transactionManager.execute(() -> userDAO.unblock(login));
    }

    @Override
    public List<User> getAllUsers() {
        return transactionManager.execute(()->userDAO.getAll());
    }

    //Groups
    @Override
    public Group createGroup(Group group) {
        return transactionManager.execute(()->groupDAO.create(group));
    }

    @Override
    public Group getGroup(int id) {
        return transactionManager.execute(()->groupDAO.get(id));
    }

    @Override
    public List<Group> getAllGroups() {
        return transactionManager.execute(()->groupDAO.getAll());
    }

    @Override
    public Group getGroupByName(String groupName) {
        return transactionManager.execute(()->groupDAO.getByName(groupName));
    }

    //Faculties
    @Override
    public Faculty createFaculty(Faculty faculty) {
        return transactionManager.execute(()->facultyDAO.create(faculty));
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return transactionManager.execute(()->facultyDAO.getAll());
    }

    //Universities
    @Override
    public University createUniversity(University university) {
        return transactionManager.execute(()->universityDAO.create(university));
    }

    @Override
    public List<University> getAllUniversities() {
        return transactionManager.execute(()->universityDAO.getAll());
    }
}
