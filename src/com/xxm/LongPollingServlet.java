package com.xxm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LongPollingServlet extends HttpServlet {

    public static int count = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++;
        //睡眠时间模拟业务操作等待时间
        double random = Math.round(Math.random()*10);
        long sleepTime = new Double(random).longValue();
        try{
            Thread.sleep(sleepTime*1000);
            response.getWriter().print("msg:" + count + " after " + sleepTime + "seconds servicing");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
