package group.travelagency.utils;

import group.travelagency.repository.FlightRepository;
import group.travelagency.repository.LocationRepository;
import group.travelagency.repository.PurchaseRepository;
import group.travelagency.repository.UserRepository;
import group.travelagency.repository.database.TableFactory;

import java.sql.SQLException;

public class Resources {
    static Resources instance = null;

    private static TableFactory tableFactory;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final FlightRepository flightRepository;
    private final PurchaseRepository purchaseRepository;

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
