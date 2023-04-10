package com.servlet.Project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookMarkServlet", value = "/bookmark-servlet")
public class BookMarkServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "시작합니다 시작해요";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");


        String distance = (String) request.getParameter("distance");
        request.setAttribute("distance", distance);

        String x_swifi_sub_nm = request.getParameter("x_swifi_sub_nm");
        request.setAttribute("x_swifi_sub_nm", x_swifi_sub_nm);

        String addr = request.getParameter("addr");
        request.setAttribute("addr", addr);

        String tel_no = request.getParameter("tel_no");
        request.setAttribute("tel_no", tel_no);

        String work_dttm = request.getParameter("work_dttm");
        request.setAttribute("work_dttm", work_dttm);

        String work_group = request.getParameter("work_group");
        request.setAttribute("work_group", work_group);

        String work_nm = request.getParameter("work_nm");
        request.setAttribute("work_nm", work_nm);

        String work_yadm_nm = request.getParameter("work_yadm_nm");
        request.setAttribute("work_yadm_nm", work_yadm_nm);

        String work_tel = request.getParameter("work_tel");
        request.setAttribute("work_tel", work_tel);

        String dist_target = request.getParameter("dist_target");
        request.setAttribute("dist_target", dist_target);

        String sh_addr = request.getParameter("sh_addr");
        request.setAttribute("sh_addr", sh_addr);

        String sh_addr2 = request.getParameter("sh_addr2");
        request.setAttribute("sh_addr2", sh_addr2);

        String gis_x_co = request.getParameter("gis_x_co");
        request.setAttribute("gis_x_co", gis_x_co);

        String gis_y_co = request.getParameter("gis_y_co");
        request.setAttribute("gis_y_co", gis_y_co);

        String app_nm = request.getParameter("app_nm");
        request.setAttribute("app_nm", app_nm);

        String un_nm = request.getParameter("un_nm");
        request.setAttribute("un_nm", un_nm);

        String disp_yn = request.getParameter("disp_yn");
        request.setAttribute("disp_yn", disp_yn);






        RequestDispatcher requestDispatcher =request.getRequestDispatcher("/bookmark.jsp");

        requestDispatcher.forward(request,response);
    }


    public void destroy() {
    }
}