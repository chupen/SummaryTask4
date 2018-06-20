package ua.nure.teteruk.web.controller.user;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.CompleteTests;
import ua.nure.teteruk.entity.TestQuestion;
import ua.nure.teteruk.services.CompleteTestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StartTestController", urlPatterns = "/startTest")
public class StartTestController extends HttpServlet {

    CompleteTestService service;

    @Override
    public void init() throws ServletException {
        service = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CompleteTests> completeTestsList;
        TestQuestion testQuestion = null;
        int iterate = Integer.valueOf((String) request.getSession().getAttribute("iterate"));
        int testInfoId = (int) request.getSession().getAttribute("testInfoId");

        iterate++;
        List<TestQuestion> testQuestions = service.getTestQuestionsByTestInfoId(testInfoId);
        if (testQuestions.size()-1 == iterate) {
            request.setAttribute("end", "true");
        } else {
            request.setAttribute("end", "false");
        }
        testQuestion = testQuestions.get(iterate);
        if (testQuestion != null) {
            request.setAttribute("testQuestion", testQuestion);
            completeTestsList = service.getCompleteTestsByTestInfoIdAndTestQuestionId(testInfoId, testQuestion.getId());
            request.setAttribute("completeTests", completeTestsList);
            request.getSession().setAttribute("iterate", String.valueOf(iterate));
            request.getRequestDispatcher("WEB-INF/jsp/user/startTest.jsp").forward(request, response);
        }
    }
}
