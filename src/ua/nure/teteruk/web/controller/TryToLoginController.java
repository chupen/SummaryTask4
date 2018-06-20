package ua.nure.teteruk.web.controller;

import ua.nure.teteruk.constant.FieldsConstants;
import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.User;
import ua.nure.teteruk.entity.UserRole;
import ua.nure.teteruk.services.UserService;
import ua.nure.teteruk.util.PasswordHash;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "TryToLoginController", urlPatterns = "/tryToLogin")
public class TryToLoginController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(ServletContextAttributesConstants.USER_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        if (validate(request)) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            PasswordHash passwordHash = (PasswordHash) getServletContext().getAttribute("passwordHash");
            password = passwordHash.hash(password);

            User user = userService.validate(login, password);

            if (Objects.equals(user, null)) {
                response.sendRedirect("login");
            } else if (FieldsConstants.USERS_BLOCKED_TRUE == user.getBlocked()) {
                response.sendRedirect("login");
            } else {
                request.getSession().setAttribute(ServletContextAttributesConstants.USER_SESSION, user);
                if (UserRole.ADMIN.name().equals(user.getRole().name())) {
                    response.sendRedirect("adminIndex");
                } else {
                    response.sendRedirect("indexUser");
                }
            }
        } else {
            response.sendRedirect("login");
        }
    }

    private boolean validate(HttpServletRequest request) {
        String login = request.getParameter("login");
        if (login.length() > 24 || login.length() < 2) {
            return false;
        }

        String password = request.getParameter("password");
        return password.length() <= 24 && password.length() >= 3;
    }
}
