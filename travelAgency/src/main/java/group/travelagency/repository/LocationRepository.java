package group.travelagency.repository;

import group.travelagency.domain.Location;
import group.travelagency.domain.dto.FlightDto;
import group.travelagency.repository.database.FlightTable;
import group.travelagency.repository.database.LocationTable;
import group.travelagency.repository.database.Table;
import group.travelagency.utils.Constants;
import group.travelagency.utils.Resources;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LocationRepository implements Repository<Long, Location> {
    private final Table<Long, Location> table;

    public LocationRepository() throws SQLException {
        table = (LocationTable) Resources.getTableFactory().getTable(Constants.Db.Tables.LOCATION);
    }


    @Override
    public void add(Location entity) {
        table.add(entity);
    }

    @Override
    public void update(Location entity, Location newEntity) {

    }

    @Override
    public Optional<Location> findByID(Long aLong) {
        return table.findById(aLong);
    }

    @Override
    public void delete(Long aLong) {
        //TODO
    }

    @Override
    public List<Location> getAll() {
        return table.getAll();
    }
}
