<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавить матч</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet">

    <style>
        body {
            background: #f4f6f9;
        }

        .form-card {
            background: #fff;
            border-radius: 18px;
            box-shadow: 0 8px 18px rgba(0,0,0,.08);
        }
    </style>
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<div class="container mt-4" style="max-width: 700px">

    <h3 class="mb-4">Добавить матч</h3>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
                ${error}
        </div>
    </c:if>

    <form method="post" class="form-card p-4">

        <div class="row">

            <div class="col-md-6 mb-3">
                <label class="form-label">Команда хозяев</label>
                <select name="teamHomeId" class="form-select" required>
                    <c:forEach items="${teams}" var="t">
                        <option value="${t.id}">${t.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-6 mb-3">
                <label class="form-label">Команда гостей</label>
                <select name="teamAwayId" class="form-select" required>
                    <c:forEach items="${teams}" var="t">
                        <option value="${t.id}">${t.name}</option>
                    </c:forEach>
                </select>
            </div>

        </div>

        <div class="mb-3">
            <label class="form-label">Дата и время матча</label>
            <input type="datetime-local"
                   name="date"
                   class="form-control"
                   required>
        </div>

        <div class="mb-3">
            <label class="form-label">Статус матча</label>
            <select name="status" id="status" class="form-select">
                <option value="PLANNED">Запланирован</option>
                <option value="FINISHED">Завершён</option>
            </select>
        </div>

        <!-- Блок счёта -->
        <div id="scoreBlock" class="row" style="display:none">

            <div class="col-md-6 mb-3">
                <label class="form-label">Счёт хозяев</label>
                <input type="number"
                       name="homeScore"
                       class="form-control"
                       min="0">
            </div>

            <div class="col-md-6 mb-3">
                <label class="form-label">Счёт гостей</label>
                <input type="number"
                       name="awayScore"
                       class="form-control"
                       min="0">
            </div>

        </div>

        <div class="d-flex gap-2 mt-3">
            <button class="btn btn-success w-100">
                Сохранить матч
            </button>

            <a href="/matches" class="btn btn-secondary w-100">
                Отмена
            </a>
        </div>

    </form>

</div>

<script>
    const statusSelect = document.getElementById("status");
    const scoreBlock = document.getElementById("scoreBlock");

    function toggleScore() {
        scoreBlock.style.display =
            statusSelect.value === "FINISHED" ? "flex" : "none";
    }

    statusSelect.addEventListener("change", toggleScore);
    toggleScore();
</script>

</body>
</html>
