package ua.nure.teteruk.web.controller.user;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.Group;
import ua.nure.teteruk.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserRedactController", urlPatterns = "/userRedact")
public class UserRedactController extends HttpServlet {

    UserService service;

    @Override
    public void init() throws ServletException {
        service = (UserService) getServletContext().getAttribute(ServletContextAttributesConstants.USER_SERVICE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Group> groups = service.getAllGroups();
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("/WEB-INF/jsp/user/userRedact.jsp").forward(request, response);
    }
}
