<%--
  Created by IntelliJ IDEA.
  User: xuxm
  Date: 2019/2/23
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>pushPage</title>
  <script type="text/javascript">
    function loadData(msg) {
      var newChild = document.createElement("p");
      newChild.innerHTML = msg;
      document.getElementById("push").appendChild(newChild);
    }
  </script>
</head>
<body>
<div id="push"></div>
<iframe src="/LongConnServlet" frameborder="0" name="longConn"></iframe>
</body>
</html>
