package organizer.ui.main;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public TableView table;
    public TableColumn timeColumn;
    public TableColumn noteColumn;
    public DatePicker datePicker;
    public Button yesterdayBtn;
    public Button tomorrowBtn;
    public Button addBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addBtn.setOnAction(event -> openAddView());
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
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
