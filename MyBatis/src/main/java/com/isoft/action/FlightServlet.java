package com.isoft.action;

import com.google.gson.Gson;
import com.isoft.dao.FlightInfoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FlightServlet",urlPatterns = "/flightServlet")
public class FlightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlightInfoImpl flightInfo = new FlightInfoImpl();
        List<Map<String,String>> allFlightInfo = flightInfo.findAllFlightInfo();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        System.out.println(allFlightInfo);
        Gson gson = new Gson();
        out.print(gson.toJson(allFlightInfo));
        out.close();
    }
}
