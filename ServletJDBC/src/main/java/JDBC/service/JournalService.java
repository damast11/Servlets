package JDBC.service;

import JDBC.Util;
import JDBC.dao.JournalFilterDao;
import JDBC.dao.JournalMethodsDao;
import JDBC.entity.Record;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JournalService extends Util {

    Connection connection = getConnection();

    public void add(Record r) {
        String sql = "insert into \"journal\"(\"id\",\"date\",\"priority\",\"source\",\"error\") values(?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, r.getId());
            preparedStatement.setDate(2, new java.sql.Date( r.getDate().getTime()));
            preparedStatement.setInt(3, r.getPriority());
            preparedStatement.setString(4, r.getSource());
            preparedStatement.setString(5, r.getError());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public List<Record> getall(){
        String sql = "select * from \"journal\"";
        return null;
    }
}
