package organizer.db;

import organizer.models.Note;

import java.util.List;

public interface NotesDao {

    List<Note> getNotes();

    void addNote(Note note);

    void deleteNote(Note note);
}
