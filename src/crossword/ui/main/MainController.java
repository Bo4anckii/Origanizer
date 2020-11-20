package crossword.ui.main;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public TableView table;
    public TableColumn timeColumn;
    public TableColumn noteColumn;
    public DatePicker datePicker;
    public Button yesterdayBtn;
    public Button tomorrowBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
