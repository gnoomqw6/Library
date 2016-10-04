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

    <div class="log_reg">
        <p>
            Войдите, чтобы воспользоваться преимуществами нашей <a href="#">дисконтной программы</a>.
        </p>

        <form name="login_form" action="/ckeck_login" method="post">
            <table cellpadding="5px">
                <tr>
                    <td>Логин (e-mail):</td>
                    <td><input type="email" name="login"></td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="button" type="submit" value="Войти"></td>
                </tr>
            </table>

        </form>

        <%
            if (request.getParameter("err") != null) {%>
                <p style="color: #ff8789">Неверный логин или пароль!</p>
            <%}
        %>
    </div>

</div>