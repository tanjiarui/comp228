package view;

import dao.PlayerAndGameDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.PlayerAndGame;

import java.net.URL;
import java.util.ResourceBundle;




public class PlayerAndGameController implements Initializable {

    public final static PlayerAndGameDao playerAndGameDao= new PlayerAndGameDao();
    public static ObservableList<PlayerAndGame> playerAndGameObservableList = FXCollections.observableArrayList();
    public TableColumn<Object, Object> player_game_id;
    public TableColumn<Object, Object> game_id;
    public TableColumn<Object, Object> player_id;
    public TableColumn<Object, Object> playing_date;
    public TableColumn<Object, Object> score;
    public TableView playAndGameInformation;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        player_game_id.setCellValueFactory(new PropertyValueFactory<>("player_game_id"));
        game_id.setCellValueFactory(new PropertyValueFactory<>("game_id"));
        player_id.setCellValueFactory(new PropertyValueFactory<>("player_id"));
        playing_date.setCellValueFactory(new PropertyValueFactory<>("playing_date"));
        score.setCellValueFactory(new PropertyValueFactory<>("score"));

        playerAndGameObservableList.setAll(playerAndGameDao.findAll());
        playAndGameInformation.setItems(playerAndGameObservableList);
    }
}
