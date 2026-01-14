<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Корзина</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<div class="container mt-4">

  <h3>Корзина</h3>

  <c:if test="${not empty sessionScope.success}">
    <div class="alert alert-success">${sessionScope.success}</div>
    <c:remove var="success" scope="session"/>
  </c:if>

  <table class="table">
    <tr>
      <th>Товар</th><th>Цена</th><th>Кол-во</th><th>Сумма</th>
    </tr>

    <c:set var="total" value="0"/>

    <c:forEach var="c" items="${sessionScope.cart}">
      <tr>
        <td>${c.item.name}</td>
        <td>${c.item.price} ₽</td>
        <td>
          <form action="/cart/update" method="post" class="d-flex">
            <input type="hidden" name="id" value="${c.item.id}">
            <input name="qty" value="${c.quantity}" class="form-control w-50">
            <button class="btn btn-sm btn-primary">OK</button>
          </form>
        </td>
        <td>${c.item.price * c.quantity} ₽</td>
        <c:set var="total" value="${total + (c.item.price * c.quantity)}"/>
      </tr>
    </c:forEach>

  </table>

  <h4>Итого: ${total} ₽</h4>

  <form action="/cart/checkout" method="post">
    <button class="btn btn-success">Оформить заказ</button>
  </form>

</div>
</body>
</html>
