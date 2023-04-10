package com.servlet.Project;

import com.wifi.SeoulWifiData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OpenApiServlet", value = "/openApi-servlet")
public class OpenApiServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "시작합니다 시작해요";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");

        SeoulWifiData seoulWifiData = new SeoulWifiData();


        try {


            seoulWifiData.SeoulDbCommit();
            response.getWriter().println("<script>alert('데이터베이스 저장에 성공하였습니다.'); location.href='/Project_war_exploded/home-servlet';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}