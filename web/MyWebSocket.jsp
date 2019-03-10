<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/11
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
    <div id="push"></div>
</body>
<script>
    $(function () {
        var webSocket = new WebSocket("ws://localhost:8080/ws");
        webSocket.onmessage = function (ev) {
            $("#push").append("<p>" + ev.data +"</p>");
        }
    })
</script>
</html>
