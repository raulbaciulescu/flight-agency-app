package group.travelagency.controller;

import group.travelagency.domain.User;
import group.travelagency.repository.UserRepository;
import group.travelagency.service.UserService;
import group.travelagency.utils.Constants;
import group.travelagency.utils.Navigation;
import group.travelagency.utils.Resources;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Optional;

public class LoginController {
    @FXML public TextField txtFieldUsername;
    @FXML public TextField txtFieldPassword;
    @FXML public Button btnLogin;
    @FXML public Text errors;

    UserService userService;

    public LoginController() throws SQLException {
        userService = Resources.getInstance().getUserService();
    }

    public void onBtnLoginClicked(MouseEvent mouseEvent) {
        String username = txtFieldUsername.getText();
        String password = txtFieldPassword.getText();
        errors.setVisible(false);
        try {
            Optional<User> userLoginOptional = userService.findUser(username, password);
            if (userLoginOptional.isPresent()) {
                User user = userLoginOptional.get();
                Resources.getInstance().getLoginService().loginCurrentUser(user);
                Navigation.navigate(Constants.Scene.MAIN, mouseEvent);
            }
            else {
                errors.setVisible(true);
            }
        } catch (SQLException | IOException throwables) {
            errors.setVisible(true);
            throwables.printStackTrace();
        }
    }

}
