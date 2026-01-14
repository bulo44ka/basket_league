<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Редактировать команду</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet">
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<div class="container mt-4" style="max-width: 500px">

    <h3>Редактировать команду</h3>

    <form method="post">

        <input type="hidden" name="id" value="${team.id}">

        <div class="mb-3">
            <label class="form-label">Название</label>
            <input name="name" class="form-control" value="${team.name}">
        </div>

        <div class="mb-3">
            <label class="form-label">Город</label>
            <input name="city" class="form-control" value="${team.city}">
        </div>

        <div class="mb-3">
            <label class="form-label">Ссылка на логотип</label>
            <input name="logo" class="form-control" value="${team.logo}">
        </div>

        <button class="btn btn-success">Сохранить</button>

    </form>

</div>

</body>
</html>
