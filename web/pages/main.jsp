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

    <h2><%= request.getSession().getAttribute("username") %>, добро пожаловать в нашу электронную библиотеку!</h2>
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