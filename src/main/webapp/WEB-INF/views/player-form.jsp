<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавить игрока</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet">
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<div class="container mt-4" style="max-width: 600px">

    <h3 class="mb-3">Добавить игрока</h3>

    <form method="post" enctype="multipart/form-data">

        <div class="mb-3">
            <label class="form-label">Имя</label>
            <input type="text" name="name" class="form-control">
        </div>

        <div class="mb-3">
            <label class="form-label">Позиция</label>
            <input name="position" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Команда</label>
            <select name="teamId" class="form-select" required>
                <option value="">-- выберите команду --</option>

                <c:forEach items="${teams}" var="t">
                    <option value="${t.id}">
                            ${t.name} (${t.city})
                    </option>
                </c:forEach>

            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Рост (см)</label>
            <input type="number" name="height" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Вес (кг)</label>
            <input type="number" name="weight" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Фото игрока</label>
            <input type="file" name="photo" class="form-control">
        </div>

        <button class="btn btn-success w-100">Сохранить</button>

    </form>

</div>

</body>
</html>
