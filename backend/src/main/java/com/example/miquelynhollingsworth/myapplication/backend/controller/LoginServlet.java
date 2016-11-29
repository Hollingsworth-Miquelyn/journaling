/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.example.miquelynhollingsworth.myapplication.backend.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import com.example.miquelynhollingsworth.myapplication.backend.model.Users;
import com.example.miquelynhollingsworth.myapplication.backend.service.LoginService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginService loginService = new LoginService();
        boolean result = loginService.authenticateUser(username, password);
        Users user = loginService.getUserByUsername(username);
        if(result == true){
            request.getSession().setAttribute("user", user);
            response.sendRedirect("com.miquelynhollingsworth.journaling.UserActivity");
        }
        else{
            //connect error on android app
            response.sendRedirect("error.jsp");
        }
    }

}