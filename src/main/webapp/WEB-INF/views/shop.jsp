<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Магазин</title>

  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

  <style>
    body { background:#f4f6f9; }

    .shop-card {
      border-radius:18px;
      box-shadow:0 8px 18px rgba(0,0,0,.08);
    }
    .shop-img {
      width:100%;
      height:200px;
      object-fit:contain;
    }
  </style>
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<div class="container mt-4">

  <div class="d-flex justify-content-between align-items-center mb-4">
    <h3>Магазин атрибутики</h3>
    <a href="/cart" class="btn btn-primary">🛒 Корзина</a>
  </div>

  <div class="row g-4">

    <c:forEach var="i" items="${items}">
      <div class="col-md-4 col-lg-3">
        <div class="shop-card bg-white p-3 text-center">
          <img src="${i.image}" class="shop-img mb-2">

          <h5>${i.name}</h5>
          <div class="fw-bold text-success">${i.price} ₽</div>

          <a href="/cart/add?id=${i.id}" class="btn btn-primary w-100 mt-2">
            В корзину
          </a>

          <c:if test="${sessionScope.user.role == 'ADMIN'}">
            <a href="/shop/admin?delete=${i.id}"
               class="btn btn-danger w-100 mt-2">
              Удалить
            </a>
          </c:if>
        </div>
      </div>
    </c:forEach>

  </div>

  <c:if test="${sessionScope.user.role == 'ADMIN'}">
    <hr>
    <h4>Добавить товар</h4>

    <form action="/shop/admin" method="post" class="row g-2">
      <div class="col-md-4">
        <input name="name" class="form-control" placeholder="Название">
      </div>
      <div class="col-md-4">
        <input name="image" class="form-control" placeholder="Ссылка на изображение">
      </div>
      <div class="col-md-2">
        <input name="price" class="form-control" placeholder="Цена (₽)">
      </div>
      <div class="col-md-2">
        <button class="btn btn-success w-100">Добавить</button>
      </div>
    </form>
  </c:if>

</div>

</body>
</html>
