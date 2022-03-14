package group.travelagency.domain;

import java.util.List;

public class Purchase extends Entity<Long> {
    private Flight flight;
    private String clientName;
    private String clientAddress;
    private List<String> tourists;
    private int nrOfSeats;

    public Purchase(Flight flight, String clientName, String clientAddress,
                    List<String> tourists, int nrOfSeats) {
        this.flight = flight;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.tourists = tourists;
        this.nrOfSeats = nrOfSeats;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public List<String> getTourists() {
        return tourists;
    }

    public void setTourists(List<String> tourists) {
        this.tourists = tourists;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "flight=" + flight +
                ", clientName='" + clientName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", tourists=" + tourists +
                ", nrOfSeats=" + nrOfSeats +
                '}';
    }
}
