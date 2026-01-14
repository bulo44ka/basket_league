<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Матчи</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body { background: #f4f6f9; }

        .match-card {
            border-radius: 18px;
            background: #fff;
            box-shadow: 0 8px 18px rgba(0,0,0,.08);
            transition: .25s;
        }

        .match-card:hover {
            transform: translateY(-4px);
            box-shadow: 0 14px 26px rgba(0,0,0,.12);
        }

        .team-logo {
            width: 60px;
            height: 60px;
            object-fit: contain;
        }

        .score {
            font-size: 28px;
            font-weight: 700;
        }
    </style>
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<div class="container mt-4">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h3>Матчи</h3>

        <c:if test="${sessionScope.user.role == 'ADMIN'}">
            <a href="/matches/add" class="btn btn-success">+ Добавить матч</a>
        </c:if>
    </div>

    <div class="row g-4">

        <c:forEach var="m" items="${matches}">
            <div class="col-md-6 col-lg-4">

                <div class="match-card p-3">

                    <div class="text-center text-muted mb-2">
                            ${m.matchDate}
                    </div>

                    <div class="d-flex justify-content-between align-items-center">

                        <!-- HOME -->
                        <div class="text-center">
                            <img class="team-logo"
                                 src="${empty teamMap[m.teamHomeId].logo
                                        ? 'https://via.placeholder.com/80'
                                        : teamMap[m.teamHomeId].logo}">
                            <div>${teamMap[m.teamHomeId].name}</div>
                        </div>

                        <!-- SCORE -->
                        <div class="text-center">
                            <c:if test="${m.status == 'FINISHED'}">
                                <div class="score">${m.homeScore} : ${m.awayScore}</div>
                            </c:if>

                            <c:if test="${m.status == 'PLANNED'}">
                                <span class="badge bg-secondary">Запланирован</span>
                            </c:if>
                        </div>

                        <!-- AWAY -->
                        <div class="text-center">
                            <img class="team-logo"
                                 src="${empty teamMap[m.teamAwayId].logo
                                        ? 'https://via.placeholder.com/80'
                                        : teamMap[m.teamAwayId].logo}">
                            <div>${teamMap[m.teamAwayId].name}</div>
                        </div>

                    </div>

                    <c:if test="${sessionScope.user.role == 'ADMIN'}">
                        <div class="d-flex gap-2 mt-3">
                            <a href="/matches/edit?id=${m.id}"
                               class="btn btn-warning w-100">Редактировать</a>

                            <a href="/matches/delete?id=${m.id}"
                               onclick="return confirm('Удалить матч?')"
                               class="btn btn-danger w-100">Удалить</a>
                        </div>
                    </c:if>

                </div>

            </div>
        </c:forEach>

        <c:if test="${empty matches}">
            <p class="text-muted">Матчей пока нет.</p>
        </c:if>

    </div>

</div>

</body>
</html>
