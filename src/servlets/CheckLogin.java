package servlets;

import bean.User;
import db.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        String redirectUrl = request.getContextPath();


//        if fields are empty redirect to login.jsp with error parameter
        if (login == null || password == null || login.equals("") || password.equals("")) {
            redirectUrl += "/pages/login.jsp?err=1";
        } else {        //        checking params in database
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            try {
                connection = Database.getDataSource().getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM users WHERE email = '" + login + "'");
                if (resultSet.first()) {
                    if (!resultSet.getString("password").equals(password)) {
                        redirectUrl += "/pages/login.jsp?err=1";
                    } else {
                        User user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"),
                                resultSet.getInt("discount"), resultSet.getInt("total_sum"));
                        request.getSession().setAttribute("user", user);
                        if (request.getSession().getAttribute("pre_page") == null) {
                            redirectUrl += "/pages/main.jsp";
                        } else {
                            redirectUrl = request.getSession().getAttribute("pre_page").toString();
                        }
                    }
                } else {
                    redirectUrl += "/pages/login.jsp?err=1";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                redirectUrl += "/pages/login.jsp?err=1";
            } finally {
                try {
                    if (resultSet != null) resultSet.close();
                    if (statement != null) statement.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

        response.sendRedirect(redirectUrl);

    }
}
