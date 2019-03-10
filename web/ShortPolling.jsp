<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/8
  Time: 0:04
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
            setInterval(function () {
                getMsg(function (res) {
                    $("#push").append("<p>" + res +"</p>");
                })
            },10000);
        });

        function getMsg(handler){
            $.ajax({
                url:"/ShortPollingServlet",
                type:"post",
                success:function (res) {
                    handler(res)
                }
            });
        }
    </script>
</body>
</html>
