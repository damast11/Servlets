package JDBC.entity;

import java.util.Date;

public class Record {
    private int id;
    private Date date;
    private int priority;
    private String source;
    private String error;

    public Record(int id , Date date, int priority, String source, String error) {
        this.id = id;
        this.date = date;
        if (priority > 0 && priority < 5)
            this.priority = priority;
        if (!source.contains(" "))
            this.source = source;
        if (!error.contains("\n"))
            this.error = error;
    }

    public Record(String s) {

    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String showPriority(int i) {
        switch (i) {
            case 1:
                return ".    ";
            case 2:
                return "!    ";
            case 3:
                return "!!!  ";
            case 4:
                return "!!!!!";

        }
        return null;
    }

    @Override
    public String toString() {
        return "Journal{" + "id= " + id +
                "date=" + date +
                ", priority=" + priority +
                ", source='" + source + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
