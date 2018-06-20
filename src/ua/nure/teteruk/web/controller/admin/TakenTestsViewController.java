package ua.nure.teteruk.web.controller.admin;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.TakenTests;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.entity.User;
import ua.nure.teteruk.services.CompleteTestService;
import ua.nure.teteruk.services.TakenTestsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TakenTestsViewController", urlPatterns = "/takenTestsView")
public class TakenTestsViewController extends HttpServlet {
    private TakenTestsService takenTestsService;
    private CompleteTestService completeTestService;

    @Override
    public void init() throws ServletException {
        takenTestsService = (TakenTestsService) getServletContext().getAttribute(ServletContextAttributesConstants.TAKEN_TESTS_SERVICE);
        completeTestService = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(ServletContextAttributesConstants.USER_SESSION);
        List<TakenTests> takenTestsList = takenTestsService.getTakenTestsByUserId(user.getId());
        List<TestInfo> testInfoList = new ArrayList<>();

        for (int i = 0; i < takenTestsList.size(); i++) {
            testInfoList.add(completeTestService.getTestInfo(takenTestsList.get(i).getTestsInfoId()));
        }

        request.setAttribute("testInfoList", testInfoList);
        request.setAttribute("userLogin", user.getLogin());
        request.setAttribute("takenTests", takenTestsList);
        request.getRequestDispatcher("WEB-INF/jsp/user/takenTests.jsp").forward(request, response);
    }
}
