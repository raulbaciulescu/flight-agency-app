using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using travelAgency2.src.Domain;

namespace travelAgency2.Repository.Database
{
    internal interface Table<ID, T> where T : Entity<ID>
    {
        void add(T elem);
        void delete(ID id);
        T findById(ID id);
        List<T> getAll();
    }
}
