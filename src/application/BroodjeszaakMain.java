package application;

import controller.BestelViewController;
import controller.KeukenViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.BestelFacade;
import view.AdminView;
import view.KeukenView;
import view.BestelView;


public class BroodjeszaakMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        BestelFacade bestelFacade = new BestelFacade();
        BestelViewController bestelViewController = new BestelViewController(bestelFacade);
        KeukenViewController keukenViewController = new KeukenViewController(bestelFacade);
        AdminView adminView = new AdminView();
        BestelView bestelView = new BestelView(bestelViewController);
        KeukenView keukenView = new KeukenView(keukenViewController);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
