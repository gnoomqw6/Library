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
        <h3>ID жанра в базе: ${param.genre_id}</h3>

        <% int counter = 0;
            for (Book book : bookList.getBooksByGenre(genreId)) { %>
            <div class="bookItem">
                <%=book.getName()%><br>
                <%=book.getAuthor()%><br>
                <%=book.getPageCount()%><br>
                <%=book.getPublisher()%><br>
                <%=book.getYear()%><br>
                <%=book.getIsbn()%><br>
                <%=book.getImageNumber()%><br>
            </div>
        <% counter++;} %>

        <h3>List have <%=counter%> elements (!!!bug if 0)</h3>
    </div>
</div>