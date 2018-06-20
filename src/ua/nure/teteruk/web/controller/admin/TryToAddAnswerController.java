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

@WebServlet(name = "TryToAddAnswerController", urlPatterns = "/tryToAddAnswer")
public class TryToAddAnswerController extends HttpServlet {

    private CompleteTestService service;

    @Override
    public void init() throws ServletException {
        service = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestInfo testInfo = (TestInfo) request.getSession().getAttribute("testInfo");
        TestQuestion testQuestion = (TestQuestion) request.getSession().getAttribute("testQuestion");
        String answer = request.getParameter("answer");
        String correctTemp = request.getParameter("correct");
        int correct;
        if ("on".equals(correctTemp)) {
            correct = 1;
        } else {
            correct = 0;
        }
        CompleteTests completeTest = new CompleteTests().setTestQuestionId(testQuestion.getId())
                .setTestInfoId(testInfo.getId())
                .setAnswerText(answer)
                .setCorrect(correct);
        service.createCompleteTests(completeTest);
        response.sendRedirect("addAnswer");
    }
}
