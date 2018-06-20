package ua.nure.teteruk.web.controller.admin;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.Subject;
import ua.nure.teteruk.services.CompleteTestService;
import ua.nure.teteruk.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateTestInfoController", urlPatterns = "/createTestInfo")
public class CreateTestInfoController extends HttpServlet {

    private CompleteTestService completeTestService;

    @Override
    public void init() throws ServletException {
        completeTestService = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Subject> subjects = completeTestService.getAllSubjects();
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("WEB-INF/jsp/admin/createTestInfo.jsp").forward(request, response);
    }
}
