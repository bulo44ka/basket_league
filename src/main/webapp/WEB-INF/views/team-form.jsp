<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Добавить команду</title>

  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<div class="container mt-4" style="max-width: 600px">

  <h3 class="mb-3">Добавить команду</h3>

  <form method="post" enctype="multipart/form-data">

    <div class="mb-3">
      <label class="form-label">Название команды</label>
      <input name="name" class="form-control" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Город</label>
      <input name="city" class="form-control" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Логотип команды</label>
      <input type="file" name="logo" class="form-control">
    </div>

    <button class="btn btn-success w-100">Сохранить</button>

  </form>

</div>

</body>
</html>
