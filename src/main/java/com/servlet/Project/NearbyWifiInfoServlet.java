package com.servlet.Project;

import com.db.DbConnection;
import com.wifi.DataValue;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NearbyWifiInfoServlet", value = "/nearbyWifiInfo-servlet")
public class NearbyWifiInfoServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "시작합니다 시작해요";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        Double lat = Double.valueOf(request.getParameter("lat"));
        Double lnt = Double.valueOf(request.getParameter("lnt"));


        List<DataValue.row> al = DbConnection.DistanceAlignment(lat, lnt);


        request.setAttribute("rows", al);




        RequestDispatcher requestDispatcher =request.getRequestDispatcher("/index.jsp");

        requestDispatcher.forward(request,response);

    }

    public void destroy() {
    }
}