package ua.nure.teteruk.web.controller.admin;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.TakenTests;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.entity.User;
import ua.nure.teteruk.services.CompleteTestService;
import ua.nure.teteruk.services.CompleteTestServiceImpl;
import ua.nure.teteruk.services.TakenTestsService;
import ua.nure.teteruk.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TakenTestsController", urlPatterns = "/takenTests")
public class TakenTestsController extends HttpServlet {

    private TakenTestsService takenTestsService;
    private CompleteTestService completeTestService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        takenTestsService = (TakenTestsService) getServletContext().getAttribute(ServletContextAttributesConstants.TAKEN_TESTS_SERVICE);
        completeTestService = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
        userService = (UserService) getServletContext().getAttribute(ServletContextAttributesConstants.USER_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int mark = Integer.valueOf((String) request.getSession().getAttribute("mark"));
        int testInfoId = (int) request.getSession().getAttribute("testInfoId");
        TestInfo testInfo = completeTestService.getTestInfo(testInfoId);
        User user = (User) request.getSession().getAttribute(ServletContextAttributesConstants.USER_SESSION);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        TakenTests takenTests = new TakenTests().setMark(mark)
                .setPassed(testInfo.getPassMark() < mark ? 1 : 0)
                .setDateOfTaking(dateFormat.format(date))
                .setUserId(user.getId())
                .setTestsInfoId(testInfoId);

        takenTestsService.createTakenTest(takenTests);

        List<TakenTests> takenTestsList = takenTestsService.getTakenTestsByUserId(user.getId());
        List<TestInfo> testInfoList = new ArrayList<>();
        for (int i = 0; i < takenTestsList.size(); i++) {
            testInfoList.add(completeTestService.getTestInfo(takenTestsList.get(i).getTestsInfoId()));
        }
        request.setAttribute("testInfoList", testInfoList);
        request.setAttribute("takenTests", takenTestsList);
        request.setAttribute("userLogin", user.getLogin());

        request.getSession().removeAttribute("iterate");
        request.getSession().removeAttribute("mark");
        request.getSession().removeAttribute("testInfoId");
        request.getRequestDispatcher("WEB-INF/jsp/user/takenTests.jsp").forward(request, response);
    }
}
