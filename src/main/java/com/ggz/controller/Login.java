package com.ggz.controller;

import com.ggz.model.Peer;
import com.sunnyd.database.Manager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
        System.out.println("gets here");
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userName", request.getParameter("username"));
        map.put("password", request.getParameter("password"));

        String redirect = "/error";
        try {
            ArrayList<HashMap<String, Object>> matches = Manager.findAll("peers", map);

            if (matches.size() == 1){ // means found exactly 1 user with that username and password
                HashMap<String, Object> match = matches.get(0); // get this hashmap from the arraylist
                Peer peer = new Peer(match);
                // store the peer obj in session
                HttpSession session = request.getSession();
                session.setAttribute("user", peer);
                session.setMaxInactiveInterval(259200); // 3 days in secs
                //request.setAttribute("user", peer);
                redirect = "/profile";
            }

            response.sendRedirect(redirect);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
