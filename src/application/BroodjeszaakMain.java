package application;

import javafx.application.Application;
import javafx.stage.Stage;
import view.AdminView;
import view.KitchenView;
import view.BestelView;

import java.io.IOException;


public class BroodjeszaakMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        AdminView adminView = new AdminView();
        BestelView bestelView = new BestelView();
        KitchenView kitchenView = new KitchenView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
