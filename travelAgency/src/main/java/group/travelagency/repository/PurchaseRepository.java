package group.travelagency.repository;

import group.travelagency.domain.Flight;
import group.travelagency.domain.Location;
import group.travelagency.domain.Purchase;
import group.travelagency.domain.dto.FlightDto;
import group.travelagency.domain.dto.PurchaseDto;
import group.travelagency.repository.database.FlightTable;
import group.travelagency.repository.database.PurchaseTable;
import group.travelagency.repository.database.Table;
import group.travelagency.utils.Constants;
import group.travelagency.utils.Resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PurchaseRepository implements Repository<Long, Purchase> {
    private final Table<Long, PurchaseDto> table;

    public PurchaseRepository() throws SQLException {
        table = (PurchaseTable) Resources.getTableFactory().getTable(Constants.Db.Tables.PURCHASE);
    }

    @Override
    public void add(Purchase purchase) {
        PurchaseDto purchaseDto = new PurchaseDto(purchase.getFlight().getId(), purchase.getClientName(),
                purchase.getClientAddress(), purchase.getTourists(), purchase.getNrOfSeats());
        purchaseDto.setId(purchase.getId());
        table.add(purchaseDto);
    }

    @Override
    public void update(Purchase entity, Purchase newEntity) {
        PurchaseDto purchaseDto = new PurchaseDto(entity.getFlight().getId(), entity.getClientName(), entity.getClientAddress(),
                entity.getTourists(), entity.getNrOfSeats());
        PurchaseDto purchaseDtoNew = new PurchaseDto(newEntity.getFlight().getId(), newEntity.getClientName(), newEntity.getClientAddress(),
                newEntity.getTourists(), newEntity.getNrOfSeats());
        purchaseDto.setId(entity.getId());
        purchaseDtoNew.setId(entity.getId());
        table.update(purchaseDto, purchaseDtoNew);
    }


    @Override
    public Optional<Purchase> findByID(Long aLong) throws SQLException {
        Optional<PurchaseDto> opt = table.findById(aLong);
        if (opt.isPresent()) {
            Optional<Flight> flight = Resources.getInstance().getFlightRepository().findByID(opt.get().getFlightId());
            if (flight.isPresent()) {
                Purchase purchase = new Purchase(flight.get(), opt.get().getClientName(), opt.get().getClientAddress(),
                        opt.get().getTourists(),opt.get().getNrOfSeats());
                return Optional.of(purchase);
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<Purchase> getAll() {
        List<PurchaseDto> purchaseDtos = table.getAll();
        List<Purchase> purchases = new ArrayList<>();
        for (PurchaseDto purchaseDto : purchaseDtos) {
            try {
                Optional<Flight> flight = Resources.getInstance().getFlightRepository().findByID(purchaseDto.getFlightId());
                if (flight.isPresent()) {
                    Purchase purchase = new Purchase(flight.get(), purchaseDto.getClientName(), purchaseDto.getClientAddress(),
                            purchaseDto.getTourists(),purchaseDto.getNrOfSeats());
                    purchases.add(purchase);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return purchases;
    }
}
