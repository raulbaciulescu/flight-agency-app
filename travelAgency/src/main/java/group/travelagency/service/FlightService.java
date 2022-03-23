package group.travelagency.service;

import group.travelagency.domain.Flight;
import group.travelagency.domain.Location;
import group.travelagency.domain.User;
import group.travelagency.repository.FlightRepository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class FlightService {
    private final FlightRepository flightRepository;
    private final Random random;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
        this.random = new Random();
    }

    public void add(Location start, Location destination, LocalDateTime startDate, Integer nrOfSeats) {
        final long id = random.nextLong();
        Flight flight = new Flight(start, destination, startDate, nrOfSeats);
        flight.setId(id);
        flightRepository.add(flight);
    }

    public List<Flight> getAll() {
        List<Flight> flights = flightRepository.getAll();
        return flights.stream().filter(flight -> flight.getNrOfSeats() > 0).collect(Collectors.toList());
    }

    public Optional<Flight> findById(Long id) throws SQLException {
        return flightRepository.findByID(id);
    }

    public void update(Flight flight, Flight flightNew) {
        flightRepository.update(flight, flightNew);
    }

}
