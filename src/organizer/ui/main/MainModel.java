package organizer.ui.main;

import organizer.models.Note;

import java.util.List;

public class MainModel {
    private List<Note> notes;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
