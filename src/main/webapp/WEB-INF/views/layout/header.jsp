<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-dark bg-dark mb-4">
  <div class="container d-flex justify-content-between">

    <a class="navbar-brand" href="/">Basket League</a>

    <div>

      <c:if test="${empty sessionScope.user}">
        <a href="/login" class="btn btn-outline-light me-2">Войти</a>
        <a href="/register" class="btn btn-success">Регистрация</a>
      </c:if>

      <c:if test="${not empty sessionScope.user}">
                <span class="text-light me-3">
                    Привет, ${sessionScope.user.username}
                </span>

        <a href="/logout" class="btn btn-outline-warning">
          Выйти
        </a>
      </c:if>

    </div>

  </div>
</nav>
