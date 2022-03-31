package group.travelagency.utils;

import group.travelagency.domain.Flight;
import group.travelagency.repository.FlightRepository;
import group.travelagency.repository.LocationRepository;
import group.travelagency.repository.PurchaseRepository;
import group.travelagency.repository.UserRepository;
import group.travelagency.repository.database.TableFactory;
import group.travelagency.service.FlightService;
import group.travelagency.service.LoginService;
import group.travelagency.service.PurchaseService;
import group.travelagency.service.UserService;

import java.sql.SQLException;

public class Resources {
    static Resources instance = null;

    private static TableFactory tableFactory;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final FlightRepository flightRepository;
    private final PurchaseRepository purchaseRepository;
    private final UserService userService;
    private final LoginService loginService;
    private final FlightService flightService;
    private final PurchaseService purchaseService;


    private Flight selectedFlight = null;
    public static Resources getInstance() throws SQLException {
        if (instance == null)
            instance = new Resources();
        return instance;
    }
    private Resources() throws SQLException {
        tableFactory = new TableFactory();
        userRepository = new UserRepository();
        locationRepository = new LocationRepository();
        flightRepository = new FlightRepository();
        purchaseRepository = new PurchaseRepository();
        userService = new UserService(userRepository);
        loginService = new LoginService();
        flightService = new FlightService(flightRepository);
        purchaseService = new PurchaseService(purchaseRepository, flightService);
    }

    public PurchaseService getPurchaseService() {
        return purchaseService;
    }

    public Flight getSelectedFlight() {
        return selectedFlight;
    }

    public void setFlight(Flight flight) {
        this.selectedFlight = flight;
    }

    public FlightService getFlightService() {
        return flightService;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public UserService getUserService() {
        return userService;
    }

    public PurchaseRepository getPurchaseRepository() {
        return purchaseRepository;
    }

    public FlightRepository getFlightRepository() {
        return flightRepository;
    }

    public LocationRepository getLocationRepository() {
        return locationRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public static TableFactory getTableFactory() {
        return tableFactory;
    }
}
