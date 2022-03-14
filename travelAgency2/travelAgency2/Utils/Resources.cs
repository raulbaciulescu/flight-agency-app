using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using travelAgency2.Repository;
using travelAgency2.Repository.Database;

namespace travelAgency2.Utils
{


    internal class Resources
    {
        static Resources instance = null;
        private static TableFactory tableFactory;
        private UserRepository userRepository;
        private LocationRepository locationRepository;
        private FlightRepository flightRepository;
        private PurchaseRepository purchaseRepository;

        public static Resources getInstance()
        {
            if (instance == null)
                instance = new Resources();
            return instance;
        }
        private Resources() 
        {
            tableFactory = new TableFactory();
            userRepository = new UserRepository();
            locationRepository = new LocationRepository();
            flightRepository = new FlightRepository();
            purchaseRepository = new PurchaseRepository();
        }

        public LocationRepository getLocationRepository()
        {
            return locationRepository;
        }
        public static TableFactory getTableFactory()
        {
            return tableFactory;
        }

        public UserRepository getUserRepository()
        {
            return userRepository;
        }

        public FlightRepository getFlightRepository()
        {
            return flightRepository;
        }

        public PurchaseRepository getPurchaseRepository()
        {
            return purchaseRepository;
        }
    }
}
