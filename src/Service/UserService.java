package Service;

import Model.User;
import Repository.UserRepository;

import java.util.Optional;

public class UserService {

    private static UserRepository userRepository = UserRepository.getInstance();
    public void addNewUser(User user){
        userRepository.addNewUser(user);
    }

    public Optional<User> findByName(String name){
        return userRepository.findByName(name);
    }
}
