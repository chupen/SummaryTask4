package ua.nure.teteruk.web.controller.admin;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.TestInfo;
import ua.nure.teteruk.services.CompleteTestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminIndexController", urlPatterns = "/adminIndex")
public class AdminIndexController extends HttpServlet {

    private CompleteTestService completeTestService;

    @Override
    public void init() throws ServletException {
        completeTestService = (CompleteTestService) getServletContext().getAttribute(ServletContextAttributesConstants.COMPLETE_TEST_SERVICE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subjectId = request.getParameter("subject");
        String sortByName = request.getParameter("name");
        String sortByComplexity = request.getParameter("complexity");
        if (subjectId != null && !"".equals(subjectId) && !"*".equals(subjectId)) {
            request.setAttribute("testInfos", completeTestService.getTestInfoBySubjectId(Integer.valueOf(subjectId)));
        } else if ("sortByName".equals(sortByName)) {
            List<TestInfo> til= completeTestService.testInfoOrderByTestInfoName();
            request.setAttribute("testInfos", til);
        } else if ("sortByComplexity".equals(sortByComplexity)) {
            List<TestInfo> til = completeTestService.testInfoOrderByComplexity();
            request.setAttribute("testInfos", til);
        } else {
            request.setAttribute("testInfos", completeTestService.getAllTestInfos());
        }
        request.setAttribute("subjects", completeTestService.getAllSubjects());
        request.getRequestDispatcher("WEB-INF/jsp/admin/indexAdmin.jsp").forward(request, response);
    }
}
