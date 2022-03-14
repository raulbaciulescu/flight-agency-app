﻿using System;
using System.Collections.Generic;
using System.Data.SQLite;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using travelAgency2.Domain.Dto;
using travelAgency2.src.Domain;
using travelAgency2.Utils;

namespace travelAgency2.Repository.Database
{
    internal class FlightTable : Table<long, FlightDto>
    {
        private SQLiteConnection connection;
        private Dictionary<Constants.Db.Queries, SQLiteCommand> statements;
        private static readonly log4net.ILog logger = log4net.LogManager.GetLogger(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);

        public FlightTable(SQLiteConnection connection)
        {
            logger.Info("Initializing FlightTable");
            this.connection = connection;
            this.statements = new Dictionary<Constants.Db.Queries, SQLiteCommand>();
            initStatements();
        }

        void initStatements()
        {

            SQLiteCommand command1 = new SQLiteCommand(connection);
            SQLiteCommand command2 = new SQLiteCommand(connection);
            SQLiteCommand command3 = new SQLiteCommand(connection);
            SQLiteCommand command4 = new SQLiteCommand(connection);
            command1.CommandText = "INSERT INTO flight (id, startId, destinationId, startDate, nrOfSeats) " +
                "VALUES (@id, @startId, @destinationId, @startDate, @nrOfSeats)";
            command2.CommandText = "DELETE * FROM flight WHERE id = @id";
            command3.CommandText = "SELECT * FROM flight WHERE id = @id";
            command4.CommandText = "SELECT * FROM flight";
            statements.Add(Constants.Db.Queries.ADD, command1);
            statements.Add(Constants.Db.Queries.DELETE, command2);
            statements.Add(Constants.Db.Queries.FIND_BY_ID, command3);
            statements.Add(Constants.Db.Queries.GET_ALL, command4);
        }

        public void add(FlightDto flight)
        {
            logger.Info("enter in add flight");
            SQLiteCommand statement = statements[Constants.Db.Queries.ADD];
            try
            {
                statement.Parameters.AddWithValue("@id", flight.Id);
                statement.Parameters.AddWithValue("@startId", flight.startId);
                statement.Parameters.AddWithValue("@destinationId", flight.destinationId);
                statement.Parameters.AddWithValue("@startDate", flight.startDate.ToString());
                statement.Parameters.AddWithValue("@nrOfSeats", flight.nrOfSeats);
                int numberofrowsaffected = statement.ExecuteNonQuery();
                logger.InfoFormat("Saved {0} instances", numberofrowsaffected);
            }
            catch (Exception ex)
            {
                logger.Error(ex);
                Console.WriteLine(ex.Message);
            }
            logger.Info("exit from add flight");
        }
        public void delete(long id)
        {
            //TODO
        }

        public FlightDto findById(long id)
        {
            logger.Info("enter in findById flight");
            List<FlightDto> flights = new List<FlightDto>();
            SQLiteCommand statement = statements[Constants.Db.Queries.FIND_BY_ID];
            statement.Parameters.AddWithValue("@id", id);
            SQLiteDataReader reader = statement.ExecuteReader();
            if (reader.HasRows)
            {
                while (reader.Read())
                {
                    FlightDto flightDto = new FlightDto((long)reader.GetInt64(4),
                        (long)reader.GetInt64(0), (long)reader.GetInt64(1), DateTime.Parse(reader.GetString(2)),
                        reader.GetInt32(3));
                    flights.Add(flightDto);
                }
            }
            reader.Close();
            logger.Info("exit from findById location");
            return flights[0];
        }

        public List<FlightDto> getAll()
        {
            logger.Info("enter in getAll flight");
            List<FlightDto> flights = new List<FlightDto>();
            SQLiteCommand statement = statements[Constants.Db.Queries.GET_ALL];
            SQLiteDataReader reader = statement.ExecuteReader();
            if (reader.HasRows)
            {
                while (reader.Read())
                {
                    FlightDto flightDto = new FlightDto((long)reader.GetInt64(4),
                        (long)reader.GetInt64(0), (long)reader.GetInt64(1), DateTime.Parse(reader.GetString(2)),
                        reader.GetInt32(3));
                    flights.Add(flightDto);
                }
            }
            reader.Close();
            logger.Info("exit from getAll location");
            return flights;
        }
    }
}
