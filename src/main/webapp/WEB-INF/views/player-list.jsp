<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Игроки — Basket League</title>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet">
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>


<div class="container mt-4">

    <div class="d-flex justify-content-between mb-3">
        <h3>Список игроков</h3>

        <a href="/players/add" class="btn btn-primary">
            + Добавить игрока
        </a>

        <a href="/players/cards" class="btn btn-outline-primary mb-3">
            Карточки игроков
        </a>


    </div>

    <!-- 🔎 Поиск -->
    <div class="mb-3">
        <input id="search" class="form-control"
               placeholder="Поиск по имени...">
    </div>

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Фото</th>
            <th>Имя</th>
            <th>Позиция</th>
            <th>Команда (ID)</th>
            <th>Рост</th>
            <th>Вес</th>
            <th width="120">Действия</th>
        </tr>
        </thead>

        <tbody id="playersBody">
        <c:forEach var="p" items="${players}">
            <tr>
                <td>${p.id}</td>

                <td>
                    <c:if test="${not empty p.photo}">
                        <img src="${p.photo}" width="70" class="img-thumbnail">
                    </c:if>
                </td>

                <td>${p.name}</td>
                <td>${p.position}</td>
                <td>${p.teamId}</td>
                <td>${p.height}</td>
                <td>${p.weight}</td>

                <td>
                    <c:if test="${sessionScope.user.role == 'ADMIN'}">
                    <a href="/players/edit?id=${p.id}"
                       class="btn btn-sm btn-warning">
                        Редактировать
                    </a>

                    <button class="btn btn-sm btn-danger"
                            onclick="confirmDelete(${p.id})">
                        Удалить
                    </button>
                    </c:if>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<script>
    function confirmDelete(id) {
        if (confirm("Удалить игрока?")) {
            window.location.href = "/players/delete?id=" + id;
        }
    }
</script>

<script>
    const input = document.getElementById("search");
    const body = document.getElementById("playersBody");

    input.addEventListener("input", async function () {

        const text = input.value;

        const res = await fetch("/players/search?q=" + encodeURIComponent(text));
        const players = await res.json();

        body.innerHTML = "";

        players.forEach(p => {

            body.innerHTML += `
                <tr>
                    <td>\${p.id}</td>

                    <td>
                        \${p.photo
                            ? '<img src="' + p.photo + '" width="70" class="img-thumbnail">'
                            : ''
                        }
                    </td>

                    <td>\${p.name ?? ""}</td>
                    <td>\${p.position ?? ""}</td>
                    <td>\${p.teamId ?? ""}</td>
                    <td>\${p.height ?? ""}</td>
                    <td>\${p.weight ?? ""}</td>

                    <td>
                        <button class="btn btn-sm btn-danger"
                                onclick="confirmDelete(\${p.id})">
                            Удалить
                        </button>
                    </td>
                </tr>
            `;
        });

    });
</script>



</body>
</html>
