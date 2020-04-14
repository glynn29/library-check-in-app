package ucmo.project.lib_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ucmo.project.lib_app.repositories.UserRepository;


@Controller
public class MVCController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping({"/"})
    public String welcome() {
        return "index";
    }

    @GetMapping("/checkin")
    public String checkin(){
        return "checkin";
    }
}
