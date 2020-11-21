package organizer.ui.add;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import organizer.db.NotesDao;
import organizer.db.NotesDaoImpl;
import organizer.models.Note;
import organizer.ui.main.MainController;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    public TextArea textArea;
    public Button doneBtn;
    public JFXDatePicker datePicker;
    public JFXTimePicker timePicker;

    private MainController parent;
    private final AddModel model = new AddModel();
    private final NotesDao notesDao = new NotesDaoImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setValue(LocalDate.now());
        timePicker.setValue(LocalTime.now());
        textArea.textProperty().addListener((observable, oldValue, newValue) -> model.setText(newValue));
        datePicker.setOnAction(event -> setData());
        timePicker.setOnAction(event -> setData());
        doneBtn.setOnAction(event -> {
            if (model.getText().length() != 0 && model.getDateTime() != null) {
                notesDao.addNote(new Note(System.currentTimeMillis(), model.getDateTime(), model.getText()));
                parent.updateData();
                ((Stage)(doneBtn.getScene().getWindow())).close();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Внимание");
                alert.setHeaderText("Сначала заполните все данные");
                alert.showAndWait();
            }
        });
        setData();
    }

    private void setData() {
        model.setDateTime(new GregorianCalendar(datePicker.getValue().getYear(), datePicker.getValue().getMonthValue()-1, datePicker.getValue().getDayOfMonth(),
                timePicker.getValue().getHour()+3, timePicker.getValue().getMinute()));
    }

    public void setParent(MainController parent) {
        this.parent = parent;
    }
}
