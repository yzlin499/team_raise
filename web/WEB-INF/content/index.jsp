<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="top.yzlin.teamraise.entity.MemberInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>flag集资平台</title>
    </head>
    <body>
        <table border="1" align="left" width="120" cellspacing="1">
            <caption><b>成员表</b></caption>
            <tr><th>成员</th></tr>
            <c:forEach items="${requestScope.memberInfoList}" var="memberInfo">
                <tr><th><a href="/${memberInfo.id}">${memberInfo.name}</a></th></tr>
            </c:forEach>
        </table>
    </body>
</html>
