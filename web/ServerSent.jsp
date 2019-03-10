<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/11
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        var source = new EventSource("/ServerSentServlet");//创建一个新的 EventSource对象，
        source.onmessage = function (evt) {//每接收到一次更新，就会发生 onmessage事件
            var newChild = document.createElement("p");
            newChild.innerHTML = evt.data;
            document.getElementById("push").appendChild(newChild);
        }
    </script>
</head>
<body>
    <div id="push"></div>
</body>
</html>
