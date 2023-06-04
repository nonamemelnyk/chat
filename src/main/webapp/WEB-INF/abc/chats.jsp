<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Chats title</title>
</head>
<body>
<div>
    <h2>Новости <br> Hello ${user.name}.</h2>
    <a href="/">Главная</a>

    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Chat List</th>
                </tr>
                </thead>
                <tbody id="greetings">
                <tr>
                    <th>id</th>
                    <th>name</th>
                </tr>
                <c:forEach items="${chats}" var="chat" varStatus="status">
                    <tr>
                        <td>
                            <a href="/view/chats/${chat.id}"> ${chat.id} </a>
                        </td>
                        <td>${chat.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>