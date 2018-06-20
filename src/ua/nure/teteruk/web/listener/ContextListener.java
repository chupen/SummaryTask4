package ua.nure.teteruk.web.listener;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.dao.*;
import ua.nure.teteruk.dao.mysql.*;
import ua.nure.teteruk.entity.TakenTests;
import ua.nure.teteruk.exception.DBException;
import ua.nure.teteruk.services.*;
import ua.nure.teteruk.transaction.TransactionManager;
import ua.nure.teteruk.util.PasswordHash;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class ContextListener implements ServletContextListener {


    private final String pathToDataBase;

    public ContextListener() {
        pathToDataBase = "java:/comp/env/jdbc/st4";
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        DataSource dataSource;
        try {
            Context initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup(pathToDataBase);
        } catch (NamingException e) {
            throw new DBException(e);
        }

        TransactionManager transactionManager = new TransactionManager(dataSource);
        PasswordHash passwordHash = new PasswordHash();

        UserDAO userDAO = new UserDAOImpl();
        UniversityDAO universityDAO = new UniversityDAOImpl();
        FacultyDAO facultyDAO = new FacultyDAOImpl();
        GroupDAO groupDAO = new GroupDAOImpl();
        CompleteTestsDAO completeTestsDAO = new CompleteTestsDAOImpl();
        SubjectDAO subjectDAO = new SubjectDAOImpl();
        TestInfoDAO testInfoDAO = new TestInfoDAOImpl();
        TestQuestionDAO testQuestionDAO = new TestQuestionDAOImpl();
        TakenTestsDAO takenTestsDAO = new TakenTestsDAOImpl();

        UserService userService = new UserServiceImpl(userDAO, groupDAO, facultyDAO, universityDAO, transactionManager);
        CompleteTestService completeTestService = new CompleteTestServiceImpl(subjectDAO, testInfoDAO, testQuestionDAO,
                completeTestsDAO, transactionManager);
        TakenTestsService takenTestsService = new TakenTestsServiceImpl(takenTestsDAO, transactionManager);
        servletContext.setAttribute(ServletContextAttributesConstants.USER_SERVICE, userService);
        servletContext.setAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE, completeTestService);
        servletContext.setAttribute(ServletContextAttributesConstants.TAKEN_TESTS_SERVICE, takenTestsService);
        servletContext.setAttribute("passwordHash", passwordHash);
        //servletContext.setAttribute("TransactionManager", transactionManager);
    }
}
