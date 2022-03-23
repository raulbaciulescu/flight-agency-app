package group.travelagency.controller;

import group.travelagency.service.PurchaseService;
import group.travelagency.utils.Constants;
import group.travelagency.utils.Navigation;
import group.travelagency.utils.Resources;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PurchaseController {
    @FXML TextField txtFieldClientName;
    @FXML TextField txtFieldClientAddress;
    @FXML TextField txtFieldNrOfSeats;
    @FXML Button btnBack;
    @FXML Text text;
    @FXML VBox pane;
    @FXML public Text errors;
    private final PurchaseService purchaseService;

    @FXML
    void newFields(){
        HBox hb = new HBox();
        pane.getChildren().add(hb);
        TextField tf = new TextField();
        tf.setPromptText("Name here");
        hb.getChildren().addAll(tf);
    }

    public PurchaseController() throws SQLException {
        purchaseService = Resources.getInstance().getPurchaseService();
    }

    @FXML
    void initialize() throws SQLException {
        text.setText("Flight from " + Resources.getInstance().getSelectedFlight().getStart() + " to " +
                Resources.getInstance().getSelectedFlight().getDestination());
    }

    public void onBackBtnClicked(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Constants.Scene.SEARCH, mouseEvent);
    }

    public void onPurchaseBtnClicked(MouseEvent mouseEvent) throws SQLException {
        errors.setVisible(false);
        List<String> tourists = new ArrayList<>();
        ObservableList<Node> childsVB = pane.getChildren();
        for (Node node: childsVB) {
            HBox hb = (HBox) node;
            ObservableList<Node> childsHB = hb.getChildren();
            TextField tf = (TextField)childsHB.get(0);
            tourists.add(tf.getText());
        }

        String clientName = txtFieldClientName.getText();
        String clientAddress = txtFieldClientAddress.getText();
        int nrOfSeats = Integer.parseInt(txtFieldNrOfSeats.getText());

        try {
            purchaseService.add(Resources.getInstance().getSelectedFlight(), clientName, clientAddress, tourists, nrOfSeats);
        }
        catch (Exception e) {
            errors.setVisible(true);
        }

    }

}
