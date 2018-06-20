package ua.nure.teteruk.web.controller;

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

@WebServlet(name = "TryToRegisterController", urlPatterns = "/tryToRegister")
public class TryToRegisterController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(ServletContextAttributesConstants.USER_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (validate(request)) {
            String password = request.getParameter("password");

            PasswordHash passwordHash = (PasswordHash) getServletContext().getAttribute("passwordHash");
            password = passwordHash.hash(password);

            User user = new User()
                    .setLogin(request.getParameter("login"))
                    .setPassword(password)
                    .setEmail(request.getParameter("email"))
                    .setRole(UserRole.USER)
                    .setName(request.getParameter("name"))
                    .setSurname(request.getParameter("surname"))
                    .setBlocked(0)
                    .setGroupId(0);
            userService.createUser(user);

            request.getSession().setAttribute(ServletContextAttributesConstants.USER_SESSION, user);
            response.sendRedirect("indexUser");
        } else {
            response.sendRedirect("login");
        }
    }

    private boolean validate(HttpServletRequest request) {
        String login = request.getParameter("login");
        if (userService.isExist(login) || login.length() > 24 || login.length() < 3) {
            return false;
        }

        String password = request.getParameter("password");
        if (password.length() > 24 || password.length() < 3) {
            return false;
        }

        String email = request.getParameter("email");
        if (email.length() > 50 || email.length() < 6 ||
                !email.trim().matches("^[a-z0-9]+@[a-z0-9]+\\.[a-z0-9]+$")) {
            return false;
        }

        String name = request.getParameter("name");
        if (name.length() > 24 || name.length() < 2) {
            return false;
        }

        String surname = request.getParameter("surname");
        if (surname.length() > 24 || surname.length() < 2) {
            return false;
        } else {
            return true;
        }
    }
}
