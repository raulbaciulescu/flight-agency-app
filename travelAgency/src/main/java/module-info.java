module group.travelagency {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.logging.log4j;

    opens group.travelagency to javafx.fxml;
    exports group.travelagency;
}