package com.servlet.Project;

import com.db.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookMarkGroopServlet", value = "/bookmarkgroop-servlet")
public class BookMarkGroopServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "시작합니다 시작해요";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");

        String name = request.getParameter("bookmark_group_name");
        String wifiname = request.getParameter("wifiname");

            DbConnection.DbBookMarkInsert(name,wifiname);



        response.sendRedirect(request.getContextPath() + "/bookmarklist-servlet");
    }


    public void destroy() {
    }
}