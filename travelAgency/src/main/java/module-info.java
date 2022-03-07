module group.travelagency {
    requires javafx.controls;
    requires javafx.fxml;


    opens group.travelagency to javafx.fxml;
    exports group.travelagency;
}