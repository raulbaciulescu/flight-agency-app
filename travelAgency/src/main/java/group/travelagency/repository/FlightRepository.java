package group.travelagency.repository;

import group.travelagency.domain.Flight;
import group.travelagency.domain.Location;
import group.travelagency.domain.dto.FlightDto;
import group.travelagency.repository.database.FlightTable;
import group.travelagency.repository.database.Table;
import group.travelagency.utils.Constants;
import group.travelagency.utils.Resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightRepository implements Repository<Long, Flight> {
    private final Table<Long, FlightDto> table;

    public FlightRepository() throws SQLException {
        table = (FlightTable) Resources.getTableFactory().getTable(Constants.Db.Tables.FLIGHT);
    }

    @Override
    public void add(Flight flight) {
        FlightDto flightDto = new FlightDto(flight.getStart().getId(), flight.getDestination().getId(), flight.getStartDate(),
                flight.getNrOfSeats());
        flightDto.setId(flight.getId());
        table.add(flightDto);
    }

    @Override
    public void update(Flight entity) {
        //TODO
    }

    @Override
    public Optional<Flight> findByID(Long aLong) throws SQLException {
        Optional<FlightDto> optionalFlightDto = table.findById(aLong);
        if (optionalFlightDto.isPresent()) {
            Optional<Location> start = Resources.getInstance().getLocationRepository().findByID(optionalFlightDto.get().getStartId());
            Optional<Location> destination = Resources.getInstance().getLocationRepository().findByID(optionalFlightDto.get().getDestinationId());
            if (start.isPresent() && destination.isPresent()) {
                Flight flight = new Flight(start.get(), destination.get(),
                        optionalFlightDto.get().getStartDate(), optionalFlightDto.get().getNrOfSeats());
                return Optional.of(flight);
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<Flight> getAll() {
        List<FlightDto> flightDtos = table.getAll();
        List<Flight> flights = new ArrayList<>();
        for (FlightDto flightDto : flightDtos) {
            try {
                Optional<Location> start = Resources.getInstance().getLocationRepository().findByID(flightDto.getStartId());
                Optional<Location> destination = Resources.getInstance().getLocationRepository().findByID(flightDto.getDestinationId());
                if (start.isPresent() && destination.isPresent()) {
                    flights.add(new Flight(start.get(), destination.get(),
                            flightDto.getStartDate(), flightDto.getNrOfSeats())
                    );
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return flights;
    }
}
