package servlets;

import bean.User;
import db.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String redirectUrl = request.getContextPath();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Statement statement1 = null;
        ResultSet resultSet1 = null;

        try {
            connection = Database.getDataSource().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users WHERE email = '" + login + "' limit 1;");
            if (resultSet.first()) {        //check if login is already registered
                redirectUrl += "/pages/register.jsp?err=duplicate_username&username=" + username + "&login=" + login;
            } else {
                if (request.getSession().getAttribute("pre_page") != null) {
                    redirectUrl = request.getSession().getAttribute("pre_page").toString();
                } else {
                    redirectUrl += "/pages/main.jsp?reg=1";
                }
//                insert new user into database
                statement.execute("insert into users (`name`, `email`, `password`) VALUES " +
                        "('" + username + "', '" + login + "', '" + password + "');");
//                and get it's id
                statement1 = connection.createStatement();
                resultSet1 = statement1.executeQuery("SELECT `id` FROM users WHERE `email` = '" + login +
                        "' limit 1;");
                if (resultSet1.first()) {
                    User user = new User(resultSet1.getInt("id"), username, login, 0, 0);
                    request.getSession().setAttribute("user", user);
                }
            }
            response.sendRedirect(redirectUrl);
        } catch (SQLException e) {
            e.printStackTrace();
            redirectUrl = request.getContextPath() + "/pages/register.jsp?err=sql&username=" + username + "&login=" + login;
            response.sendRedirect(redirectUrl);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (resultSet1 != null) resultSet1.close();
                if (statement != null) statement.close();
                if (statement1 != null) statement1.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
