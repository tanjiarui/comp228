package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WiAlertDialog  extends AnchorPane {
    @FXML
    Label alertMessage;
    @FXML
    TitledPane alertTitledPane;

    private static WiAlertDialog wiAlertDialog;
    private static Stage newAlertDialog;

    public WiAlertDialog(String message) {
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/scene/playeralertdialog.fxml"));
        try {
            fXMLLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        alertTitledPane.setFocusTraversable(false);
        alertMessage.setText(message);
    }
}