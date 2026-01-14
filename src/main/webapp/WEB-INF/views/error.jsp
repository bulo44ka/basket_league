<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Ошибка</title>

  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>

<div class="container mt-5 text-center">

  <h2 class="text-danger mb-3">Произошла ошибка</h2>

  <p class="text-muted">
    ${errorMessage != null ? errorMessage : "Что-то пошло не так"}
  </p>

  <a href="/" class="btn btn-primary mt-3">На главную</a>

</div>

</body>
</html>
