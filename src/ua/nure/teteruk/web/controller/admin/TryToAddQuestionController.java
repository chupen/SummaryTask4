package ua.nure.teteruk.web.controller.admin;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.entity.TestQuestion;
import ua.nure.teteruk.services.CompleteTestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TryToAddQuestionController", urlPatterns = "/tryToAddQuestion")
public class TryToAddQuestionController extends HttpServlet {

    private CompleteTestService service;

    @Override
    public void init() throws ServletException {
        service = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestInfo testInfo = (TestInfo) request.getSession().getAttribute("testInfo");
        String question = request.getParameter("question");
        TestQuestion testQuestion = new TestQuestion().setTestInfoId(testInfo.getId()).setQuestionText(question);
        service.createTestQuestion(testQuestion);
        request.getSession().setAttribute("testQuestion", service.getTestQuestionByTestInfoIdAndQuestionText(testInfo.getId(), question));
        response.sendRedirect("addAnswer");
    }
}
