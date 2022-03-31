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

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainController {
    @FXML TableView<Flight> tableView;
    @FXML TableColumn<Flight, String> tableColumnStart;
    @FXML TableColumn<Flight, String> tableColumnDestination;
    @FXML TableColumn<Flight, String> tableColumnStartDate;
    @FXML TableColumn<Flight, String> tableColumnNrOfSeats;

    @FXML Button btnSearch;
    @FXML Button btnLogout;
    private ObservableList<Flight> observableList = FXCollections.observableArrayList();
    private FlightService flightService;

    public MainController() throws SQLException {
        flightService = Resources.getInstance().getFlightService();
    }

    @FXML
    void initialize() throws SQLException {
        tableColumnStart.setCellValueFactory(new PropertyValueFactory<>("start"));
        tableColumnDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        tableColumnStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        tableColumnNrOfSeats.setCellValueFactory(new PropertyValueFactory<>("nrOfSeats"));
        observableList.addAll(flightService.getAll());
        tableView.setItems(observableList);
    }


    public void onLogoutBtnClick(MouseEvent mouseEvent) throws SQLException, IOException {
        Resources.getInstance().getLoginService().logoutCurrentUser();
        Navigation.navigate(Constants.Scene.LOG_IN, mouseEvent);
    }

    public void onSearchBtnClick(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Constants.Scene.SEARCH, mouseEvent);
    }
}
