package io.github.todolist.core.vulns;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sqli {

    // validates if input email and password are correct
    public static boolean checkUser(
            HttpServletRequest req, Connection con) throws SQLException {
        String sqlQuery = "SELECT email FROM credentials " +
                "WHERE email='" + req.getParameter("email") + "' " +
                "AND password='" + req.getParameter("password") + "'";

        Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery(sqlQuery);
        return rs.next();
    }

}