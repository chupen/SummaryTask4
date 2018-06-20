package ua.nure.teteruk.web.controller.admin;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.CompleteTests;
import ua.nure.teteruk.entity.Subject;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.entity.TestQuestion;
import ua.nure.teteruk.services.CompleteTestService;
import ua.nure.teteruk.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TestRedactController", urlPatterns = "/testRedact")
public class TestRedactController extends HttpServlet {

    private CompleteTestService completeTestService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        completeTestService = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
        userService = (UserService) getServletContext().getAttribute(ServletContextAttributesConstants.USER_SERVICE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int testInfoId = Integer.valueOf(request.getParameter("testInfoId"));
        TestInfo testInfo = completeTestService.getTestInfo(testInfoId);
        String author = userService.getUser(testInfo.getAuthorId()).getLogin();
        List<Subject> subjects = completeTestService.getAllSubjects();
        request.setAttribute("testInfo", testInfo);
        request.setAttribute("author", author);
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("WEB-INF/jsp/admin/testRedact.jsp").forward(request, response);
    }
}
