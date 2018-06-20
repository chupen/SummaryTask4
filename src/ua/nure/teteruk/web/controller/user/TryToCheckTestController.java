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
import java.util.List;

@WebServlet(name = "TryToCheckTestController", urlPatterns = "/tryToCheckTest")
public class TryToCheckTestController extends HttpServlet {

    private CompleteTestService service;

    @Override
    public void init() throws ServletException {
        service = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] chosenAnswersId = request.getParameterValues("check");
        TestQuestion testQuestion = service.getTestQuestion(Integer.valueOf(request.getParameter("testQuestionId")));
        int testInfoId = (int) request.getSession().getAttribute("testInfoId");
        int mark = Integer.valueOf((String) request.getSession().getAttribute("mark"));
        List<CompleteTests> completeTestsList = service.getCorrectCompleteTestsByTestInfoIdAndTestQuestionId(testInfoId, testQuestion.getId());
        boolean isCorrect = true;
        if(chosenAnswersId != null) {
            if (isCorrect != false && completeTestsList.size() != chosenAnswersId.length) {
                isCorrect = false;
            }
            for (int i = 0; i < completeTestsList.size(); i++) {
                if (isCorrect != false && completeTestsList.get(i).getAnswerId() != Integer.valueOf(chosenAnswersId[i])) {
                    isCorrect = false;
                }
            }
            if (isCorrect == true) {
                ++mark;
                request.getSession().setAttribute("mark", String.valueOf(mark));
            }
        }
        if(request.getParameter("end").equals("false")) {
            response.sendRedirect("startTest");
        } else {
            response.sendRedirect("takenTests");
        }
    }
}
