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

@WebServlet(name = "TryToRedactTestQuestionController", urlPatterns = "/tryToRedactTestQuestion")
public class TryToRedactTestQuestionController extends HttpServlet {

    private CompleteTestService service;

    @Override
    public void init() throws ServletException {
        service = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestInfo testInfo = (TestInfo) request.getSession().getAttribute("testInfo");
        String testQuestionsText = request.getParameter("testQuestionText");
        String[] answersText = request.getParameterValues("answerText");
        String[] correct = request.getParameterValues("correct");
        int testQuestionId = Integer.valueOf(request.getParameter("testQuestionId"));
        TestQuestion testQuestion = service.getTestQuestion(testQuestionId);
        testQuestion.setQuestionText(testQuestionsText);

        service.updateTestQuestion(testQuestion, testQuestionId, testInfo.getId());

        List<CompleteTests> completeTestsList = service.getCompleteTestsByTestInfoIdAndTestQuestionId(testInfo.getId(), testQuestionId);
        for (int j = 0; j < completeTestsList.size(); j++) {
            completeTestsList.get(j).setAnswerText(answersText[j])
                    .setCorrect(Integer.valueOf(correct[j]));
            service.updateCompleteTest(completeTestsList.get(j), testQuestion.getId(), testInfo.getId());
        }

        int iterate = Integer.valueOf((String) request.getSession().getAttribute("iterate"));
        if ("Назад".equals(request.getParameter("back")) || "Back".equals(request.getParameter("back"))) {
            --iterate;
            request.getSession().setAttribute("iterate", String.valueOf(iterate));
        } else {
            ++iterate;
            request.getSession().setAttribute("iterate", String.valueOf(iterate));
        }

        List<TestQuestion> testQuestionList = service.getTestQuestionsByTestInfoId(testInfo.getId());
        if (testQuestionList.size() == iterate) {
            request.getSession().removeAttribute("testInfo");
            request.getSession().removeAttribute("iterate");
            request.getSession().removeAttribute("testQuestion");
            response.sendRedirect("adminIndex");
        } else {
            response.sendRedirect("testQuestionRedact");
        }
    }
}
