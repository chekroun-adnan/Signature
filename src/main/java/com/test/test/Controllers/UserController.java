package com.test.test.Controllers;


import com.test.test.Entities.User;
import com.test.test.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser (@RequestBody User user){
        try {
            userService.createUser(user);
            return ResponseEntity.ok("User Saved Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Eroor " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUser (@RequestParam Long user_id){
        try {
            User user = userService.getUser(user_id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User not Found with the Id : " + user_id);
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllUsers(){
        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
           return ResponseEntity.badRequest().body("NO User Found");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam Long user_id){
        try{
            userService.deleteUser(user_id);
            return ResponseEntity.ok("User with the Id "+ user_id + "Deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User not found with the ID" + user_id);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try{
            userService.updateUser(user);
            return ResponseEntity.ok("User Updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }
}
