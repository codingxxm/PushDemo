package com.xxm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServerSentServlet extends HttpServlet {

    public static int count = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++;
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/event-stream");//设置服务器端事件流
        response.setHeader("Cache-Control","no-cache");//规定不对页面进行缓存
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires",0);
        PrintWriter pw = response.getWriter();
        pw.println("retry: 5000"); //设置请求间隔时间
        pw.println("data: " + "msg:" + count +"\n\n");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
