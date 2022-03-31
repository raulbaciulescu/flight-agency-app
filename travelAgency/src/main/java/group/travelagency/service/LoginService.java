package group.travelagency.service;

import group.travelagency.domain.User;

public class LoginService {
    private User currentUser = null;


    public User getCurrentUser() {
        return currentUser;
    }

    public void loginCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void logoutCurrentUser() {
        this.currentUser = null;
    }
}
