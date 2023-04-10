package com.servlet.Project;

import com.db.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LocationDeleteServlet", value = "/locationdelete-servlet")
public class LocationDeleteServlet extends HttpServlet {

    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        System.out.printf("삭제요청 아이디 %d%n", id);
        DbConnection.DbHistoryDeleteTable(id);
        System.out.println("삭제 완료");

        response.sendRedirect(request.getContextPath() + "/location-servlet?isDeleted=true");
    }

    public void destroy() {
    }
}