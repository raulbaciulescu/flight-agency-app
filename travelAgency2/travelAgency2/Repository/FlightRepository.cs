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
    internal class FlightRepository : Repository<long, Flight>
    {
        private Table<long, FlightDto> table;

        public FlightRepository()
        {
            table = (FlightTable) Resources.getTableFactory().getTable(Constants.Db.Tables.FLIGHT);
        }

        public void add(Flight flight)
        {
            FlightDto flightDto = new FlightDto(flight.Id, flight.start.Id, flight.destination.Id, flight.startDate,
                flight.nrOfSeats);
            table.add(flightDto);
        }

        public void delete(long id)
        {
            throw new NotImplementedException();
        }

        public Flight findByID(long id)
        {
            FlightDto flightDto = table.findById(id);
            Location start = Resources.getInstance().getLocationRepository().findByID(flightDto.startId);
            Location destination = Resources.getInstance().getLocationRepository().findByID(flightDto.destinationId);
            return new Flight(flightDto.Id, start, destination, flightDto.startDate, flightDto.nrOfSeats);
        }

        public List<Flight> getAll()
        {
            List<FlightDto> flightDtos = table.getAll();
            List<Flight> flights = new List<Flight>();
            foreach (FlightDto flightDto in flightDtos)
            {
                Location start = Resources.getInstance().getLocationRepository().findByID(flightDto.startId);
                Location destination = Resources.getInstance().getLocationRepository().findByID(flightDto.destinationId);
                flights.Add(new Flight(flightDto.Id, start, destination, flightDto.startDate, flightDto.nrOfSeats));
            }
            return flights;
        }

        public void update(Flight entity)
        {
            throw new NotImplementedException();
        }
    }
}
