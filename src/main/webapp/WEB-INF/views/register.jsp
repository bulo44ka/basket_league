<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Регистрация</title>

  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>

<jsp:include page="/WEB-INF/views/layout/header.jsp"/>

<div class="container mt-4" style="max-width: 450px">

  <h3 class="mb-3">Регистрация</h3>

  <form method="post">

    <div class="mb-3">
      <label class="form-label">Логин</label>
      <input type="text" name="name" class="form-control">
      <small id="userHelp" class="text-danger"></small>
    </div>

    <div class="mb-3">
      <label class="form-label">Пароль</label>
      <input name="password" type="password"
             class="form-control" required>
    </div>

    <button class="btn btn-success w-100">Зарегистрироваться</button>

  </form>

</div>

<script>
  const usernameInput = document.getElementById('username');
  const help = document.getElementById('userHelp');

  usernameInput.addEventListener('blur', () => {

    fetch('/ajax/check-username?username=' + usernameInput.value)
            .then(r => r.json())
            .then(d => {
              if (d.exists) {
                help.textContent = 'Логин уже занят';
              } else {
                help.textContent = '';
              }
            });
  });
</script>

</body>
</html>
