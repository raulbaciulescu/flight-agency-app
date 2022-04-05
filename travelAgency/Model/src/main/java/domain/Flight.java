package domain;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Flight extends Entity<Long> implements Serializable {
    private Location start;
    private Location destination;
    private LocalDateTime startDate;
    private int nrOfSeats;

    public Flight(Long id) {

        this.setId(id);
    }
    public Flight(Location start, Location destination, LocalDateTime startDate, int nrOfSeats) {
        this.start = start;
        this.destination = destination;
        this.startDate = startDate;
        this.nrOfSeats = nrOfSeats;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "start=" + start +
                ", destination=" + destination +
                ", startDate=" + startDate +
                ", nrOfSeats=" + nrOfSeats +
                '}';
    }
}
