<%@ page import="dao.BoardDao" %>
<%@ page import="dto.BoardDto" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">

function check(){
    var flag = 0;

    if(document.form1.COMMENT.value == ""){
        flag = 1;
    }

    if(flag){
        window.alert('コメントを入力してください');
        return false; // 送信を中止
    }
    else{
        return true; // 送信を実行
    }
}
</script>

<title>MyBoard</title>
</head>
<body>
<div align="left">
	<h1>掲示板</h1>

	<form action="result" method="post" name="form1" onSubmit="return check()">
		<div align="left"><font color="red">※</font><font>は必須項目</font></div>
		<table border="1">
		<tr>
		<th>
		<label for="name">名前</label>
		</th>
		<td>
		<input type="text" name="NAME" size="40" placeholder="※匿名も可">
		</td>
		</tr>
		<tr>
		<th>
		<label for="name">コメント<font color="red">※</font></label>
		<td>
		<textarea name="COMMENT" rows="4" cols="50" maxlength="250" ></textarea>
		</td>
		</tr>
		</table>
		<p></p>
		<button type="submit">投稿</button>
		<button type="reset">入力リセット</button>
	</form>
	<p></p>
	<table border="1">
	<tr>
	<th>ID</th>
	<th>名前</th>
	<th>コメント</th>
	<th>投稿日時</th>
	</tr>

	<%
	dao.BoardDao dao = new dao.BoardDao();
			List<dto.BoardDto> dtoDBList = dao.findAll();
			if(dtoDBList != null) {
		for(int i = 0; i < dtoDBList.size(); i++){
			dto.BoardDto dto = dtoDBList.get(i);
	%>
	<tr>
	<td><%=dto.getId()%></td>
	<td><%=dto.getName()%></td>
	<td><%=dto.getComment()%></td>
	<td><%=dto.getTime()%></td>
	</tr>
		<%
		}
		%>
	<%
	}
	%>
	</table>

	<%
	if(dtoDBList != null) {
			for(int i = 0; i < dtoDBList.size(); i++){
		dto.BoardDto dto = dtoDBList.get(i);
	%>

	<p>ID:<%= dto.getId() %>
	名前:<%= dto.getName() %>
	投稿日時:<%= dto.getTime() %></p>
	<p>　<%= dto.getComment() %></p>

		<% } %>
	<% } %>

</div>
</body>
</html>