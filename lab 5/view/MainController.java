package view;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {
    private static final Logger logger = Logger.getLogger(MainController.class.getName());
    private ViewAlter viewAlter;

    @FXML
    private TreeView<String> main_treeview;

    @FXML
    private ScrollPane main_scroll_pane;

    @FXML
    private AnchorPane main_pane_under_scroll;

    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTreeView();
    }

    /**
     * 设置TreeView
     */
    @SuppressWarnings("unchecked")
    public void setTreeView() {
        TreeItem<String> root = new TreeItem<String>(StaticResourcesConfig.MAIN_TREE_HEADER);
        root.setExpanded(true);
        root.getChildren().addAll(new TreeItem<String>(StaticResourcesConfig.MAIN_TREE_HEADER_PLAYER),
                new TreeItem<String>(StaticResourcesConfig.MAIN_TREE_HEADER_GAME),
                new TreeItem<String>(StaticResourcesConfig.MAIN_TREE_HEADER_PLAYERANDGAME));
        main_treeview.setRoot(root);

    }

    /**
     * TreeView 点击事件
     * @throws IOException
     */
    public void mainTreeViewClick() throws IOException {
        logger.log(Level.INFO, "TreeView");
        // 获取鼠标当前点击的Item
        TreeItem<String> selectedItem = main_treeview.getSelectionModel().getSelectedItem();


        String pagePath = StaticResourcesConfig.DEFALUT_VIEW_PATH;
        if(!selectedItem.getValue().isEmpty()) {
            logger.log(Level.INFO, selectedItem.getValue());
            switch (selectedItem.getValue()) {

                case StaticResourcesConfig.MAIN_TREE_HEADER_GAME:
                    pagePath = StaticResourcesConfig.GAME_VIEW_PATH;
                    break;
                case StaticResourcesConfig.MAIN_TREE_HEADER_PLAYER:
                    pagePath = StaticResourcesConfig.PLAYER_VIEW_PATH;
                    break;
                case StaticResourcesConfig.MAIN_TREE_HEADER_PLAYERANDGAME:
                    pagePath = StaticResourcesConfig.PLAYERANDGAME_VIEW_PATH;
                    break;
            }
        }
        skipView(pagePath);
    }

    /**
     * 改变右侧scroll的界面
     * @param pagePath
     * @throws IOException
     */
    private void skipView(String pagePath) throws IOException {
        logger.info("change scene");
        ObservableList<Node> scrolChildren = main_pane_under_scroll.getChildren();
        scrolChildren.clear();
        scrolChildren.add(FXMLLoader.load(getClass().getResource(pagePath)));
    }

}
