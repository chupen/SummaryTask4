package ua.nure.teteruk.web.controller.admin;

import ua.nure.teteruk.constant.ServletContextAttributesConstants;
import ua.nure.teteruk.entity.User;
import ua.nure.teteruk.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TryToChangeStatusController", urlPatterns = "/tryToChangeStatus")
public class TryToChangeStatusController extends HttpServlet {

    private UserService service;

    @Override
    public void init() throws ServletException {
        service = (UserService) getServletContext().getAttribute(ServletContextAttributesConstants.USER_SERVICE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int block = Integer.valueOf(request.getParameter("block"));
        String login = request.getParameter("userLogin");
        if (block == 1) {
            service.block(login);
        } else {
            service.unblock(login);
        }
        response.sendRedirect("userManage");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
