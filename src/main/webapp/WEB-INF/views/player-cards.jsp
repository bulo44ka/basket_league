<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Игроки — карточки</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet">

    <style>
        body { background: #f4f6f9; }

        .player-card {
            border-radius: 18px;
            overflow: hidden;
            box-shadow: 0 8px 18px rgba(0,0,0,.08);
            transition: .25s;
        }

        .player-card:hover {
            transform: translateY(-4px);
            box-shadow: 0 14px 26px rgba(0,0,0,.12);
        }

        .player-photo {
            width: 100%;
            height: 220px;
            object-fit: cover;
            background: #ddd;
        }
    </style>
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>


<div class="container mt-4">

    <h3 class="mb-4">Карточки игроков</h3>

    <a href="/players" class="btn btn-secondary mb-3">Табличный вид</a>

    <div class="row g-4">

        <c:forEach items="${players}" var="p">

            <div class="col-md-4 col-lg-3">

                <div class="player-card bg-white">

                    <img
                            class="player-photo"
                            src="${empty p.photo ? 'https://via.placeholder.com/400x250?text=No+Photo' : p.photo}"
                            alt="Фото">

                    <div class="p-3">

                        <h5 class="mb-1">${p.name}</h5>

                        <small class="text-muted">
                            Позиция: ${p.position}
                        </small>

                        <div class="mt-2">
                            <span class="badge bg-primary">Рост: ${p.height}</span>
                            <span class="badge bg-success">Вес: ${p.weight}</span>
                        </div>

                        <c:if test="${sessionScope.user.role == 'ADMIN'}">
                            <div class="mt-3 d-flex gap-2">
                                <a href="/players/edit?id=${p.id}"
                                   class="btn btn-sm btn-warning w-100">
                                    Редактировать
                                </a>

                                <a href="/players/delete?id=${p.id}"
                                   onclick="return confirm('Удалить игрока?')"
                                   class="btn btn-sm btn-danger w-100">
                                    Удалить
                                </a>
                            </div>
                        </c:if>

                    </div>

                </div>

            </div>

        </c:forEach>

        <c:if test="${empty players}">
            <p class="text-muted">Игроков пока нет.</p>
        </c:if>

    </div>

</div>

</body>
</html>
