<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Войти в библиотеку</title>
    <link rel="stylesheet" href="styles/loginStyle.css" type="text/css">
    <style>
        div {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <div class="loginBlock">
        <div class="hor">
            <div class="vert">
                <div class="hor">
                    <div class="vert">
                        <div class="hor">
                            <h2>
                                Добро пожаловать в онлайн-библиотеку
                            </h2>
                            <img alt="book" src="images/welcomeBook.png" width="300px" align="center" />
                            <p>
                                У нас Вы найдете огромное количество разножанровой литературы
                                на любой вкус. Наша библиотека удовлетворит потребности
                                самых требовательных книгоманов!
                            </p>
                            <h3>
                                Пожалуйста, авторизируйтесь<br>для продолжения работы с библиотекой.
                            </h3>
                            <form name="loginForm" action="pages/main.jsp" method="post">
                                <table>
                                    <tr>
                                        <td>
                                            Логин:
                                        </td>
                                        <td>
                                            <input type="text" name="username"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Пароль:
                                        </td>
                                        <td>
                                            <input type="password" name="password"/>
                                        </td>
                                    </tr>
                                </table>
                                <input type="submit" value="Войти" style="display: block; margin: auto"/>
                            </form>
                            <p align="center">Еще не зарегистрированы? Тогда Вам <a href="pages/index.jsp">сюда</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
