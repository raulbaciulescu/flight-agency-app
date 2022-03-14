package group.travelagency.repository.database;

import group.travelagency.utils.Constants;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TableFactory {
    private final JdbcUtils dbUtils;

    public TableFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(Constants.Db.filename));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config " + e);
        }
        dbUtils = new JdbcUtils(properties);
    }

    public Table<?, ?> getTable(Constants.Db.Tables table) throws SQLException {
        if (table == Constants.Db.Tables.USER)
            return new UserTable(dbUtils.getConnection());
        if (table == Constants.Db.Tables.FLIGHT)
            return new FlightTable(dbUtils.getConnection());
        if (table == Constants.Db.Tables.PURCHASE)
            return new PurchaseTable(dbUtils.getConnection());
        return new LocationTable(dbUtils.getConnection());
    }
}
