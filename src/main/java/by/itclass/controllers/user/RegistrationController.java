package by.itclass.controllers.user;

import by.itclass.constants.ApplicationConstants;
import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.itclass.constants.ApplicationConstants.USER_NOT_REGISTERED;
import static by.itclass.constants.JspConstants.*;

@WebServlet(urlPatterns = ApplicationConstants.REGISTRATION_CONTROLLER)
public class RegistrationController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM);
        String name = req.getParameter(NAME_PARAM);
        String password = req.getParameter(PASS_PARAM);
        String email = req.getParameter(EMAIL_PARAM);
        User user = new User(login, name, email);
        if (userService.addUser(user, password)){
            redirect(resp, LOGIN_JSP);
        } else {
            forward(req, resp, REGISTRATION_JSP, USER_NOT_REGISTERED);
        }
    }
}
