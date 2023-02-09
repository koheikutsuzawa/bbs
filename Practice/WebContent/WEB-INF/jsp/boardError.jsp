<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBoard</title>
</head>

	<body>
        <h1><font color="red">掲示板 投稿エラー</font></h1>
        <p><font color="red">入力漏れがあります。</font></p>
        <% String name = (String)request.getAttribute("NAME"); %>
        <% String comment = (String)request.getAttribute("COMMENT"); %>
        <p>名前：<%= name %></p>
        <p>コメント：<%= comment %></p>

		<p><a href="/Practice/board">戻る</a></p>
    </body>
</html>