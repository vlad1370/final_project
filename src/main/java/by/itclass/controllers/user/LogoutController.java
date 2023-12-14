package by.itclass.controllers.user;

import by.itclass.controllers.AbstractController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static by.itclass.constants.ApplicationConstants.LOGOUT_CONTROLLER;
import static by.itclass.constants.JspConstants.LOGIN_JSP;

@WebServlet(name = "logoutController", urlPatterns = LOGOUT_CONTROLLER)
public class LogoutController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        redirect(resp, LOGIN_JSP);
    }
}
