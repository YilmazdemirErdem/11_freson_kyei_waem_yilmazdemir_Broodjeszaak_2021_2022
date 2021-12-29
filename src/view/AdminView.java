package view;

import controller.BroodjesViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class AdminView {
    private Stage stage = new Stage();
    private AdminMainPane borderPane;

    public AdminView(BroodjesViewController broodjesViewController) {
        stage.setTitle("ADMIN VIEW");
        stage.initStyle(StageStyle.UTILITY);
        stage.setX(680);
        stage.setY(20);
        Group root = new Group();
        Scene scene = new Scene(root, 650, 400);
        borderPane = new AdminMainPane();
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        root.getChildren().add(borderPane);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        broodjesViewController.setView(this);
    }

    public void refresh(){
        borderPane.refresh();
    }
}
