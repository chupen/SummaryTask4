package ua.nure.teteruk;

import ua.nure.teteruk.dao.*;
import ua.nure.teteruk.dao.mysql.UserDAOImpl;
import ua.nure.teteruk.entity.*;
import ua.nure.teteruk.services.UserService;
import ua.nure.teteruk.transaction.ThreadLocalHandler;
import ua.nure.teteruk.transaction.Transaction;
import ua.nure.teteruk.transaction.TransactionManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = {"/servlet"})
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = (UserService) request.getServletContext().getAttribute("userService");
        //TransactionManager transactionManager = (TransactionManager) request.getServletContext().getAttribute("TransactionManager");

      User user = new User();
        user.setLogin("u4UPDATE");
        user.setPassword("asdf1234");
        user.setEmail("u4@gmail.com");
        user.setRole(UserRole.USER);
        user.setName("alex");
        user.setSurname("sosna");
        user.setBlocked(0);
        user.setGroupId(1);


/*
        University university = new University();
        university.setName("UNIK");
        university.setSphere("ECONOMY");
*/
/*        Faculty faculty = new Faculty();
        faculty.setName("SE");
        faculty.setUniversitiesId(1);*/

/*
        Group group = new Group();
        group.setName("ITCS-16-8");
        group.setFacultyId(1);
*/

/*
        CompleteTests completeTests = new CompleteTests();
        completeTests.setTestQuestionId(2);
        completeTests.setTestInfoId(1);
        completeTests.setAnswerText("-1");
        completeTests.setCorrect(0);
*/

/*
        Subject subject = new Subject();
        subject.setName("Economy");
*/
/*
        TestInfo testInfo = new TestInfo();
        testInfo.setName("Economy test 1");
        testInfo.setComplexity(Complexity.MEDIUM);
        testInfo.setTime(10);
        testInfo.setPassMark(7);
        testInfo.setSubjectId(2);
        testInfo.setAuthorId(8);
*/
/*      TestQuestion testQuestion = new TestQuestion();
        testQuestion.setTestInfoId(1);
        testQuestion.setQuestionText("2*0=?");
*/
/*        TakenTests takenTests = new TakenTests();
        takenTests.setMark(3);
        takenTests.setPassed(0);
        takenTests.setDateOfTaking("02.06.18");
        takenTests.setUserId(4);
        takenTests.setTestsInfoId(1);*/
        //System.out.println(transactionManager.execute(() -> completeTestsDAO.create(completeTests)));

        System.out.println(userService.block("u1"));
        System.out.println("~~~");
        System.out.println(userService.read("u1"));
        System.out.println("~~~");
        System.out.println(userService.unblock("u1"));
        System.out.println("~~~");
        System.out.println(userService.read("sfasd@gmail.com"));
    }
}
