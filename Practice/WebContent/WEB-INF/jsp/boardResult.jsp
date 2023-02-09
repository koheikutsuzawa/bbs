<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBoard</title>
</head>
	<h1>掲示板 投稿完了</h1>
<body>
        <h1>投稿内容</h1>
        <% String name = (String)request.getAttribute("NAME"); %>
        <% String comment = (String)request.getAttribute("COMMENT"); %>

        <p>名前：<%= name %></p>
        <p>コメント：<%= comment %></p>

		<p><a href="/Practice/board">戻る</a></p>
    </body>
</html>