<%@ page import="java.util.List" %>
<%@ page import="bean.Genre" %>
<%@ page import="bean.GenreList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Библиотека</title>
    <link rel="stylesheet" href="../styles/mainStyle.css" type="text/css" />
</head>
<body>

<% request.setCharacterEncoding("UTF-8"); %>
<div class="container">
    <div class="genresBack"></div>
    <div class="genres">
        <h4>Книги по жанрам:</h4>
        <ul>
            <%
                GenreList genreList = new GenreList();
                for (Genre genre : genreList.getGenreList()) {
            %>
                <li class="genreItem"><%=genre.getName()%></li>
            <%}%>

            <%--code below doesn't work--%>

            <%--<jsp:useBean id="genreList" class="bean.GenreList" scope="session"/>
            <c:forEach var="genre" items="${genreList.getGenreList()}">
                <li class="genreItem">${genre.name}</li>
            </c:forEach>--%>

        </ul>
    </div>
    <div class="header">
        <div class="user">
            <%
                String username = (String) request.getSession().getAttribute("username");
                if (username == null) {
                    username = request.getParameter("username");
                    request.getSession().setAttribute("username", username);
                }

                String countBooks;
                if (request.getSession().getAttribute("box") == null) {
                    countBooks = "0";
                } else {
                    countBooks = (String) request.getSession().getAttribute("box");
                }
            %>
            <span>Здравствуйте, <%= username %></span><br>
            <span>Книг в корзине: <%= countBooks %></span>
        </div>
        <div class="menu">
            <img class="headerImage" src="../images/book.png" alt="library" />
            <ul class="menuList">
                <li class="menuItem">Новые поступления</li>
                <li class="menuItem">Популярные</li>
                <li class="menuItem">Акции</li>
                <li class="menuItem">Контакты</li>
            </ul>
        </div>
    </div>
    <div class="content">
        <form class="searchForm" name="searchForm" method="post">
            <img src="../images/search.png" alt="search" />
            <span>Поиск по:</span>
            <select class="selectBy" name="selectBy">
                <option class="selectByOption">
                    названию
                </option>
                <option class="selectByOption">
                    автору
                </option>
            </select>
            <input class="searchString" type="text" name="searchString" size="50%"/>
            <input class="searchButton" type="submit" value="Искать"/>
        </form>
        <h2><%= username %>, добро пожаловать в нашу электронную библиотеку!</h2>
        <p>
            У нас Вы найдете самые свежие новинки, бестселлеры, научно-популярную литературу для обучения,
            либо интересные романы и захватывающие детективы для приятного досуга. Посетив нас
            один раз, Вы уже не сможете удержаться от прочтения очередной увлекательной книги!
        </p>
        <p>
            Чтобы найти интересующую Вас книгу, воспользуйтесь удобным поиском по библиотеке, либо
            выберите в меню слева понравившийся жанр и посмотрите наш богатый перечень литературы,
            подходящей Вам.
        </p>
    </div>
    <div class="clearing"></div>
</div>
<div class="footer">
    All rights reserved. S. Ermolovich, 2016
</div>

</body>
</html>
