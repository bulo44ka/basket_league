<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Игроки команды</title>

  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>


<div class="container mt-4">

  <h3>${team.name} — игроки</h3>
  <p class="text-muted">${team.city}</p>

  <a href="/teams" class="btn btn-secondary mb-3">Назад к командам</a>

  <table class="table table-bordered align-middle">
    <thead class="table-light">
    <tr>
      <th>#</th>
      <th>Имя</th>
      <th>Позиция</th>
      <th>Рост</th>
      <th>Вес</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach items="${players}" var="p">
      <tr>
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.position}</td>
        <td>${p.height}</td>
        <td>${p.weight}</td>
      </tr>
    </c:forEach>

    <c:if test="${empty players}">
      <tr>
        <td colspan="5" class="text-center text-muted">
          В этой команде пока нет игроков
        </td>
      </tr>
    </c:if>

    </tbody>
  </table>

</div>

</body>
</html>
