package ua.nure.teteruk.web.controller.admin;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.User;
import ua.nure.teteruk.services.CompleteTestService;
import ua.nure.teteruk.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserManageController", urlPatterns = "/userManage")
public class UserManageController extends HttpServlet {

    private UserService service;

    @Override
    public void init() throws ServletException {
        service = (UserService) getServletContext().getAttribute(ServletContextAttributesConstants.USER_SERVICE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = service.getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("WEB-INF/jsp/admin/userManage.jsp").forward(request, response);
    }
}
