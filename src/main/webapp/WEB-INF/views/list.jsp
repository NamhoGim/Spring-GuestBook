<%--
  Created by IntelliJ IDEA.
  User: gimnamho
  Date: 2020/09/21
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>방명록 목록</title>
</head>
<body>

    <h1>방명록</h1>
    <br>방명록 전체 수: ${count}
    <br>
    <br>

    <c:forEach items="${list}" var="guestbook">

        ${guestbook.id}<br>
        ${guestbook.name}<br>
        ${guestbook.content}<br>
        ${guestbook.regdate}<br>

    </c:forEach>
    <br>

    <c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
        <a href="list?start=${pageIndex}">${status.index+1}</a>&nbsp; &nbsp;
    </c:forEach>

    <br>
    <br>
    <form method="post" action="write">
        name: <input type="text" name="name"><br>
        <textarea name="content" rows="6" cols="60"></textarea>
        <br><input type="submit" value="등록">
    </form>
</body>
</html>
