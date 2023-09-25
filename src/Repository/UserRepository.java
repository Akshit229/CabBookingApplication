package Repository;

import Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
   private List<User> users;

   private static UserRepository userRepository = null;
   private UserRepository(){
       this.users = new ArrayList<>();
   }

   public static UserRepository getInstance(){
       if(userRepository == null) userRepository =  new UserRepository();
       return userRepository;
   }

   public void addNewUser(User user){
       this.users.add(user);
   }

   public Optional<User> findByName(String name){
       return this.users.stream().filter(user -> user.getName().equals(name)).findFirst();
   }
}
