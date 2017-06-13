package demo.servlet;

import demo.util.Db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhenya.1291813139.com
 * on 2017/6/13.
 * stuentExcel.
 */
@WebServlet(urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("register".equals(action)) {
            register(req,resp);
            return;
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nick = req.getParameter("nick").trim();
        String mobile = req.getParameter("mobile").trim();
        String password = req.getParameter("password");
        if (nick.length() == 0 || mobile.length() == 0 || password.length() == 0) {
            req.setAttribute("message", "nick or mobile has an error");
            req.getRequestDispatcher("signup.jsp").forward(req,resp);
        }

        Connection connection = Db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
        String sqlNick = "SELECT * FROM db_excel.student WHERE nick = ?";
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sqlNick);
            }
            preparedStatement.setString(1,"nick");
            resultSet = preparedStatement.executeQuery();
            boolean isNickExit = resultSet.next();

            String sqlMobile = "SELECT * FROM db_excel.student WHERE mobile = ?";
            preparedStatement = connection.prepareStatement(sqlMobile);
            preparedStatement.setString(1,"mobile");
            resultSet = preparedStatement.executeQuery();
            boolean isMobileExit = resultSet.next();

            if (isNickExit) {
                req.setAttribute("message","昵称不存在");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
            }else if (isMobileExit){
                req.setAttribute("message","密码错误");
                req.getRequestDispatcher("sign.jsp").forward(req,resp);
            }else {
                String sql = "INSERT INTO db_excel.student VALUE (NULL ,?,?,?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,nick);
                preparedStatement.setString(2,mobile);
                preparedStatement.setString(3,password);
                preparedStatement.executeUpdate();// 广义更新
                resp.sendRedirect("index.jsp");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Db.close(preparedStatement,resultSet,connection);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
