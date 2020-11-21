package organizer.ui.add;

import java.util.Calendar;

public class AddModel {

    private Calendar dateTime;
    private String text;

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
