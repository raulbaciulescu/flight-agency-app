using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using travelAgency2.src.Domain;

namespace travelAgency2.src.Repository
{
    internal interface Repository<ID, T> where T : Entity<ID>
    {
        void add(T entity);
        void update(T entity);
        T findByID(ID id);
        void delete(ID id);
        List<T> getAll();
    }
}
