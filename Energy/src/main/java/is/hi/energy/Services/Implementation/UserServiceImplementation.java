package is.hi.energy.Services.Implementation;

import is.hi.energy.Persistence.Entities.User;
import is.hi.energy.Persistence.Repositories.UserRepository;
import is.hi.energy.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public  User save(User user){
        return null;
    }

    @Override
    public void delete(User user){
        userRepository.delete(user);
    }

    @Override
    public List<User>findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public User login(User user){
        return null;
    }

}