<%--header, footer, left menu and search form are in jspf files--%>

<%@ page import="bean.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">
    <%@include file="../WEB-INF/jspf/searchForm.jspf"%>
    <%@include file="../WEB-INF/jspf/letters.jspf"%>

    <%request.setCharacterEncoding("UTF-8");%>

    <jsp:useBean id="bookList" class="bean.BookList" scope="page"/>

    <%--filling the list depending on the search type!--%>
    <%  List<Book> list = new ArrayList<Book>();
        String searchType = null;
        if (request.getParameter("search_by") != null) {
            searchType = request.getParameter("search_by");

            if (searchType.equals("genre")) {
                int genreId = Integer.parseInt(request.getParameter("genre_id"));
                list = bookList.getBooksByGenre(genreId);
            } else if (searchType.equals("letters")) {
                String letter = request.getParameter("letter");
                list = bookList.getBooksByLetter(letter);
            } else if (searchType.equals("new")) {
                list = bookList.getNewBooks();
            } else if (searchType.equals("popular")) {
                list = bookList.getPopularBooks();
            } else if (searchType.equals("online")) {
                list = bookList.getOnlineBooks();
            }
        } else if (request.getParameter("search_str") != null) {
            String str = request.getParameter("search_str");
            if (str != null && !str.isEmpty()) {
                list = bookList.getBooksByString(str);
            }
        }
    %>


    <%--display books for this search--%>
    <div class="books">

        <% if (list.isEmpty()) {%><span><strong>Ничего не найдено</strong></span><%}%>

        <% for (Book book : list) {
            String name = book.getName();
            if (name.length() > 50) {
                name = name.substring(0, 50).trim() + "...";
            }%>
                <div class="bookItem">
                    <div style="height: 10%; color: #68e9ff"><strong><%=name%></strong></div>
                    <img src="../images/book_img/<%=book.getImageNumber()%>.jpg">
                    <p>
                        <span>Автор: <%=book.getAuthor()%><br></span>
                        <small>Жанр: <%=book.getGenre()%><br></small>
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
                            <small>ISBN: <%=book.getIsbn()%></small><br>
                        <%}%>
                        <div>
                            <strong>Цена: <%=book.getPriceStr()%> руб.</strong>
                            <input type="button" class="button" value="Купить"
                                onclick=<%=orderList.add(book)%>/>
                        </div>
                    </p>
                </div>
        <% } %>

    </div>
</div>