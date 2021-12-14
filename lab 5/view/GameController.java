package view;


import com.mysql.cj.util.StringUtils;
import dao.GameDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Game;


import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public final static GameDao gameDao= new GameDao();
    public static ObservableList<Game> gameObservableList = FXCollections.observableArrayList();
    public TableView<Game> gameInformation;
    public TableColumn<Object, Object> game_id;
    public TableColumn<Object, Object> game_title;
    public TextField gameID;
    public Button findGameById;

    public void initialize(URL location, ResourceBundle resources){
        game_id.setCellValueFactory(new PropertyValueFactory<>("game_id"));
        game_title.setCellValueFactory(new PropertyValueFactory<>("game_title"));
        gameObservableList.setAll(gameDao.findAll());
        gameInformation.setItems(gameObservableList);
    }

    public void findGameByIdAction(ActionEvent actionEvent) {
        game_id.setCellValueFactory(new PropertyValueFactory<>("game_id"));
        game_title.setCellValueFactory(new PropertyValueFactory<>("game_title"));
        gameObservableList.clear();
        String gameIDText = gameID.getText();
        if (!gameIDText.isEmpty()&& StringUtils.isStrictlyNumeric(gameIDText)){
            gameObservableList.add(gameDao.findByid(Integer.parseInt(gameIDText)));
        }
        gameInformation.setItems(gameObservableList);
    }

    public void changeGameByIdAction(ActionEvent actionEvent) {
    }
}