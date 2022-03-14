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
    internal class UserRepository : Repository<long, User>
    {
        private Table<long, User> table;

        public UserRepository()
        {
            table = (UserTable) Resources.getTableFactory().getTable(Constants.Db.Tables.USER);
         }
           
        public void add(User entity)
        {
            table.add(entity);
        }

        public void delete(long id)
        {
            throw new NotImplementedException();
        }

        public User findByID(long id)
        {
            return table.findById(id);
        }

        public List<User> getAll()
        {
            return table.getAll();
        }

        public void update(User entity)
        {
            throw new NotImplementedException();
        }
    }
}
