package Servlets;

import JDBC.entity.Record;
import JDBC.service.JournalService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/remove.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JournalService js = new JournalService();
        int index = Integer.parseInt(req.getParameter("RemoveRecord"));
        try {
            js.remove(index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(req,resp);
       // req.setAttribute("remove",);
    }
}
