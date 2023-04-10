package com.servlet.Project;

import com.db.DbConnection;
import com.wifi.BookMarkDataValue;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookMarkListServlet", value = "/bookmarklist-servlet")
public class BookMarkListServlet extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");


        List<BookMarkDataValue.row> al=DbConnection.BookMarkList();
        request.setAttribute("rows",al);

        RequestDispatcher requestDispatcher =request.getRequestDispatcher("bookmarkgroop.jsp");

        requestDispatcher.forward(request,response);
    }


    public void destroy() {
    }
}