package com.ggz.controller;

import com.ggz.model.Peer;
import com.sunnyd.database.Manager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;


public class Profile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get all profile input
        int id = Integer.parseInt(request.getParameter("id"));
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String website = request.getParameter("personal_website");
        String email = request.getParameter("email");


        // here we should validate the input...

        // check if user already exists
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("firstName", first_name);
        map.put("lastName", last_name);
        map.put("personalWebsite", website);
        map.put("email", email);


        String redirect = "/error";
        try {

            System.out.println("true or fals?" + Manager.update(id,"peers",map));
            redirect = "/profile";
            Peer peer = new Peer(Manager.find(id, "peers"));
            HttpSession session = request.getSession();
            session.setAttribute("user", peer);
            response.sendRedirect(redirect);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // forward to registration jsp
//        ServletContext context = getServletContext();
//        RequestDispatcher dispatcher = context.getRequestDispatcher("/view/register.jsp");
//        dispatcher.forward(request, response);

    }
}
