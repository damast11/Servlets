package JDBC.service;

import JDBC.Util;
import JDBC.entity.Record;
import journal.Journal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

        PreparedStatement ps = null;
        List<Record> list = new ArrayList<>();
        try {

            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Record record = new Record();
                record.setId(rs.getInt("id"));
                record.setDate(rs.getDate("date"));
                record.setPriority(rs.getInt("priority"));
                record.setSource(rs.getString("source"));
                record.setError(rs.getString("error"));
                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void remove(int index) throws SQLException {
        String sql = "delete from \"journal\" where \"id\" = "+index;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        preparedStatement.close();
    }

    public List<Record> filter (String s ){
        List<Record> list = getall();
        List<Record> filterList = new ArrayList<>();
        for (Record record:list){
            if (record.toString().contains(s)){
                filterList.add(record);
                System.out.println(filterList);
            }
        }
        return filterList;
    }
    public void sortByDate(){
        List<Record> list = getall();
        Journal j = new Journal();
        j.add((Journal) list);
        j.sortByDate();
    }
}
