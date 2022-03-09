package group.travelagency;

import group.travelagency.domain.Flight;
import group.travelagency.domain.Location;
import group.travelagency.domain.Purchase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        List<String> tourists = new ArrayList<>();
        tourists.add("Turist1");
        Location location = new Location("Cluj", "Aeroport cluj");
        Flight flight = new Flight(location, location, LocalDateTime.now(), 5);
        Purchase purchase = new Purchase(flight, "Client1", "strada garofitei",
                tourists, 4);
        System.out.println(purchase);
        System.out.println(location);



        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}