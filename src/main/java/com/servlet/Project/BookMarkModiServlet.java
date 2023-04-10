package com.servlet.Project;

import com.db.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookMarkListServlet", value = "/bookmarklist-servlet")
public class BookMarkModiServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "시작합니다 시작해요";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=1;
        String bookmark_name = request.getParameter("bookmark_name");
        int Sequence = Integer.parseInt(request.getParameter("Sequence"));
        DbConnection.DbBookMarkModi(id, bookmark_name, Sequence);
        System.out.println("수정완료");

        response.sendRedirect(request.getContextPath() + "/bookmarklist-servlet");
    }


    public void destroy() {
    }
}