package ua.nure.teteruk.web.controller.admin;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.CompleteTests;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.entity.TestQuestion;
import ua.nure.teteruk.services.CompleteTestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TestQuestionRedactController", urlPatterns = "/testQuestionRedact")
public class TestQuestionRedactController extends HttpServlet {

    private CompleteTestService service;

    @Override
    public void init() throws ServletException {
        service = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestInfo testInfo = (TestInfo) request.getSession().getAttribute("testInfo");
        int iterate = Integer.valueOf((String) request.getSession().getAttribute("iterate"));
        TestQuestion testQuestion;
        List<CompleteTests> completeTestsList;

        List<TestQuestion> testQuestionList = service.getTestQuestionsByTestInfoId(testInfo.getId());

        testQuestion = testQuestionList.get(iterate);
        if (testQuestion != null) {
            request.getSession().setAttribute("testQuestion", testQuestion);
            completeTestsList = service.getCompleteTestsByTestInfoIdAndTestQuestionId(testInfo.getId(), testQuestion.getId());
            request.setAttribute("completeTests", completeTestsList);
            request.getRequestDispatcher("WEB-INF/jsp/admin/testQuestionRedact.jsp").forward(request, response);
        }
    }
}
