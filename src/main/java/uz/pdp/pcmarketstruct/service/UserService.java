package uz.pdp.pcmarketstruct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.pcmarketstruct.entity.User;
import uz.pdp.pcmarketstruct.repository.UserRepository;
import uz.pdp.pcmarketstruct.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public HttpEntity<?> getUser() {

        return ResponseEntity.ok(userRepository.findAll());
    }

    public HttpEntity<?> getByIdUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return ResponseEntity.status(optionalUser.isPresent()? 202:404).body(optionalUser);
    }

    public HttpEntity<?> addUser(User user) {

        return ResponseEntity.ok(userRepository.save(user));

    }

    public HttpEntity<?> editUser(Integer id, User user) {
        Optional<User> userRepositoryById = userRepository.findById(id);
        if (userRepositoryById.isPresent()){
            User editUser = userRepositoryById.get();
            user.setName(editUser.getName());
            user.setPhoneNumber(editUser.getPhoneNumber());
            user.setEmail(editUser.getEmail());
            user.setHomeNumber(editUser.getHomeNumber());
            user.setHomeStreet(editUser.getHomeStreet());
            user.setPassword(editUser.getPassword());

            return ResponseEntity.ok().body(userRepository.save(user));
        }
        return ResponseEntity.status(404).body(userRepositoryById);
    }

    public HttpEntity<?> deleteUser(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        return ResponseEntity.status(byId.isPresent()?202:404).body(byId);

    }



}
