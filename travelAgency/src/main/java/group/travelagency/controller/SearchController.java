package group.travelagency.controller;

import group.travelagency.domain.Flight;
import group.travelagency.service.FlightService;
import group.travelagency.utils.Constants;
import group.travelagency.utils.Navigation;
import group.travelagency.utils.Resources;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Predicate;

public class SearchController {
    public DatePicker datePicker;
    public TextField txtFieldDestination;
    @FXML TableView<Flight> tableView;
    @FXML TableColumn<Flight, String> tableColumnStart;
    @FXML TableColumn<Flight, String> tableColumnDestination;
    @FXML TableColumn<Flight, String> tableColumnStartDate;
    @FXML TableColumn<Flight, String> tableColumnNrOfSeats;
    @FXML TableColumn<Flight, Long> tableColumnId;
    @FXML Button btnSearch;
    @FXML Button btnBack;
    @FXML Button btnPurchase;
    @FXML public Text errors;

    private ObservableList<Flight> observableList = FXCollections.observableArrayList();
    private FlightService flightService;

    public SearchController() throws SQLException {
        flightService = Resources.getInstance().getFlightService();
    }

    @FXML
    void initialize() throws SQLException {
        tableColumnStart.setCellValueFactory(new PropertyValueFactory<>("start"));
        tableColumnDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        tableColumnStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        tableColumnNrOfSeats.setCellValueFactory(new PropertyValueFactory<>("nrOfSeats"));
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnId.setVisible(false);
        observableList.addAll(flightService.getAll());
        tableView.setItems(observableList);
    }
    public void onSearchBtnClicked(MouseEvent mouseEvent) {
        errors.setVisible(false);
        try {
            Predicate<Flight> p1 = n -> n.getDestination().getName().contains(txtFieldDestination.getText());
            Predicate<Flight> p2 = n -> n.getDestination().getAirport().contains(txtFieldDestination.getText());
            Predicate<Flight> p3 = n -> n.getStartDate().getDayOfMonth() == datePicker.getValue().getDayOfMonth() &&
                    n.getStartDate().getMonth() == datePicker.getValue().getMonth() &&
                    n.getStartDate().getYear() == datePicker.getValue().getYear();
            List<Flight> filteredUsers = flightService.getAll()
                    .stream()
                    .filter(p3.and(p1.or(p2)))
                    .toList();
            observableList.setAll(filteredUsers);
        }
        catch (Exception e) {
            errors.setVisible(true);
        }

    }

    public void onBackBtnClicked(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Constants.Scene.MAIN, mouseEvent);
    }

    public void onPurchaseBtnClicked(MouseEvent mouseEvent) {
        try {
            Flight flight = tableView.getSelectionModel().getSelectedItems().get(0);
            Resources.getInstance().setFlight(flight);
            Navigation.navigate(Constants.Scene.PURCHASE, mouseEvent);
        }
        catch (Exception e) {
            errors.setVisible(true);
        }
    }
}
