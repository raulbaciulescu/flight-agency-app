package group.travelagency.service;

import group.travelagency.domain.Flight;
import group.travelagency.domain.Purchase;
import group.travelagency.repository.PurchaseRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final FlightService flightService;
    private final Random random;


    public PurchaseService(PurchaseRepository purchaseRepository, FlightService flightService) {
        this.purchaseRepository = purchaseRepository;
        this.flightService = flightService;
        this.random = new Random();
    }

    public void add(Flight flight, String clientName, String clientAddress, List<String> tourists, Integer nrOfSeats) throws Exception {
        if (nrOfSeats > flight.getNrOfSeats())
            throw new Exception();
        final long id = random.nextLong();
        Purchase purchase = new Purchase(flight, clientName, clientAddress, tourists, nrOfSeats);
        purchase.setId(id);
        purchaseRepository.add(purchase);
        Flight flightNew = new Flight(flight.getStart(), flight.getDestination(),
                flight.getStartDate(), flight.getNrOfSeats() - nrOfSeats);
        flightNew.setId(flight.getId());
        flightService.update(flight, flightNew);
    }

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<Purchase> findById(Long id) throws SQLException {
        return purchaseRepository.findByID(id);
    }
}
