package com.xxm;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/ws")
public class MyWebSocket {

    private Session session;

    public MyWebSocket() {

    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println("someone connect");
        int count = 1;
        while (count<=5){
            //睡眠时间模拟业务操作等待时间
            double random = Math.round(Math.random()*10);
            long sleepTime = new Double(random).longValue();
            try {
                Thread.sleep(sleepTime*1000);
                session.getBasicRemote().sendText("msg:" + count +" from server after" + sleepTime + " seconds");
            }catch (Exception e){
                e.printStackTrace();
            }
            count++;
        }

    }

    @OnError
    public void onError(Throwable t){
        System.out.println("something error");
    }
}
