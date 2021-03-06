package ucmo.project.lib_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ucmo.project.lib_app.models.Role;
import ucmo.project.lib_app.models.User;
import ucmo.project.lib_app.repositories.OrganizationRepository;
import ucmo.project.lib_app.repositories.UserRepository;
import ucmo.project.lib_app.services.ValidatorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;


@Controller
public class MVCController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private ValidatorService validatorService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"/"})
    public String welcome() {
        return "index";
    }

    @GetMapping("/login")
    public String checkin(){
        return "login";
    }

    @GetMapping("/register")
    public String register(User user, Model model){
        //List<Organization> organizationList = organizationRepository.findAll();
        //model.addAttribute("Organizations",organizationList);
        return "register";
    }

    @PostMapping("/register")
//    public String registered(@ModelAttribute("userBody") User userBody, BindingResult result){
    public String registered(@Valid User user, BindingResult result){
        Role role = new Role(3);//id for role_user
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        System.out.println(user.getOrganization().getName());
        validatorService.validate(user,result);
        if (result.hasErrors()) {
            System.out.println(result);
            return "register";
        }
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        System.out.println("registering");

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(){
        return "redirect:/";
    }
}
