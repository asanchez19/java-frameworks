package ac.cr.una.springwsrestful.controller;

import ac.cr.una.springwsrestful.model.User;
import ac.cr.una.springwsrestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class WebserviceController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> listUsers = userService.listUsers();

        return  listUsers;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);

        if(user == null) {
            return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity createUser(@RequestBody User user) {

        user = userService.add(user);

        return new ResponseEntity(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteById(id);

        if (!isDeleted) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/users/{id}")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody User user) {

        user = userService.update(id, user);

        if (null == user) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(user, HttpStatus.OK);
    }

}
