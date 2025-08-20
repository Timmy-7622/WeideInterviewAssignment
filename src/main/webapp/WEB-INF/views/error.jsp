<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html><html><body>
<h3>發生錯誤</h3>
<pre><%= request.getAttribute("error") %></pre>
<a href="<%=request.getContextPath()%>/">回首頁</a>
</body></html>
