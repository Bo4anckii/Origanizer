package organizer.ui.main;

import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import organizer.db.NotesDao;
import organizer.db.NotesDaoImpl;
import organizer.models.Note;
import organizer.ui.add.AddController;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public TableView<Note> table;
    public JFXDatePicker datePicker;
    public TableColumn<Note, String> timeColumn;
    public TableColumn<Note, String> noteColumn;
    public Button yesterdayBtn;
    public Button tomorrowBtn;
    public Button addBtn;

    private final NotesDao notesDao = new NotesDaoImpl();
    private final MainModel model = new MainModel();
    public Button deleteButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addBtn.setOnAction(event -> openAddView());
        datePicker.setValue(LocalDate.now());
        model.setNotes(notesDao.getNotes());
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("text"));
        datePicker.setOnAction(event -> showNotes());
        deleteButton.setOnAction(event -> deleteNote());
        yesterdayBtn.setOnAction(event -> {
            datePicker.setValue(datePicker.getValue().minusDays(1));
            showNotes();
        });
        tomorrowBtn.setOnAction(event -> {
            datePicker.setValue(datePicker.getValue().plusDays(1));
            showNotes();
        });
        showNotes();
    }

    private void openAddView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resources/add_view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Добавление записи");
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            loader.<AddController>getController().setParent(this);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateData() {
        model.setNotes(notesDao.getNotes());
        showNotes();
    }

    private void showNotes() {
        ObservableList<Note> notes = FXCollections.observableArrayList();
        for (Note note : model.getNotes()) {
            if (datePicker.getValue().getYear() == note.getDateTime().getTime().getYear() + 1900 &&
                    datePicker.getValue().getMonthValue() == note.getDateTime().getTime().getMonth() + 1 &&
                    datePicker.getValue().getDayOfMonth() == note.getDateTime().getTime().getDate()) {
                notes.add(note);
            }
        }
        table.setItems(notes);
    }

    private void deleteNote() {
        if (table.getSelectionModel().getSelectedIndex() != -1) {
            notesDao.deleteNote(table.getSelectionModel().getSelectedItem());
            updateData();
        }
    }
}
