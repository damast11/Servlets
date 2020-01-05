package journal;

import JDBC.dao.JournalFilterDao;
import JDBC.dao.JournalMethodsDao;
import JDBC.entity.Record;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Journal implements JournalFilterDao, JournalMethodsDao {

    private List<Record> records = new ArrayList<>();

    public void showJournal(){
        for (Record record:records){
            System.out.println(record);
        }
    }

    public List<Record> getRecords() {
        return records;
    }

    @Override
    public void add(Record r) {
        records.add(r);
    }

    @Override
    public void add(Journal j) {
        records.addAll(j.getRecords());
    }

    @Override
    public void remove(Record r) {
        records.remove(r);
    }

    @Override
    public void remove(int index) {
        records.remove(index);
    }

    @Override
    public void remove(int fromIndex, int toIndex) {
        remove(fromIndex,toIndex);
    }

    @Override
    public void removeAll() {
        records.removeAll(records);
    }

    @Override
    public Journal filter(String s) {
        Journal j = new Journal();
        for(Record record:records){
            if (record.toString().contains(s))
                j.records.add(record);
        }
        return j;
    }

    @Override
    public Journal filter(Date fromDate, Date toDate) {
        Journal j = new Journal();
        for (Record record:records){
            if (record.getDate().after(fromDate)&&record.getDate().before(toDate))
                j.records.add(record);
        }
        return j;
    }

    @Override
    public void sortByDate() {
        records.sort((o1, o2) -> {
            if (o1.getDate().after(o2.getDate())) return 1;
            else if (o1.getDate().before(o2.getDate())) return -1;
            else if (o1.getDate().equals(o2.getDate())) return 0;
            return 0;
        });
    }


    @Override
    public void sortByImportanceDate() {
        records.stream().sorted(Comparator.comparing(Record::getDate)
                .thenComparing(Record::getPriority))
                .collect(Collectors.toList());

    }

    @Override
    public void sortByImportanceSourceDate() {
        records.stream().sorted(Comparator.comparing(Record::getPriority)
                .thenComparing(Record::getSource)
                .thenComparing(Record::getDate)).collect(Collectors.toList());

    }

    @Override
    public void sortBySourceDate() {
        records.stream().sorted(Comparator.comparing(Record::getSource)
                .thenComparing(Record::getDate)).collect(Collectors.toList());
    }
}
