package organizer.db;

public class Const {
    public static final String NOTES_TABLE = "notes";
    public static final String NOTE_ID = "id";
    public static final String NOTE_DATETIME = "dateTime";
    public static final String NOTE_TEXT = "text";
    public static final String NOTES_GET = "Select * From " + NOTES_TABLE;
    public static final String NOTE_POST = "Insert into " + NOTES_TABLE + "(" + NOTE_ID + ", " + NOTE_DATETIME + ", " + NOTE_TEXT + ") Values(?,?,?)";
    public static final String NOTE_DELETE = "Delete From " + NOTES_TABLE + " Where " + NOTE_ID + " = ?";
}
