package organizer.models;

import java.util.Calendar;

public class Note {
    private final long id;
    private final Calendar dateTime;
    private final String text;
    private final String time;

    public Note(long id, Calendar dateTime, String text) {
        this.id = id;
        this.dateTime = dateTime;
        this.text = text;
        this.time = dateTime.getTime().getHours()+":"+dateTime.getTime().getMinutes();
    }

    public long getId() {
        return id;
    }

    public Calendar getDateTime() {
        return dateTime;
    }
    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }
}
