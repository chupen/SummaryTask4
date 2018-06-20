package ua.nure.teteruk.web.controller.user;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.services.CompleteTestService;
import ua.nure.teteruk.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestInfoController", urlPatterns = "/testInfo")
public class TestInfoController extends HttpServlet {

    private CompleteTestService completeTestService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        completeTestService = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
        userService = (UserService) getServletContext().getAttribute(ServletContextAttributesConstants.USER_SERVICE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestInfo testInfo = completeTestService.getTestInfo(Integer.valueOf(request.getParameter("testInfoId")));
        String author = userService.getUser(testInfo.getAuthorId()).getLogin();
        String subject = completeTestService.getSubject(testInfo.getSubjectId()).getName();
        request.setAttribute("testInfo", testInfo);
        request.setAttribute("author", author);
        request.setAttribute("subject", subject);
        request.getRequestDispatcher("WEB-INF/jsp/user/testInfo.jsp").forward(request, response);
    }
}
