package group.travelagency.service;

import group.travelagency.domain.User;
import group.travelagency.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class UserService {
    private final UserRepository userRepository;
    private final Random random;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.random = new Random();
    }

    public void add(String username, String password, String firstName, String lastName) {
        final long id = random.nextLong();
        User user = new User(username, password, firstName, lastName);
        user.setId(id);
        userRepository.add(user);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findByID(id);
    }

    public Optional<User> findUser(String username, String password) {
        return userRepository.findUser(username, password);
    }
}
