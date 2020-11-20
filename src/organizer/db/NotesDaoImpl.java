package organizer.db;

import organizer.models.Note;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class NotesDaoImpl implements NotesDao {

    private final DatabaseHandler handler = new DatabaseHandler();

    @Deprecated
    @Override
    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        try {
            Statement statement = handler.getDbConnection().createStatement();
            ResultSet set = statement.executeQuery(Const.NOTES_GET);
            while (set.next()){
                Timestamp ts = set.getTimestamp(Const.NOTE_DATETIME);
                ts.setHours(ts.getHours()-3);
                Calendar calendar = new GregorianCalendar(ts.getYear()+1900, ts.getMonth(), ts.getDate(), ts.getHours(), ts.getMinutes(), ts.getSeconds());
                notes.add(new Note(
                        set.getLong(Const.NOTE_ID),
                        calendar,
                        set.getString(Const.NOTE_TEXT)
                ));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return notes;
    }

    @Override
    public void addNote(Note note) {
        try {
            PreparedStatement statement = handler.getDbConnection().prepareStatement(Const.NOTE_POST);
            statement.setLong(1, note.getId());
            statement.setTimestamp(2, new Timestamp(note.getDateTime().getTimeInMillis()));
            statement.setString(3, note.getText());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteNote(Note note) {
        try {
            PreparedStatement statement = handler.getDbConnection().prepareStatement(Const.NOTE_DELETE);
            statement.setLong(1, note.getId());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
