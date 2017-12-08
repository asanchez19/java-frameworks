package ac.cr.una.springmvcdb.controller;

import ac.cr.una.springmvcdb.model.User;
import ac.cr.una.springmvcdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public String list(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @RequestMapping("/user")
    public String getUserById(@RequestParam("id") Long userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        return "user";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String getAddNewUserForm(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "addUser";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String processAddNewUserForm(@ModelAttribute("newUser") User newUser, BindingResult result) {

        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        userService.add(newUser);
        return "redirect:/users";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setAllowedFields("id",
                "firstName",
                "lastName",
                "email");
    }
}
