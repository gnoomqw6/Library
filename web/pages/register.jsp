<div class="content">
    <%@include file="../WEB-INF/jspf/searchForm.jspf" %>
    <%@include file="../WEB-INF/jspf/letters.jspf"%>

    <%request.setCharacterEncoding("UTF-8");%>
    <%response.setCharacterEncoding("UTF-8");%>

    <script src="../scripts/RegValidation.js"></script>

    <%--redirect to books.jsp if user was searching book by title or by author from register.jsp--%>
    <%
        if (request.getParameter("search_str") != null) {
            getServletContext().getRequestDispatcher("/pages/books.jsp").forward(request,response);
        }
    %>

    <div class="log_reg">
        <p>
            Зарегистрируйтесь, чтобы воспользоваться преимуществами нашей <a href="#">дисконтной программы</a>.<br><br>
            Все поля обязательны для заполнения.
        </p>

        <form name="register_form" action="<%= request.getContextPath() %>/register" method="post" onsubmit="return validateForm()">
            <table cellpadding="5px">
                <tr>
                    <td>Логин (e-mail):</td>
                    <td><input type="email" name="login" placeholder="example@ex.com"></td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input type="password" name="password" placeholder="до 12 символов"></td>
                </tr>
                <tr>
                    <td>Повторите пароль:</td>
                    <td><input type="password" name="passwordRetype" placeholder="******"></td>
                </tr>
                <tr>
                    <td>Как Вас зовут:</td>
                    <td><input type="text" name="userName" placeholder="Матвей"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="button" type="submit" value="Зарегистрироваться"></td>
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
