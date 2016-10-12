<%--header, footer, left menu and search form are in jspf files--%>
<div class="content">
    <%@include file="../WEB-INF/jspf/searchForm.jspf" %>
    <%@include file="../WEB-INF/jspf/letters.jspf"%>

    <%request.setCharacterEncoding("UTF-8");%>
    <%response.setCharacterEncoding("UTF-8");%>

    <%--redirect to books.jsp if user was searching book by title or by author from main.jsp--%>
    <%
    if (request.getParameter("search_str") != null) {
        getServletContext().getRequestDispatcher("/pages/books.jsp").forward(request,response);
    }
    %>

    <h2>Добро пожаловать в Магакнигазин!</h2>
    <p>
        У нас Вы найдете самые свежие новинки, бестселлеры, научно-популярную литературу для обучения,
        интересные романы и захватывающие детективы для приятного досуга.
    </p>
    <p>
        Чтобы найти интересующую Вас книгу, воспользуйтесь удобным поиском по библиотеке, либо
        выберите в меню слева понравившийся жанр и посмотрите наш богатый перечень литературы,
        подходящей Вам.
    </p>
    <% if (session.getAttribute("user") == null) {%>
        <p>
            <a href="login.jsp">Войдите</a> или <a href="register.jsp">зарегистрируйтесь</a>, чтобы воспользоваться нашей <a href="#">дисконтной программой</a>.
        </p>
    <% } %>
</div>