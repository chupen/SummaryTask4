package ua.nure.teteruk.web.controller.user;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.User;
import ua.nure.teteruk.entity.UserRole;
import ua.nure.teteruk.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TryToRedactUserController", urlPatterns = "/tryToRedactUser")
public class TryToRedactUserController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(ServletContextAttributesConstants.USER_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (validate(request)) {
            User user = (User) request.getSession().getAttribute(ServletContextAttributesConstants.USER_SESSION);
            String oldLogin = user.getLogin();

            user.setLogin(request.getParameter("login"))
                    .setEmail(request.getParameter("email"))
                    .setName(request.getParameter("name"))
                    .setSurname(request.getParameter("surname"))
                    .setGroupId(Integer.valueOf(request.getParameter("group")));

            userService.updateUser(user, oldLogin);
            response.sendRedirect("userRedact");
        } else {
            response.sendRedirect("userRedact");
        }
    }

    private boolean validate(HttpServletRequest request) {
        String login = request.getParameter("login");
        if (login.length() > 24 || login.length() < 3) {
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
