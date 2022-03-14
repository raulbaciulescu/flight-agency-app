using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using travelAgency2.Repository.Database;
using travelAgency2.src.Domain;
using travelAgency2.src.Repository;
using travelAgency2.Utils;

namespace travelAgency2.Repository
{
    internal class LocationRepository : Repository<long, Location>
    {
        private Table<long, Location> table;

        public LocationRepository()
        {
            table = (LocationTable) Resources.getTableFactory().getTable(Constants.Db.Tables.LOCATION);
        }

        public void add(Location entity)
        {
            table.add(entity);
        }

        public void delete(long id)
        {
            throw new NotImplementedException();
        }

        public Location findByID(long id)
        {
            return table.findById(id);
        }

        public List<Location> getAll()
        {
            return table.getAll();
        }

        public void update(Location entity)
        {
            throw new NotImplementedException();
        }
    }
}
