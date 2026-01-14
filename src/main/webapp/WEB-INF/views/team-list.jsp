<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Команды — Basket League</title>

    <!-- Bootstrap -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet">

    <style>
        body {
            background: #f5f6fa;
        }
    </style>
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<c:if test="${not empty error}">
    <div class="alert alert-danger">
            ${error}
    </div>
</c:if>


<div class="container">

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2>Список команд</h2>
        <c:if test="${sessionScope.user.role == 'ADMIN'}">
        <a href="/teams/add" class="btn btn-primary">
            + Добавить команду
        </a>
        </c:if>
    </div>

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Город</th>
            <th width="180">Действия</th>
            <th>Лого</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="t" items="${teams}">
            <tr>
                <td>${t.id}</td>
                <td>${t.name}</td>
                <td>${t.city}</td>

                <td>
                    <img src="${empty t.logo ? 'https://via.placeholder.com/80x60?text=No+Logo' : t.logo}"
                         width="80"
                         class="img-thumbnail">
                </td>

                <td class="d-flex gap-2">

                    <a href="/teams/players?id=${t.id}"
                       class="btn btn-sm btn-info">
                        Игроки
                    </a>

                    <c:if test="${sessionScope.user.role == 'ADMIN'}">

                    <a href="/teams/edit?id=${t.id}" class="btn btn-sm btn-warning">
                        Изменить
                    </a>

                    <button
                            class="btn btn-sm btn-danger"
                            onclick="confirmDelete(${t.id})">
                        Удалить
                    </button>

                    </c:if>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<!-- JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<script>
    function confirmDelete(id) {
        if (confirm("Удалить команду?")) {
            window.location.href = "/teams/delete?id=" + id;
        }
    }
</script>

</body>
</html>
