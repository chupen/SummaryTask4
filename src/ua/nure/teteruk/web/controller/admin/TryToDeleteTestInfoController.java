package ua.nure.teteruk.web.controller.admin;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.TakenTests;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.services.CompleteTestService;
import ua.nure.teteruk.services.TakenTestsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TryToDeleteTestInfoController", urlPatterns = "/tryToDeleteTestInfo")
public class TryToDeleteTestInfoController extends HttpServlet {

    private CompleteTestService service;
    private TakenTestsService takenTestsService;

    @Override
    public void init() throws ServletException {
        service = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
        takenTestsService = (TakenTestsService) getServletContext().getAttribute(ServletContextAttributesConstants.TAKEN_TESTS_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestInfo testInfo = service.getTestInfo(Integer.valueOf(request.getParameter("id")));
        takenTestsService.deleteTakenTestsByTestInfoId(testInfo);
        service.deleteCompleteTestsByTestInfo(testInfo);
        service.deleteTestQuestionsByTestInfo(testInfo);
        service.deleteTestInfo(testInfo);
        response.sendRedirect("adminIndex");
    }
}
