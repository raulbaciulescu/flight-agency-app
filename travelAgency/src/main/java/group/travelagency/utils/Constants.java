package group.travelagency.utils;

import java.io.File;

public class Constants {
    public static class Db {
        private static final File file = new File("bd.config");
        public static String filename = file.getAbsolutePath();
        public enum Queries {
            ADD,
            DELETE,
            FIND_BY_ID,
            GET_ALL,
            FIND2,
            UPDATE
        }
        public enum Tables {
            FLIGHT,
            LOCATION,
            PURCHASE,
            USER
        }
    }

    public final static class Scene {
        public final static String LOG_IN = "login-view.fxml";
        public final static String MAIN = "main-view.fxml";
        public final static String SEARCH = "search-view.fxml";
        public final static String PURCHASE = "purchase-view.fxml";
    }
}
