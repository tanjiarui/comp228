package view;

import com.mysql.cj.util.StringUtils;
import dao.PlayerDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerController implements Initializable {

    private static Stage newAlertDialog ;
    private static WiAlertDialog wiAlertDialog;

    public static final PlayerDao playerDao = new PlayerDao();
    public static ObservableList<Player> playerObservableList = FXCollections.observableArrayList();
    public TableView playerInformation ;
    public TableColumn<Object, Object> player_id;
    public TableColumn<Object, Object> first_name ;
    public TableColumn<Object, Object> province;
    public TableColumn<Object, Object> last_name;
    public TableColumn<Object, Object> address;
    public TableColumn<Object, Object> phone_number;
    public TextField playID;
    public Button findPlayerById;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        player_id.setCellValueFactory(new PropertyValueFactory<>("player_id"));
        first_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        province.setCellValueFactory(new PropertyValueFactory<>("province"));
        phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        playerObservableList.setAll(playerDao.findAll());
        playerInformation.setItems(playerObservableList);
    }

    public void findPlayerByIdAction(ActionEvent actionEvent) {
        player_id.setCellValueFactory(new PropertyValueFactory<>("player_id"));
        first_name.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        last_name.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        province.setCellValueFactory(new PropertyValueFactory<>("province"));
        phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        playerObservableList.clear();
        String playIDText = playID.getText();
        if (!playIDText.isEmpty()&& StringUtils.isStrictlyNumeric(playIDText)){
            playerObservableList.add(playerDao.findByid(Integer.parseInt(playIDText)));
        }
        playerInformation.setItems(playerObservableList);
    }

    public void changePlayerByIdAction(ActionEvent actionEvent) {
        String playIDText = playID.getText();
        newAlertDialog = new Stage(StageStyle.TRANSPARENT);
        newAlertDialog.setResizable(false);
        wiAlertDialog = new WiAlertDialog("123");
        newAlertDialog.setScene(new Scene(wiAlertDialog));
        newAlertDialog.show();
    }


}
