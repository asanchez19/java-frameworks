package ac.cr.una.springwsdto.controller;

import ac.cr.una.springwsdto.dto.UserDTO;
import ac.cr.una.springwsdto.model.User;
import ac.cr.una.springwsdto.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest")
public class WebserviceController {

    @Autowired
    UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        List<User> listUsers = userService.listUsers();

        return  listUsers.stream().map(user -> convertToDto(user)).collect(Collectors.toList());
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
    public ResponseEntity createUser(@RequestBody UserDTO userDTO) {

        User user = convertToEntity(userDTO);

        user = userService.add(user);

        return new ResponseEntity(convertToDto(user), HttpStatus.OK);
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

    private UserDTO convertToDto(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        userDTO.setFullName(user.getFirstName().concat(" ").concat(user.getLastName()));
        return userDTO;
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);

        String[] fullName = userDTO.getFullName().split(" ");

        user.setFirstName(fullName[0]);
        user.setLastName(fullName[1]);

        return user;
    }
}
