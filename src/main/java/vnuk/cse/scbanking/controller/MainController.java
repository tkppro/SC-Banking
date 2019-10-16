package vnuk.cse.scbanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "/base";
    }
    @GetMapping("/login")
    public String login() {
        return "/pages/login";
    }

}
