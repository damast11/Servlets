package Servlets;

import JDBC.entity.Record;
import JDBC.service.JournalService;
import journal.Journal;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class AddRecord extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        JournalService js = new JournalService();
        String str = req.getParameter("Record");
        String[] subStr;
        String delimeter = " ";
        subStr = str.split(delimeter);
        Record record = null;
        try {
            record = new Record(Integer.parseInt(subStr[0]), new SimpleDateFormat("dd/MM/yyyy").parse(subStr[1])
                    , Integer.parseInt(subStr[2]), subStr[3], subStr[4]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            js.add(Objects.requireNonNull(record));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
