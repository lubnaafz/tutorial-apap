package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.service.RoleService;
import apap.tutorial.emsidi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDetailsPasswordService userDetailsPasswordService;

    @GetMapping(value = "")
    private String listUserPage(Model model){
        List<UserModel> listUser = userService.findAll();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping(value = "/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{username}")
    private String deleteUser(@PathVariable String username,
                              Model model){
        UserModel user = userService.getUserByUsername(username);
        userService.deleteUser(user);
        model.addAttribute("user",user);
        return "delete-user";
    }

    @PostMapping (value = "/update_password")
    private String updatePasswordForm(UserDetails user, Model model){
        String username = user.getUsername();
        model.addAttribute("username", username);
        return "form-update-password";
    }

    @GetMapping(value = "/update_password")
    private String updatePasswordSubmit(UserDetails user, Model model, final HttpServletRequest req){
        String newPassword = String.valueOf(req.getParameter("newPassword"));
        userDetailsPasswordService.updatePassword(user, newPassword);
        return "update-password";
    }
}
