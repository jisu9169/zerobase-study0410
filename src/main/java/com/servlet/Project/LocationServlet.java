package com.servlet.Project;

import com.db.DbConnection;
import com.wifi.History;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LocationServlet", value = "/location-servlet")
public class LocationServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "시작합니다 시작해요";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");

        if (request.getParameter("isDeleted") != null && "true".equals(request.getParameter("isDeleted"))) {
            request.setAttribute("alertMessage", "삭제가 완료되었습니다.");
        }
        List<History.row> al = DbConnection.HistoryList();
        request.setAttribute("rows",al);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("/history.jsp");

        requestDispatcher.forward(request,response);
    }

    public void destroy() {
    }
}