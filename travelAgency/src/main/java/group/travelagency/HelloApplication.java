package group.travelagency;

import group.travelagency.domain.Flight;
import group.travelagency.domain.Location;
import group.travelagency.domain.Purchase;
import group.travelagency.domain.User;
import group.travelagency.repository.UserRepository;
import group.travelagency.utils.Resources;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {

//        List<String> tourists = new ArrayList<>();
//        tourists.add("Turist1");
//        tourists.add("Turist2");
//        tourists.add("Turist3");
//        Location location = new Location("Cluj", "Aeroport cluj");
//        location.setId(1L);
//        Flight flight = new Flight(location, location, LocalDateTime.now(), 5);
//        flight.setId(1L);
//        Purchase purchase = new Purchase(flight, "Client1", "strada garofitei",
//                tourists, 4);
//        purchase.setId(1L);
//        Resources.getInstance().getLocationRepository().add(location);
//        Resources.getInstance().getLocationRepository().getAll().forEach(System.out::println);
//        System.out.println("\n");
//
//        Resources.getInstance().getFlightRepository().add(flight);
//        Resources.getInstance().getFlightRepository().getAll().forEach(System.out::println);
//        System.out.println("\n");
//
//        Resources.getInstance().getPurchaseRepository().add(purchase);
//        Resources.getInstance().getPurchaseRepository().getAll().forEach(System.out::println);
//
//        User user1 = new User("raul", "pass",
//                "raul", "baciulescu");
//        User user2 = new User("ra", "sspass",
//                "raul", "baciulescuss");
//        user1.setId(1L);
//        user2.setId(2L);
//
//        UserRepository repo = Resources.getInstance().getUserRepository();
//        repo.add(user1);
//        repo.add(user2);
//        List<User> list = repo.getAll();
//        list.forEach(System.out::println);

        Location loc2 = Resources.getInstance().getLocationRepository().findByID(2L).get();
        Location loc3 = Resources.getInstance().getLocationRepository().findByID(3L).get();
        Location loc4 = Resources.getInstance().getLocationRepository().findByID(4L).get();
        Location loc5 = Resources.getInstance().getLocationRepository().findByID(5L).get();

//        Resources.getInstance().getFlightService().add(loc2, loc3, LocalDateTime.now(), 30);
//        Resources.getInstance().getFlightService().add(loc3, loc4, LocalDateTime.now(), 30);
//        Resources.getInstance().getFlightService().add(loc5, loc4, LocalDateTime.now(), 30);
//        Resources.getInstance().getFlightService().add(loc3, loc5, LocalDateTime.now(), 30);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}