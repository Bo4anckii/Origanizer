package organizer.models;

import java.util.Calendar;

public class Note {
    private long id;
    private Calendar dateTime;
    private String text;

    public Note(long id, Calendar dateTime, String text) {
        this.id = id;
        this.dateTime = dateTime;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
