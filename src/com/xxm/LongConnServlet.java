package com.xxm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LongConnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag = true;
        int i = 0;
        while (flag){
            try {
                //模拟每1秒查询一次数据库，看是否有新的消息可以推送
                Thread.sleep(1*1000);
            }catch (Exception e){
                e.printStackTrace();
            }

            String pushMsg = "push msg : " + i;
            response.setContentType("text/html;charset=GBK");
            response.getWriter().write("<script type='text/javascript'>parent.loadData('" + pushMsg + "')</script>");
            response.flushBuffer();
            i++;
            if(i==5){
                flag = false;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
