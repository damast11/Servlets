package JDBC.dao;

import journal.Journal;

import java.util.Date;

public interface JournalFilterDao {
    Journal filter (String s);
    Journal filter (Date fromDate, Date toDate);
    void sortByDate();
    void sortByImportanceDate();
    void sortByImportanceSourceDate();
    void sortBySourceDate();
}
