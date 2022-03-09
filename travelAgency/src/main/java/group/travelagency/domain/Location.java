package group.travelagency.domain;

public class Location extends Entity<Long> {
    private String name;
    private String airport;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public Location(String name, String airport) {
        this.name = name;
        this.airport = airport;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", airport='" + airport + '\'' +
                '}';
    }
}
