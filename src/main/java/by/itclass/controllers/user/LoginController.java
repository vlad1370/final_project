package by.itclass.controllers.user;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

import static by.itclass.constants.ApplicationConstants.LOGIN_CONTROLLER;
import static by.itclass.constants.ApplicationConstants.USER_NOT_FOUND;
import static by.itclass.constants.JspConstants.*;


@WebServlet (name = "loginController", urlPatterns = LOGIN_CONTROLLER)
public class LoginController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM);
        String password = req.getParameter(PASS_PARAM);

        User user = userService.getUser(login, password);
        if (!Objects.isNull(user)){
            HttpSession session = req.getSession();
            session.setAttribute(USER_ATTR, user);
            forward(req, resp, HOME_JSP);
        } else {
            forward(req, resp, LOGIN_JSP, USER_NOT_FOUND);
        }
    }
}
