<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Вход</title>

  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<div class="container mt-4" style="max-width: 420px">

  <h3 class="mb-3">Авторизация</h3>

  <!-- показываем alert ТОЛЬКО если есть ошибка -->
  <c:if test="${not empty error}">
    <div class="alert alert-danger">
        ${error}
    </div>
  </c:if>

  <form method="post">

    <div class="mb-3">
      <label class="form-label">Логин</label>
      <input name="username" class="form-control" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Пароль</label>
      <input name="password" type="password" class="form-control" required>
    </div>

    <button class="btn btn-primary w-100">Войти</button>

  </form>

</div>

</body>
</html>
