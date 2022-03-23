module group.travelagency {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.logging.log4j;

    opens group.travelagency to javafx.fxml;
    exports group.travelagency;
    exports  group.travelagency.controller;
    exports  group.travelagency.domain;
    opens group.travelagency.controller to javafx.fxml;
    opens group.travelagency.domain to javafx.fxml;
}