package application;

import controller.BestelViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.BestelFacade;
import view.AdminView;
import view.KitchenView;
import view.BestelView;

import java.io.IOException;


public class BroodjeszaakMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        BestelFacade bestelFacade = new BestelFacade();
        BestelViewController bestelViewController = new BestelViewController(bestelFacade);
        AdminView adminView = new AdminView();
        BestelView bestelView = new BestelView(bestelViewController);
        KitchenView kitchenView = new KitchenView();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
