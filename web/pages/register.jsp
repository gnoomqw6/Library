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
                    <td>
                        <% if (request.getParameter("login") != null && !request.getParameter("login").isEmpty()) { %>
                            <input type="email" name="login" required value="<%= request.getParameter("login") %>"/>
                        <% } else { %>
                            <input type="email" name="login" placeholder="example@ex.com" required/>
                        <% } %>
                    </td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input type="password" name="password" placeholder="до 12 символов" required/></td>
                </tr>
                <tr>
                    <td>Повторите пароль:</td>
                    <td><input type="password" name="passwordRetype" placeholder="******" required/></td>
                </tr>
                <tr>
                    <td>Как Вас зовут:</td>
                    <td>
                        <% if (request.getParameter("username") != null && !request.getParameter("username").isEmpty()) { %>
                            <input type="text" name="username" required value="<%= request.getParameter("username") %>"/>
                        <% } else { %>
                            <input type="text" name="username" placeholder="Матвей" required/>
                        <% } %>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="button" type="submit" value="Зарегистрироваться"/></td>
                </tr>
            </table>

        </form>

        <% if (request.getParameter("err") != null) {
            if (request.getParameter("err").equals("duplicate_username")) {%>
                <p style="color: #ff8789">Пользователь с таким логином уже зарегистрирован!</p>
        <%  } else if (request.getParameter("err").equals("sql")) {%>
                <p style="color: #ff8789">При регистрации возникла непредвиденная ошибка. Приносим свои извинения.</p>
        <%  }
        } %>
    </div>

</div>
