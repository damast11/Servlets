package JDBC.dao;

import JDBC.entity.Record;
import journal.Journal;

public interface JournalMethodsDao {
    void add(Record r);
    void add(Journal j);
    void remove(Record r);
    void remove(int index);
    void remove(int fromIndex, int toIndex);
    void removeAll();

}
