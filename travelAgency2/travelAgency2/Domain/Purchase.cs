using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace travelAgency2.src.Domain
{
    internal class Purchase : Entity<long>
    {

        public Flight flight { get; set; }
        public string clientName { get; set; }
        public string clientAddress { get; set; }
        public List<string> tourists { get; set; }
        public int nrOfSeats { get; set; }

        public Purchase(long id, Flight flight, string clientName, string clientAddress, List<string> tourists, int nrOfSeats) : base(id)
        {
            this.flight = flight;
            this.clientName = clientName;
            this.clientAddress = clientAddress;
            this.tourists = tourists;
            this.nrOfSeats = nrOfSeats; 
        }
    }
}
