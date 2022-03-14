package group.travelagency.utils;

import java.io.File;

public class Constants {
    public static class Db {
        private static File file = new File("bd.config");
        public static String filename = file.getAbsolutePath();
        public enum Queries {
            ADD,
            DELETE,
            FIND_BY_ID,
            GET_ALL
        }
        public enum Tables {
            FLIGHT,
            LOCATION,
            PURCHASE,
            USER
        }
    }
}
