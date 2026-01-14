<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Basket League</title>

  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

  <style>
    body { background:#f4f6f9; }

    .card {
      border-radius:18px;
      box-shadow:0 8px 18px rgba(0,0,0,.08);
      transition:.25s;
    }
    .card:hover {
      transform:translateY(-4px);
      box-shadow:0 14px 26px rgba(0,0,0,.12);
    }
  </style>
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<div class="container mt-4">

  <div class="text-center mb-5">
    <h2>🏀 Basket League</h2>
    <p class="text-muted">Система управления баскетбольной лигой</p>
  </div>

  <div class="row g-4">

    <div class="col-md-3">
      <div class="card p-4 text-center bg-white">
        <h4>Команды</h4>
        <p class="text-muted">Все команды</p>
        <a href="/teams" class="btn btn-primary w-100">Перейти</a>
      </div>
    </div>

    <div class="col-md-3">
      <div class="card p-4 text-center bg-white">
        <h4>Игроки</h4>
        <p class="text-muted">Все игроки</p>
        <a href="/players" class="btn btn-primary w-100">Перейти</a>
      </div>
    </div>

    <div class="col-md-3">
      <div class="card p-4 text-center bg-white">
        <h4>Матчи</h4>
        <p class="text-muted">Календарь матчей</p>
        <a href="/matches" class="btn btn-primary w-100">Перейти</a>
      </div>
    </div>

    <div class="col-md-3">
      <div class="card p-4 text-center bg-white">
        <h4>Магазин</h4>
        <p class="text-muted">Атрибутика</p>
        <a href="/shop" class="btn btn-success w-100">Перейти</a>
      </div>
    </div>

  </div>

</div>

</body>
</html>
