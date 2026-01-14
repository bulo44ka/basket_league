<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Редактировать игрока</title>

  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>


<div class="container mt-4">

  <h3>Редактировать игрока</h3>

  <form method="post" enctype="multipart/form-data">

    <input type="hidden" name="id" value="${player.id}">
    <input type="hidden" name="oldPhoto" value="${player.photo}">

    <div class="mb-3">
      <label class="form-label">Имя</label>
      <input name="name" class="form-control" value="${player.name}">
    </div>

    <div class="mb-3">
      <label class="form-label">Позиция</label>
      <input name="position" class="form-control" value="${player.position}">
    </div>

    <div class="mb-3">
      <label class="form-label">Команда</label>

      <select name="teamId" class="form-select">
        <c:forEach var="t" items="${teams}">
          <option value="${t.id}"
            ${t.id == player.teamId ? 'selected' : ''}>
              ${t.name} (${t.city})
          </option>
        </c:forEach>
      </select>
    </div>

    <div class="row">
      <div class="col">
        <label class="form-label">Рост (см)</label>
        <input type="number" name="height"
               class="form-control"
               value="${player.height}">
      </div>

      <div class="col">
        <label class="form-label">Вес (кг)</label>
        <input type="number" name="weight"
               class="form-control"
               value="${player.weight}">
      </div>
    </div>

    <div class="mb-3 mt-3">
      <label class="form-label">Фото</label><br>

      <c:if test="${not empty player.photo}">
        <img src="${player.photo}" width="120" class="img-thumbnail mb-2"><br>
      </c:if>

      <input type="file" name="photo" class="form-control">
    </div>

    <button class="btn btn-success">Сохранить</button>
    <a href="/players" class="btn btn-secondary">Назад</a>

  </form>

</div>

</body>
</html>
