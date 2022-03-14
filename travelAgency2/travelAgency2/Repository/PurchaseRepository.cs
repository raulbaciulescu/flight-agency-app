using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using travelAgency2.Domain.Dto;
using travelAgency2.Repository.Database;
using travelAgency2.src.Domain;
using travelAgency2.src.Repository;
using travelAgency2.Utils;

namespace travelAgency2.Repository
{
    internal class PurchaseRepository : Repository<long, Purchase>
    {
        private Table<long, PurchaseDto> table;

        public PurchaseRepository()
        {
            table = (PurchaseTable)Resources.getTableFactory().getTable(Constants.Db.Tables.PURCHASE);
        }

        public void add(Purchase purchase)
        {
            PurchaseDto purchaseDto = new PurchaseDto(purchase.Id, purchase.flight.Id, purchase.clientName,
                purchase.clientAddress, purchase.tourists, purchase.nrOfSeats);
            table.add(purchaseDto);
        }

        public void delete(long id)
        {
            throw new NotImplementedException();
        }

        public Purchase findByID(long id)
        {
            PurchaseDto purchaseDto = table.findById(id);
            Flight flight = Resources.getInstance().getFlightRepository().findByID(purchaseDto.flightId);
            return new Purchase(purchaseDto.Id, flight, purchaseDto.clientName, purchaseDto.clientAddress,
                purchaseDto.tourists, purchaseDto.nrOfSeats);
        }

        public List<Purchase> getAll()
        {
            List<PurchaseDto> purchaseDtos = table.getAll();
            List<Purchase> purchases = new List<Purchase>();
            foreach (PurchaseDto purchaseDto in purchaseDtos)
            {
                Flight flight = Resources.getInstance().getFlightRepository().findByID(purchaseDto.flightId);
                purchases.Add(new Purchase(purchaseDto.Id, flight, purchaseDto.clientName, purchaseDto.clientAddress,
                    purchaseDto.tourists, purchaseDto.nrOfSeats));
            }
            return purchases;
        }

        public void update(Purchase entity)
        {
            throw new NotImplementedException();
        }
    }
}
