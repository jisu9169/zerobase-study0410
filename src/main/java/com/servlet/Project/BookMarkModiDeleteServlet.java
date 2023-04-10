package com.servlet.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookMarkListServlet", value = "/bookmarklist-servlet")
public class BookMarkModiDeleteServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "시작합니다 시작해요";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String modi ="";
        String delete="";
        int id = Integer.parseInt(request.getParameter("id"));
        if(null==request.getParameter("modi") && null==request.getParameter("delete")){
            System.out.println("둘다 널");
        }else if(null != request.getParameter("modi")){
            modi = request.getParameter("modi");
        }else if(null != request.getParameter("delete")){
            delete = request.getParameter("delete");
        }



        System.out.println("삭제 완료");

        response.sendRedirect(request.getContextPath() + "bookmarkgroop.jsp");
    }


    public void destroy() {
    }
}