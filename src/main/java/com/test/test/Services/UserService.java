package com.test.test.Services;

import com.test.test.Entities.User;
import com.test.test.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser (User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers (){
        return userRepository.findAll();
    }

    public void deleteUser(Long user_id){
        User existingUser = userRepository.findById(user_id)
                .orElseThrow(()-> new RuntimeException("User Not Found With The ID : " + user_id));
        userRepository.delete(existingUser);
    }

    public User getUser (Long user_id){
        User existingUser = userRepository.findById(user_id)
                .orElseThrow(()-> new RuntimeException("User Not Found with the Id " + user_id));
        return existingUser;
    }

    public void updateUser (User user){
        if (user.getUser_id() != null) {
            Optional<User> existingUserOpt = userRepository.findById(user.getUser_id());
            if (existingUserOpt.isPresent()) {
                User existingUser = existingUserOpt.get();
                 existingUser.setNom(user.getNom());
                 existingUser.setPrenom(user.getPrenom());
                 existingUser.setEmail(user.getEmail());
                 existingUser.setAdresse(user.getAdresse());
                 existingUser.setCode(user.getCode());
                 existingUser.setPass(user.getPass());
                 existingUser.setTelephone(user.getTelephone());
                 existingUser.setDate_naissance(user.getDate_naissance());
                 userRepository.save(existingUser);
            }
        }
    }
}
