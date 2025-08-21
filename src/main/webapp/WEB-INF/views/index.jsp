<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>商品查詢</title>
<style>
  body { font-family: Arial, "微軟正黑體"; margin: 32px; }
  .row { margin: 8px 0; }
  .input { width: 360px; height: 36px; border: 3px solid #000; padding: 4px 8px; font-size: 16px; }
  .btn   { height: 51px; border: 3px solid #000; padding: 0 18px; background: #fff; cursor: pointer; }
  table { border-collapse: collapse; margin-top: 16px; min-width: 640px; }
  th, td { border: 3px solid #000; padding: 8px 12px; text-align: left; }
  .muted { color: #777; }
</style>
</head>
<body>

  <h2>搜尋條件框</h2>

  <!-- 表單送到 /search (Servlet) -->
  <form method="get" action="${pageContext.request.contextPath}/search" class="row">
    <input class="input" type="text" name="productName" placeholder="輸入商品關鍵字" value="${fn:escapeXml(productName)}" />
    <button class="btn" type="submit">按鈕</button>
  </form>

  <c:choose>
    <c:when test="${empty products}">
      <p class="muted"> 搜尋出來的資料（目前沒有資料或尚未搜尋）。</p>
    </c:when>
    <c:otherwise>
      <p class="muted"> 搜尋出來的資料，多筆呈現。</p>
      <table>
        <thead>
          <tr><th>ID</th><th>名稱</th><th>價格</th><th>剩餘數量</th></tr>
        </thead>
        <tbody>
          <c:forEach var="product" items="${products}">
            <tr>
              <td>${product.id}</td>
              <td>${product.name}</td>
              <td>$${product.price}</td>
              <td>${product.stock}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:otherwise>
  </c:choose>

</body>
</html>
