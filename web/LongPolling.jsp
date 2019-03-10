<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/10
  Time: 23:22
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
    <script>
        $(function () {
            getMsg();
        });

        function getMsg() {
            $.ajax({
                url:"/LongPollingServlet",
                type:"post",
                success:function (res) {
                    $("#push").append("<p>" + res +"</p>");
                    getMsg();
                }
            });
        }
    </script>
</body>
</html>
