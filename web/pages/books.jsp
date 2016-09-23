<%@ page import="bean.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">
    <%@include file="../WEB-INF/jspf/searchForm.jspf"%>

    <%request.setCharacterEncoding("UTF-8");
        int genreId = -1;   //задаем начальное значение -1 для последующей проверки и перенаправления в случае, если это значение останется -1

        try {
            genreId = Integer.parseInt(request.getParameter("genre_id"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    %>

    <jsp:useBean id="bookList" class="bean.BookList" scope="page"/>

    <div class="books">

        <h3>Жанр: ${param.genre_name}</h3>

        <% for (Book book : bookList.getBooksByGenre(genreId)) { %>
                <div class="bookItem">
                    <div style="height: 10%"><strong><a href="#"><%=book.getName()%></a></strong></div>
                    <a href="#"><img src="../images/book_img/<%=book.getImageNumber()%>.jpg"></a>
                    <p><span>Автор: <%=book.getAuthor()%><br></span>
                    <% if (book.getPageCount() != 0) {%>
                    <small>Страниц: <%=book.getPageCount()%></small><br>
                    <%}%>
                    <% if (!book.getPublisher().isEmpty()) {%>
                    <small>Издательство: <%=book.getPublisher()%></small><br>
                    <%}%>
                    <% if (book.getYear() != 0) {%>
                    <small>Год: <%=book.getYear()%></small><br>
                    <%}%>
                    <% if (!book.getIsbn().isEmpty()) {%>
                    <small>ISBN: <%=book.getIsbn()%></small><br></p>
                    <%}%>
                </div>
        <% } %>

    </div>
</div>