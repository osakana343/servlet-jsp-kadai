<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Objects" %>

<html>
    <head>
        <title>Servlet/JSPの基礎を学ぼう</title>
    </head>
    <body>
		   <%
        // Servletからのデータを取得
        String userName = (String) request.getAttribute("userName");
        String userEmail = (String) request.getAttribute("userEmail");
		String userAddress = (String) request.getAttribute("userAddress");
		String userPhone_number = (String) request.getAttribute("userPhone_number");

        // データが存在しない場合は空文字に置き換え
        userName = Objects.toString(userName, "");
        userEmail = Objects.toString(userEmail, "");
		userAddress = Objects.toString(userAddress, "");
		userPhone_number = Objects.toString(userPhone_number, "");
        %>

        <h2>お問い合わせ</h2>
        <form action="<%= request.getContextPath() %>/confirm" method="post">
	        <table>
	            <tr>
	                <td>お名前</td>
	                <td>
	                    <input type="text" name="user_name" value=<%= userName %> >
	                </td>
	            </tr>
	            <tr>
	                <td>メールアドレス</td>
	                <td>
	                     <input type="text" name="user_email" value=<%= userEmail %> >
	                </td>
	            </tr>
	            <tr>
	                <td>住所</td>
	                <td>
	                     <input type="text" name="user_address" value=<%= userAddress %> >
	                </td>
	            </tr>
				 <tr>
	                <td>電話番号</td>
	                <td>
	                     <input type="text" name="user_phone_number" value=<%= userPhone_number %> >
	                </td>
	            </tr>
	        </table>
            <input type="submit" value="送信">
        </form>
    </body>
</html>