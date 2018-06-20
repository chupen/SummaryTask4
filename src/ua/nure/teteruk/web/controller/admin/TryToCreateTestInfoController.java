package ua.nure.teteruk.web.controller.admin;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.Complexity;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.entity.User;
import ua.nure.teteruk.services.CompleteTestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TryToCreateTestInfoController", urlPatterns = "/tryToCreateTestInfo")
public class TryToCreateTestInfoController extends HttpServlet {

    private CompleteTestService service;

    @Override
    public void init() throws ServletException {
        service = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(validate(request)){
            User user = (User) request.getSession().getAttribute(ServletContextAttributesConstants.USER_SESSION);
            TestInfo testInfo = new TestInfo().setName(request.getParameter("name"))
                    .setComplexity(Complexity.valueOf(request.getParameter("complexity")))
                    .setTime(Integer.valueOf(request.getParameter("time")))
                    .setPassMark(Integer.valueOf(request.getParameter("passMark")))
                    .setSubjectId(Integer.valueOf(request.getParameter("subject")))
                    .setAuthorId(user.getId());

            service.createTestInfo(testInfo);
            request.getSession().setAttribute("testInfo", service.getTestInfoByName(testInfo.getName()));
            response.sendRedirect("addQuestion");
        } else{
            response.sendRedirect("createTestInfo");
        }
    }

    private boolean validate(HttpServletRequest request) {
        String name = request.getParameter("name");
        if (name.length() > 24 || name.length() < 3) {
            return false;
        }

        String time = request.getParameter("time");
        if (time.length() < 1 || time.length() > 10 || Integer.valueOf(time) == 0) {
            return false;
        }

        String passMark = request.getParameter("passMark");
        if (passMark.length() < 1 || passMark.length() > 5 || Integer.valueOf(passMark) == 0) {
            return false;
        }

        String subject = request.getParameter("subject");
        if (subject.length() > 10 || subject.length() < 1) {
            return false;
        } else {
            return true;
        }
    }
}
